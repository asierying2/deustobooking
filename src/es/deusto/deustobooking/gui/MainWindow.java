package es.deusto.deustobooking.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.deusto.deustobooking.gui.admin.AdminWindow;
import es.deusto.deustobooking.gui.loginui.LoginWindow;

public class MainWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public MainWindow() {

        JPanel contenido = EstiloVentanas.prepararVentana(this, "Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel labelPregunta = new JLabel("¿Cómo desea acceder?", SwingConstants.CENTER);
        labelPregunta.setFont(labelPregunta.getFont().deriveFont(Font.BOLD, 16f));

        JButton botonAdmin = new JButton("Administrador");
        JButton botonCliente = new JButton("Cliente");
        botonAdmin.setPreferredSize(new Dimension(200, 45));
        botonCliente.setPreferredSize(new Dimension(200, 45));

        botonAdmin.addActionListener(e -> {
            dispose();
            new AdminWindow().setVisible(true);
        });

        botonCliente.addActionListener(e -> {
            dispose();
            new LoginWindow();
        });

        
        JPanel centro = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // Insets deja un margen alrededor del componente del GridBagConstraints
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;

        c.gridy = 0;
        centro.add(labelPregunta, c);
        c.gridy = 1;
        centro.add(botonAdmin, c);
        c.gridy = 2;
        centro.add(botonCliente, c);

        contenido.add(centro, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}