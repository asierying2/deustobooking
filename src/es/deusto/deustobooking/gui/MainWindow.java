package es.deusto.deustobooking.gui;

import javax.swing.*;
import java.io.Serial;

public class MainWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    
    public MainWindow() {
        setTitle("DeustoBooking");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setVisible(true);
    }
    public static void main(String[] args) {
		new MainWindow();
	}
}
