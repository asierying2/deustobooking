package es.deusto.deustobooking.main;

import java.sql.SQLException;

import es.deusto.deustobooking.db.ConexionBD;
import es.deusto.deustobooking.db.HabitacionesDAO;
import es.deusto.deustobooking.obj.Habitacion;

public class PrincipalBD {

    public static void main(String[] args) {

        ConexionBD conexionBd = new ConexionBD();

        try {

            conexionBd.initBD("resources/db/deustobooking.db");
            conexionBd.crearTablas();

            HabitacionesDAO habDAO = new HabitacionesDAO(conexionBd.getConnection());
            if (habDAO.obtenerHabitaciones().isEmpty()) {

                habDAO.insertarHabitacion(new Habitacion(101, "Doble estándar", 2, 120, true));
                habDAO.insertarHabitacion(new Habitacion(102, "Doble estándar", 2, 120, true));
                habDAO.insertarHabitacion(new Habitacion(201, "Doble superior", 2, 145, true));
                habDAO.insertarHabitacion(new Habitacion(301, "Suite", 3, 190, false));
            }

            System.out.println(habDAO.obtenerHabitaciones());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexionBd.closeBD();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
