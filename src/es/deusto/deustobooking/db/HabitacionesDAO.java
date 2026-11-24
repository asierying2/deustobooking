package es.deusto.deustobooking.db;

import es.deusto.deustobooking.obj.Habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDAO {
    private final Connection con;

    public HabitacionesDAO(Connection con) {
        this.con = con;
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
