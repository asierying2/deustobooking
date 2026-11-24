package es.deusto.deustobooking.main;

import java.sql.SQLException;

import es.deusto.deustobooking.db.BD;
import es.deusto.deustobooking.obj.Habitacion;

public class PrincipalBD {

    public static void main(String[] args) {

        BD bd = new BD();

        try {

            bd.initBD("resources/db/deustobooking.db");
            bd.crearTablas();

            if (bd.obtenerHabitaciones().isEmpty()) {

                bd.insertarHabitacion(new Habitacion(101, "Doble estándar", 2, 120, true));
                bd.insertarHabitacion(new Habitacion(102, "Doble estándar", 2, 120, true));
                bd.insertarHabitacion(new Habitacion(201, "Doble superior", 2, 145, true));
                bd.insertarHabitacion(new Habitacion(301, "Suite", 3, 190, false));
            }

            System.out.println(bd.obtenerHabitaciones());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                bd.closeBD();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
