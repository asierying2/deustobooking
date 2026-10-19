package gui.habitacionesui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import obj.Habitacion;
// le he explicado el proyecto al chat y lo que quiero hacer y le he pedido que me diga mas o menos todo los imports que tengo que hacer,aqui he usado IA para eso

public class HabitacionesWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private List<Habitacion> habitaciones;
    private List<Habitacion> visibles = new ArrayList<>();
    private JSpinner huespedes = new JSpinner(new SpinnerNumberModel(2, 1, 10, 1));
    private JSpinner noches = new JSpinner(new SpinnerNumberModel(3, 1, 365, 1));
    private JCheckBox soloDisponibles = new JCheckBox("Solo disponibles", true);
    private JLabel seleccion = new JLabel("Selecciona una habitación.");
    private JLabel total = new JLabel("Total estancia: —");
    private JLabel estado = new JLabel();
    private JButton resumen = new JButton("Ver resumen");
    private DefaultTableModel modelo = new DefaultTableModel(
            new String[] {"N.º", "Tipo", "Capacidad", "Precio / noche (€)", "Disponible"}, 0) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int fila, int columna) { return false; }

    };
    private JTable tabla = new JTable(modelo);

    public HabitacionesWindow(String hotel, List<Habitacion> habitaciones) {
        this.habitaciones = new ArrayList<>(habitaciones);
        setTitle("DeustoBooking - Habitaciones");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel principal = new JPanel(new BorderLayout(12, 12));
        principal.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        setContentPane(principal);

        JPanel cabecera = new JPanel(new GridLayout(0, 1, 0, 8));
        cabecera.add(new JLabel("Habitaciones de " + hotel));
        cabecera.add(new JLabel("Prototipo: una habitación por selección. Datos de ejemplo sin consulta por fechas."));
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtros.add(new JLabel("Huéspedes:"));
        filtros.add(huespedes);
        filtros.add(new JLabel("Noches:"));
        filtros.add(noches);
        filtros.add(soloDisponibles);
        cabecera.add(filtros);
        principal.add(cabecera, BorderLayout.NORTH);

        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(28);
        tabla.setFillsViewportHeight(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        principal.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel pie = new JPanel(new GridLayout(0, 1, 0, 8));
        pie.add(seleccion);
        pie.add(total);
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        botones.add(cerrar);
        botones.add(resumen);
        pie.add(botones);
        pie.add(estado);
        principal.add(pie, BorderLayout.SOUTH);

        huespedes.addChangeListener(e -> cargarTabla());
        soloDisponibles.addActionListener(e -> cargarTabla());
        noches.addChangeListener(e -> actualizarSeleccion());
        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) actualizarSeleccion();
        });
        resumen.addActionListener(e -> mostrarResumen());
        cargarTabla();
        setMinimumSize(new Dimension(760, 460));
        setSize(820, 520);
        setLocationRelativeTo(null);
    }

    private void cargarTabla() {
        tabla.clearSelection();
        modelo.setRowCount(0);
        visibles.clear();
        int personas = (Integer) huespedes.getValue();
        for (Habitacion h : habitaciones) {
            if (h.getCapacidad() < personas) {
                continue;
            }
            if (soloDisponibles.isSelected() && !h.isDisponible()) {
                continue;
            }

            String disponible = "No";
            if (h.isDisponible()) {
                disponible = "Sí";
            }
            visibles.add(h);
            modelo.addRow(new Object[] {h.getNumero(), h.getTipo(), h.getCapacidad(),
                    h.getPrecioNoche(), disponible});
        }
        if (visibles.isEmpty()) {
            estado.setText("No hay habitaciones con estos filtros.");
        } else {
            estado.setText(visibles.size() + " habitaciones encontradas.");
        }
        actualizarSeleccion();
    }

    private Habitacion getSeleccionada() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            return null;
        }
        return visibles.get(fila);
    }

    private void actualizarSeleccion() {
        Habitacion h = getSeleccionada();
        if (h == null) {
            resumen.setEnabled(false);
            seleccion.setText("Selecciona una habitación.");
            total.setText("Total estancia: —");
        } else {
            resumen.setEnabled(h.isDisponible());
            seleccion.setText("Seleccionada: " + h);
            int numeroNoches = (Integer) noches.getValue();
            double importe = h.calcularImporte(numeroNoches);
            total.setText("Total estancia: " + importe + " €");
        }
    }

    private void mostrarResumen() {
        try {

            huespedes.commitEdit();
            noches.commitEdit();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Introduce huéspedes entre 1 y 10 y noches entre 1 y 365.",
                    "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Habitacion h = getSeleccionada();
        if (h == null || !h.isDisponible()) {
            JOptionPane.showMessageDialog(this, "Selecciona una habitación disponible.");
            return;
        }
        //Codigo generado con IA
        JOptionPane.showMessageDialog(this, h + "\nHuéspedes: " + huespedes.getValue()
                + "\nNoches: " + noches.getValue() + "\nTotal: "
                + h.calcularImporte((Integer) noches.getValue()) + " €"
                + "\n\nVista previa. No se ha creado ninguna reserva.",
                "Resumen de la estancia", JOptionPane.INFORMATION_MESSAGE);
    }
}
