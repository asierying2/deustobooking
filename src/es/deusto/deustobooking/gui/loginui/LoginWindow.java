package es.deusto.deustobooking.gui.loginui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class LoginWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public LoginWindow() {
        setTitle("Bienvenido/a a DeustoBooking");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);

        /* Suggestion from ChatGPT: for the layout we want from drafts, we need to use GridBagLayout
        * that creates an invisible, flexible grid (similar to GridLayout, but flexible size)
        * and GridBagConstraints that controls that layout and the components inside them
        * GridBagLayout indirectly supports insets (spacing around components in grid cells
        * through GridBagConstraints), while GridLayout forces components to fill the whole grid
        */
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel nameField = new JLabel("Correo electrónico/Usuario: ");
        JTextField nameEmail = new JTextField(22);

        JLabel passwordLabel = new JLabel("Contraseña: ");
        JPasswordField password = new JPasswordField(22);

        JButton loginButton = new JButton("Iniciar sesión");
        JButton registerButton = new JButton("Registrar...");
        JButton cancelButton = new JButton("Cancelar");

        // Properties of generic GridBagConstraints: insets -> spacing between components
        // Anchor -> placement of the component inside grid
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;

        // Username/Email in 0, 0
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

        // Functionality of the buttons
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
//                dispose();            When we have a functionality on the interface
            }
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        this.add(loginPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    static void main(String[] args) {
        new LoginWindow();
    }
}
