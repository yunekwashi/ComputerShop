import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class ProfileScreen extends Screen {
    private static final String PROFILE_FILE = "profile.txt";

    public ProfileScreen(CardLayout cardLayout, JPanel mainPanel) {
        super(cardLayout, mainPanel);

        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Profile Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Input fields
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        add(formPanel, BorderLayout.CENTER);

        // Load profile data from file (if available)
        loadProfileData(nameField, emailField, phoneField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton backButton = new JButton("Back");

        saveButton.addActionListener(e -> saveProfileData(nameField.getText(), emailField.getText(), phoneField.getText()));

        backButton.addActionListener(e -> navigateTo("MainMenu"));

        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Loads profile data from the `profile.txt` file and populates the input fields.
     * @param nameField the text field for the name.
     * @param emailField the text field for the email.
     * @param phoneField the text field for the phone number.
     */
    private void loadProfileData(JTextField nameField, JTextField emailField, JTextField phoneField) {
        File file = new File(PROFILE_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextLine()) nameField.setText(scanner.nextLine());
                if (scanner.hasNextLine()) emailField.setText(scanner.nextLine());
                if (scanner.hasNextLine()) phoneField.setText(scanner.nextLine());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading profile data: " + ex.getMessage());
            }
        }
    }

    /**
     * Saves profile data to the `profile.txt` file.
     * @param name the name to save.
     * @param email the email to save.
     * @param phone the phone number to save.
     */
    private void saveProfileData(String name, String email, String phone) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PROFILE_FILE))) {
            writer.println(name);
            writer.println(email);
            writer.println(phone);
            JOptionPane.showMessageDialog(this, "Profile saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving profile data: " + ex.getMessage());
        }
    }
}
