package es.deusto.deustobooking.gui;

import javax.swing.*;
import java.io.Serial;

public class MainWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    
    public MainWindow() {

        EstiloVentanas.prepararVentana(this, "Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        
        setVisible(true);
    }
    public static void main(String[] args) {
		new MainWindow();
	}
}
