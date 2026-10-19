package main;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import gui.habitacionesui.HabitacionesWindow;
import obj.Habitacion;


public class MainHabitaciones {
    public static void main(String[] args) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(101, "Doble estándar", 2, 120, true));
        habitaciones.add(new Habitacion(102, "Doble estándar", 2, 120, true));
        habitaciones.add(new Habitacion(201, "Doble superior", 2, 145, true));
        habitaciones.add(new Habitacion(301, "Suite", 3, 190, false));
        //codigo generado con IA, lo de el swing , que le pregunte como hacerlo y lo generó
        SwingUtilities.invokeLater(() -> {
            HabitacionesWindow ventana = new HabitacionesWindow("Hotel Carlton (ejemplo)", habitaciones);
            ventana.setVisible(true);
        });
    }
}
