package es.deusto.deustobooking.db;

import es.deusto.deustobooking.obj.Reserva;

import java.sql.Connection;
import java.sql.SQLException;

public class ReservaDAO {
    private final Connection conn;

    public ReservaDAO(Connection conn) {
        this.conn = conn;
    }

    public void anadirReserva(Reserva r) throws SQLException {
        String sqlStatement = "INSERT INTO Reserva VALUES (?, ?, ?, ?, ?)";


    }
}
