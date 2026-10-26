package es.deusto.deustobooking.gui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class AdminWindow  extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public AdminWindow() {
		setTitle("DeustoBooking - Administrador");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		crearMenu();
		//Para probar las diferentes interfaces de admin cambiar esta linea
		add(new ResumenAdminPanel(), BorderLayout.CENTER);
		
	};
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
            AdminWindow ventana = new AdminWindow();
            ventana.setVisible(true);
        });
		
	}
	
	public void crearMenu() {
		
		JPanel menu = new JPanel();
		
		//poner botones a la izquierda
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JButton botonResumen = new JButton("Resumen");
	    JButton botonHabitaciones = new JButton("Habitaciones");
	    JButton botonReservas = new JButton("Reservas");
	    JButton botonOcupacion = new JButton("Ocupación");
	    JButton botonCerrarSesion = new JButton("Cerrar sesión");
	    
	    menu.add(botonResumen);
	    menu.add(botonHabitaciones);
	    menu.add(botonReservas);
	    menu.add(botonOcupacion);
	    menu.add(botonCerrarSesion);
	    
	    add(menu, BorderLayout.NORTH);
	}
  
}
