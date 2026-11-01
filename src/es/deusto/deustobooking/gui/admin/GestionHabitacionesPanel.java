	package es.deusto.deustobooking.gui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.deusto.deustobooking.obj.Habitacion;

public class GestionHabitacionesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

    public GestionHabitacionesPanel() {

    	setLayout(new BorderLayout());

        //Le he pedido ayuda a la IA para organizar mejor esta parte y recomienda crear un panel para poder tener el titulo y los filtros en una misma zona
        JPanel superior = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("Gestión de habitaciones y precios");

        superior.add(titulo, BorderLayout.NORTH);
        superior.add(crearFiltros(), BorderLayout.SOUTH);

        add(superior, BorderLayout.NORTH); 
        crearTabla();
        crearBotones();
        }
    
    private JPanel crearFiltros() {
    	JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	
    	JLabel labelTipo = new JLabel("Tipo :");
    	
    	 //Tipos de habitación
        JComboBox<String> comboTipo = new JComboBox<>(new String[] {
            "Todos",
            "Individual",
            "Doble estándar",
            "Doble superior",
            "Suite"
        });

        //Estados de las habitaciones
        JComboBox<String> comboEstado = new JComboBox<>(new String[] {
            "Todas",
            "Activa",
            "Mantenimiento",
            "Inactiva"
        });

        filtros.add(labelTipo);
        filtros.add(comboTipo);
        filtros.add(comboEstado);
        
        return filtros;
    }
    
    private void crearTabla() {

        String columnas[] = {
            "Nº", "Tipo", "Cap.", "Precio/Noche", "Estado"
        };

        Habitacion[] habitaciones = {
            new Habitacion(101, "Doble estándar", 2, 120, true),
            new Habitacion(102, "Doble estándar", 2, 120, true),
            new Habitacion(201, "Doble superior", 2, 145, true),
            new Habitacion(301, "Suite", 3, 190, false)
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Habitacion h : habitaciones) {

            Object[] fila = {
                h.getNumero(),
                h.getTipo(),
                h.getCapacidad(),
                h.getPrecioNoche(),
                //si la disponibilidad esta a true se muestra "activa", si no se muestra "No disponible"
                h.isDisponible() ? "Activa" : "No disponible"
            };

            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
    

	private void crearBotones() {
	
	    JPanel botones = new JPanel(new GridLayout(1, 4, 10, 0));
	
	    JButton botonNueva = new JButton("Nueva");
	    JButton botonEditar = new JButton("Editar");
	    JButton botonBaja = new JButton("Dar de baja");
	    JButton botonActualizar = new JButton("Actualizar");
	
	    botones.add(botonNueva);
	    botones.add(botonEditar);
	    botones.add(botonBaja);
	    botones.add(botonActualizar);
	
	    add(botones, BorderLayout.SOUTH);
	}

    
    

}
