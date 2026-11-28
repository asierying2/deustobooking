package es.deusto.deustobooking.gui.admin;

import es.deusto.deustobooking.gui.EstiloVentanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResumenAdminPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final int COL_RESERVA = 0;
    private static final int COL_MOVIMIENTO = 3;
    private static final String CANCELACION = "Cancelación";
    // Estado al que vuelve una reserva que ya estaba cancelada al abrir la ventana
    private static final String ESTADO_POR_DEFECTO = "Nueva reserva";

    // Guarda el movimiento anterior de cada reserva cancelada
    private final Map<String, String> estadoAnterior = new HashMap<>();

    private JTable tabla;
    private JLabel contador;
    private JButton botonVer;
    private JButton botonCancelar;

    public ResumenAdminPanel() {

        setLayout(new BorderLayout(0, 8));

        // Titulo
        add(new JLabel("Resumen del administrador"), BorderLayout.NORTH);

        // Datos de ejemplo
        JPanel datos = new JPanel(new GridLayout(1, 3));

        datos.add(new JLabel("Habitaciones ocupadas: 18/30"));
        datos.add(new JLabel("Ocupación: 60%"));
        contador = new JLabel();
        datos.add(contador);

        // Tabla de actividad reciente
        String[] columnas = {"Reserva", "Cliente", "Habitacion", "Movimiento"};

        Object[][] filas = {
            {"DB-1042", "Ana Garcia", "Doble", "Nueva reserva"},
            {"DB-1039", "Iker Perez", "Suite", "Modificación"},
            {"DB-1031", "Leire Ruiz", "Doble", "Cancelación"}
        };

        tabla = new JTable(filas, columnas);
        EstiloVentanas.prepararTabla(tabla);
        actualizarContador();

        botonVer = new JButton("Ver reserva");
        botonVer.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Cliente: " + tabla.getValueAt(fila, 1)
                        + "\nHabitación: " + tabla.getValueAt(fila, 2)
                        + "\nMovimiento: " + tabla.getValueAt(fila, 3));
            }
        });

        // Este botón cancela o restaura según el estado de la fila seleccionada
        botonCancelar = new JButton("Cancelar reserva");
        botonCancelar.addActionListener(e -> cancelarORestaurar());

        // Cambiar el texto del botón al seleccionar otra fila
        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                actualizarBoton();
            }
        });

        JPanel centro = new JPanel(new BorderLayout(0, 8));
        centro.add(datos, BorderLayout.NORTH);
        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        JPanel botones = EstiloVentanas.crearBarraBotones();
        // Margen inferior para subir los botones (ajusta el 15 a tu gusto)
        botones.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        botones.add(botonVer);
        botones.add(botonCancelar);

        add(botones, BorderLayout.SOUTH);
    }

    private void cancelarORestaurar() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una reserva");
            return;
        }

        String id = (String) tabla.getValueAt(fila, COL_RESERVA);
        String actual = (String) tabla.getValueAt(fila, COL_MOVIMIENTO);

        if (CANCELACION.equals(actual)) {
            // Restaurar: recuperamos el estado guardado (o el de por defecto)
            String previo = estadoAnterior.remove(id);
            tabla.setValueAt(previo != null ? previo : ESTADO_POR_DEFECTO, fila, COL_MOVIMIENTO);
        } else {
            // Cancelar: guardamos el estado actual antes de sobrescribirlo
            estadoAnterior.put(id, actual);
            tabla.setValueAt(CANCELACION, fila, COL_MOVIMIENTO);
        }

        actualizarContador();
        actualizarBoton();
    }

    private void actualizarBoton() {
        int fila = tabla.getSelectedRow();
        boolean cancelada = fila != -1
                && CANCELACION.equals(tabla.getValueAt(fila, COL_MOVIMIENTO));

        botonCancelar.setText(cancelada ? "Restaurar reserva" : "Cancelar reserva");
    }

    private void actualizarContador() {

        int activas = 0;

        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (!CANCELACION.equals(tabla.getValueAt(i, COL_MOVIMIENTO))) {
                activas++;
            }
        }

        contador.setText("Reservas activas: " + activas);
    }

}