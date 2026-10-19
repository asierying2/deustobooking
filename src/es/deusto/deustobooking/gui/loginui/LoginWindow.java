package gui.loginui;

import javax.swing.*;
import java.awt.*;
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
        * that creates invisible tables (similar to GridLayout)
        * and GridBagConstraints that controls that layout
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

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        this.add(loginPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    //FUENTE-EXTERNA
    //URL: OpenAI ChatGPT / Codex
    //ADAPTADO: punto de entrada público y creación de la ventana en el hilo de Swing.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}
