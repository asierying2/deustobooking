package es.deusto.deustobooking.gui.loginui;

import javax.swing.*;
import java.io.Serial;

public class RegisterWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public RegisterWindow() {
        setTitle("Registro a DeustoBooking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
    }
}
