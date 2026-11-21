package es.deusto.deustobooking.gui.loginui;

import es.deusto.deustobooking.gui.EstiloVentanas;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class RegisterWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public RegisterWindow() {

        JPanel contenido = EstiloVentanas.prepararVentana(this, "Crear cuenta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
       
        
        //Creación de componentes
        JButton iniSeButton = new JButton("Iniciar sesión");
        JButton createAccButton = new JButton("Crear cuenta");
        JButton cancelButton = new JButton("Cancelar");
        
        JLabel nombreLabel = new JLabel("Nombre: ");
        JTextField nombre = new JTextField(26);

        JLabel apellidosLabel = new JLabel("Apellidos: ");
        JTextField apellidos = new JTextField(26);
        
        JLabel emailField = new JLabel("Correo electrónico: ");
        JTextField email = new JTextField(26);

        JLabel passwordLabel = new JLabel("Contraseña (máximo 22 caracteres): ");
        JPasswordField password = new JPasswordField(26);
        
        JLabel passwordRLabel = new JLabel("Repita la contraseña: ");
        JPasswordField passwordR = new JPasswordField(26);
        
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel buttonPanel = EstiloVentanas.crearBarraBotones();
        
        c.insets = new Insets(5, 5, 5, 5); 
        c.anchor = GridBagConstraints.WEST;
        
        c.gridx = 0;
        c.gridy = 0;
        loginPanel.add(nombreLabel, c);
        
        c.gridx = 1;
        c.gridy = 0;
        loginPanel.add(nombre, c);
        
        c.gridx = 0;
        c.gridy = 1;
        loginPanel.add(apellidosLabel, c);
        
        c.gridx = 1;
        c.gridy = 1;
        loginPanel.add(apellidos, c);
        
        c.gridx = 0;
        c.gridy = 2;
        loginPanel.add(emailField, c);

        c.gridx = 1;
        c.gridy = 2;
        loginPanel.add(email, c);

        c.gridx = 0;
        c.gridy = 3;
        loginPanel.add(passwordLabel, c);
        
        c.gridx = 1;
        c.gridy = 3;
        loginPanel.add(password, c);
        
        c.gridx = 0;
        c.gridy = 4;
        loginPanel.add(passwordRLabel, c);
        
        c.gridx = 1;
        c.gridy = 4;
        loginPanel.add(passwordR, c);
        
        iniSeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginWindow();
                dispose();
            }
        });
        
        buttonPanel.add(iniSeButton);
        buttonPanel.add(createAccButton);
        buttonPanel.add(cancelButton);

        // Asignación de los componentes a la ventana principal
        contenido.add(loginPanel, BorderLayout.CENTER);
        contenido.add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new RegisterWindow();
    }
}