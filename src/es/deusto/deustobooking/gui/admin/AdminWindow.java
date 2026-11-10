package es.deusto.deustobooking.gui.admin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class AdminWindow  extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private CardLayout cardLayout;
	private JPanel panelCentral;
	
	public AdminWindow() {
		setTitle("DeustoBooking - Administrador");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		crearMenu();
		
		cardLayout = new CardLayout();
		panelCentral = new JPanel(cardLayout);
		
		panelCentral.add(new ResumenAdminPanel(), "Resumen");
		panelCentral.add(new GestionHabitacionesPanel(), "Habitaciones");
		
		add(panelCentral, BorderLayout.CENTER);
		
		//empezar con resumen
		cardLayout.show(panelCentral, "Resumen");
		
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
	    
	    ArrayList<JButton> botones = new ArrayList<>();

	    botones.add(botonResumen);
	    botones.add(botonHabitaciones);
	    botones.add(botonReservas);
	    botones.add(botonOcupacion);
	    
		 botonResumen.addActionListener(e -> {
		     cardLayout.show(panelCentral, "Resumen");
		     seleccionarBoton(botonResumen, botones);
		 });
	
		 botonHabitaciones.addActionListener(e -> {
		     cardLayout.show(panelCentral, "Habitaciones");
		     seleccionarBoton(botonHabitaciones, botones);
		 });
		  
	    menu.add(botonResumen);
	    menu.add(botonHabitaciones);
	    menu.add(botonReservas);
	    menu.add(botonOcupacion);
	    menu.add(botonCerrarSesion);
	    
	    add(menu, BorderLayout.NORTH);
	    
	    botonResumen.setEnabled(false);
	}

	private void seleccionarBoton(JButton seleccionado, ArrayList<JButton> botones) {
	
	    for (JButton boton : botones) {
	        boton.setEnabled(true);
	    }
	
	    seleccionado.setEnabled(false);
	}

}
