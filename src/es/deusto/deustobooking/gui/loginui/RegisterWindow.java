package es.deusto.deustobooking.gui.loginui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serial;

public class RegisterWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public RegisterWindow() {
        setTitle("Registro a DeustoBooking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        
       
        JLabel titleHeader = new JLabel("Ventana para la creación de cuenta, si ya tiene una, inicie sesión.", SwingConstants.CENTER);  
        titleHeader.setFont(titleHeader.getFont().deriveFont(Font.BOLD));
        titleHeader.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        
        //Creación de componentes
        JButton createAccButton = new JButton("Crear cuenta");
        JButton cancelButton = new JButton("Cancelar");
        
        JLabel nameField = new JLabel("Correo electrónico: ");
        JTextField nameEmail = new JTextField(30);

        JLabel passwordLabel = new JLabel("Contraseña (máximo 22 caracteres): ");
        JPasswordField password = new JPasswordField(22);
        
        JLabel passwordRLabel = new JLabel("Repita la contraseña: ");
        JPasswordField passwordR = new JPasswordField(22);
        
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        c.insets = new Insets(10, 10, 10, 10); 
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 0;
        loginPanel.add(nameField, c);

        c.gridx = 1;
        c.gridy = 0;
        loginPanel.add(nameEmail, c);

        c.gridx = 0;
        c.gridy = 1;
        loginPanel.add(passwordLabel, c);
        
        c.gridx = 1;
        c.gridy = 1;
        loginPanel.add(password, c);
        
        c.gridx = 0;
        c.gridy = 2;
        loginPanel.add(passwordRLabel, c);
        
        c.gridx = 1;
        c.gridy = 2;
        loginPanel.add(passwordR, c);
        
        buttonPanel.add(createAccButton);
        buttonPanel.add(cancelButton);

        // Asignación de los componentes a la ventana principal
        this.add(titleHeader, BorderLayout.NORTH);
        this.add(loginPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterWindow();
    }
}