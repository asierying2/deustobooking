package es.deusto.deustobooking.gui.admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResumenAdminPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public ResumenAdminPanel() {

        setLayout(new BorderLayout());

        // Titulo
        add(new JLabel("Resumen del administrador"), BorderLayout.NORTH);

        // Datos de ejemplo
        JPanel datos = new JPanel(new GridLayout(1, 3));

        datos.add(new JLabel("Habitaciones ocupadas: 18/30"));
        datos.add(new JLabel("Ocupacion: 60%"));
        JLabel contador = new JLabel();
        datos.add(contador);

        // Tabla de actividad reciente
        String[] columnas = {"Reserva", "Cliente", "Habitacion", "Movimiento"};

        Object[][] filas = {
            {"DB-1042", "Ana Garcia", "Doble", "Nueva reserva"},
            {"DB-1039", "Iker Perez", "Suite", "Modificacion"},
            {"DB-1031", "Leire Ruiz", "Doble", "Cancelacion"}
        };

        JTable tabla = new JTable(filas, columnas);
        actualizarContador(tabla, contador);
        JButton botonVer = new JButton("Ver reserva");
        botonVer.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Cliente: " + tabla.getValueAt(fila, 1)
                        + "\nHabitacion: " + tabla.getValueAt(fila, 2));
            }
        });

        JButton botonCancelar = new JButton("Cancelar reserva");

        botonCancelar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva");
            } else {
                tabla.setValueAt("Cancelacion", fila, 3);
                actualizarContador(tabla, contador);
            }
        });

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(datos, BorderLayout.NORTH);
        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);
        JPanel botones = new JPanel();

        botones.add(botonVer);
        botones.add(botonCancelar);

        add(botones, BorderLayout.SOUTH);
    }
    private void actualizarContador(JTable tabla, JLabel contador) {

        int activas = 0;

        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (!"Cancelacion".equals(tabla.getValueAt(i, 3))) {
                activas++;
            }
        }

        contador.setText("Reservas activas: " + activas);
    }

}
