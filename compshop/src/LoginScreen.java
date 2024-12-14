import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen {
    public LoginScreen(CardLayout cardLayout, JPanel mainPanel) {
        super(cardLayout, mainPanel);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if ("pchub".equals(username) && "pchub".equals(password)) {
                navigateTo("MainMenu");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        add(new JLabel("Login to PC HUB", SwingConstants.CENTER), BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
