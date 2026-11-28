package es.deusto.deustobooking.db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import es.deusto.deustobooking.obj.Reserva;

import java.sql.Connection;
import java.sql.SQLException;

public class ReservaDAO {
    private final Connection conn;

    public ReservaDAO(Connection conn) {
        this.conn = conn;
    }

    public void anadirReserva(Reserva r) throws SQLException {
        String sqlStatement = "INSERT INTO Reserva VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlStatement)) {
            ps.setString(1, r.getCodigo());
            ps.setString(2, r.getCliente());
            ps.setInt(3, r.getNumeroHabitacion());
            ps.setString(4, r.getFechaEntrada());
            ps.setString(5, r.getFechaSalida());
            ps.setBoolean(6, r.isCancelada());

            ps.executeUpdate();
        }


    }
    //FUENTE-EXTERNA
    //URL: ChatGPT
    //SIN-CAMBIOS
    public List<Reserva> obtenerReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";

        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getString("codigo"),
                        rs.getString("cliente"),
                        rs.getInt("numeroHabitacion"),
                        rs.getString("fechaEntrada"),
                        rs.getString("fechaSalida"),
                        rs.getBoolean("cancelada"));

                reservas.add(r);
            }
        }

        return reservas;
    }

    public boolean cambiarEstadoReserva(String codigo, boolean cancelada) throws SQLException {
        String sql = "UPDATE Reserva SET cancelada = ? WHERE codigo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, cancelada);
            ps.setString(2, codigo);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean borrarReserva(String codigo) throws SQLException {
        String sql = "DELETE FROM Reserva WHERE codigo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);

            return ps.executeUpdate() > 0;
        }
    }
}
