

package es.deusto.deustobooking.gui.admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
        datos.add(new JLabel("Llegadas previstas: 5"));

        // Tabla de actividad reciente
        String[] columnas = {"Reserva", "Cliente", "Habitacion", "Movimiento"};

        Object[][] filas = {
            {"DB-1042", "Ana Garcia", "Doble", "Nueva reserva"},
            {"DB-1039", "Iker Perez", "Suite", "Modificacion"},
            {"DB-1031", "Leire Ruiz", "Doble", "Cancelacion"}
        };

        JTable tabla = new JTable(filas, columnas);

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(datos, BorderLayout.NORTH);
        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);
        add(new JLabel("Datos de ejemplo"), BorderLayout.SOUTH);
    }
}
