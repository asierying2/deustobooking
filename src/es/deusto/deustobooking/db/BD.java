
package es.deusto.deustobooking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.deustobooking.obj.Habitacion;

public class BD {

    private Connection con;

    public void initBD(String nombreBD)
            throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

        try (PreparedStatement ps = con.prepareStatement("PRAGMA foreign_keys = ON;")) {
            ps.execute();
        }
    }

    public void closeBD() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public void crearTablas() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Habitacion ("
                + "numero INTEGER PRIMARY KEY,"
                + "tipo TEXT,"
                + "capacidad INTEGER,"
                + "precioNoche REAL,"
                + "disponible INTEGER);";

        String sql2 = "CREATE TABLE IF NOT EXISTS Reserva ("
                + "codigo TEXT PRIMARY KEY,"
                + "cliente TEXT,"
                + "numeroHabitacion INTEGER NOT NULL,"
                + "fechaEntrada TEXT,"
                + "fechaSalida TEXT,"
                + "cancelada INTEGER DEFAULT 0,"
                + "FOREIGN KEY (numeroHabitacion) REFERENCES Habitacion(numero));";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        }

        try (PreparedStatement ps = con.prepareStatement(sql2)) {
            ps.execute();
        }
    }

    public void insertarHabitacion(Habitacion h) throws SQLException {

        String sql = "INSERT INTO Habitacion VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, h.getNumero());
            ps.setString(2, h.getTipo());
            ps.setInt(3, h.getCapacidad());
            ps.setDouble(4, h.getPrecioNoche());
            ps.setBoolean(5, h.isDisponible());

            ps.executeUpdate();
        }
    }

    public List<Habitacion> obtenerHabitaciones() throws SQLException {

        List<Habitacion> habitaciones = new ArrayList<Habitacion>();

        String sql = "SELECT * FROM Habitacion ORDER BY numero;";

        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int numero = rs.getInt("numero");
                String tipo = rs.getString("tipo");
                int capacidad = rs.getInt("capacidad");
                double precio = rs.getDouble("precioNoche");
                boolean disponible = rs.getBoolean("disponible");

                Habitacion h = new Habitacion(numero, tipo, capacidad, precio, disponible);

                habitaciones.add(h);
            }
        }

        return habitaciones;
    }
}
