package main;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import gui.habitacionesui.HabitacionesWindow;
import obj.Habitacion;


public class MainHabitaciones {
    public static void main(String[] args) {
    	ArrayList<Habitacion> habitaciones = new ArrayList<>();

    	//Capacidad: 1 persona
    	habitaciones.add(new Habitacion(101, "Individual estándar", 1, 60, true));
    	habitaciones.add(new Habitacion(102, "Individual estándar", 1, 60, true));
    	habitaciones.add(new Habitacion(103, "Individual superior", 1, 65, false));
    	habitaciones.add(new Habitacion(104, "Individual superior", 1, 65, true));

    	//Capacidad: 2 personas
    	habitaciones.add(new Habitacion(201, "Doble estándar", 2, 110, true));
    	habitaciones.add(new Habitacion(202, "Doble estándar", 2, 110, true));
    	habitaciones.add(new Habitacion(203, "Doble superior", 2, 120, false));
    	habitaciones.add(new Habitacion(204, "Doble superior", 2, 120, true));

    	//Capacidad: 3 personas
    	habitaciones.add(new Habitacion(301, "Triple estándar", 3, 150, true));
    	habitaciones.add(new Habitacion(302, "Triple estándar", 3, 150, false));
    	habitaciones.add(new Habitacion(303, "Triple superior", 3, 160, true));
    	habitaciones.add(new Habitacion(304, "Triple superior", 3, 160, true));

    	//Capacidad: 4 personas
    	habitaciones.add(new Habitacion(401, "Suite", 4, 220, true));
    	habitaciones.add(new Habitacion(402, "Suite", 4, 220, true));
    	habitaciones.add(new Habitacion(403, "Suite", 4, 250, false));
    	habitaciones.add(new Habitacion(404, "Suite", 4, 250, true));
        
        //codigo generado con IA, lo de el swing , que le pregunte como hacerlo y lo generó
        SwingUtilities.invokeLater(() -> {
            HabitacionesWindow ventana = new HabitacionesWindow("Hotel Carlton (ejemplo)", habitaciones);
            ventana.setVisible(true);
        });
    }
}
