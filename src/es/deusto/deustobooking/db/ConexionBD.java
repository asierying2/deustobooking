
package es.deusto.deustobooking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {

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

    public Connection getConnection() {
        return con;
    }

    public void crearTablas() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Habitacion ("
                + "numero INTEGER PRIMARY KEY,"
                + "idHotel INTEGER NOT NULL,"
                + "tipo TEXT,"
                + "capacidad INTEGER,"
                + "precioNoche REAL,"
                + "disponible INTEGER,"
                + "FOREIGN KEY (idHotel) REFERENCES Hotel (id));";

        String sql2 = "CREATE TABLE IF NOT EXISTS Reserva ("
                + "codigo TEXT PRIMARY KEY,"
                + "cliente TEXT,"
                + "numeroHabitacion INTEGER NOT NULL,"
                + "fechaEntrada TEXT,"
                + "fechaSalida TEXT,"
                + "cancelada INTEGER DEFAULT 0,"
                + "FOREIGN KEY (numeroHabitacion) REFERENCES Habitacion(numero));";

        String sql3 = """
                CREATE TABLE IF NOT EXISTS Hotel (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                ciudad TEXT,
                estado_prov TEXT,
                pais TEXT NOT NULL);
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        }

        try (PreparedStatement ps = con.prepareStatement(sql2)) {
            ps.execute();
        }
        
        try (PreparedStatement ps = con.prepareStatement(sql3)) {
            ps.execute();
        }
    }
}
