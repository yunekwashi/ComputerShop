import javax.swing.*;
import java.awt.*;

public class InventoryScreen extends Screen {
    private InventoryManager inventoryManager;

    public InventoryScreen(CardLayout cardLayout, JPanel mainPanel, InventoryManager inventoryManager) {
        super(cardLayout, mainPanel);
        this.inventoryManager = inventoryManager;

        setLayout(new BorderLayout());

        // Example UI
        JLabel titleLabel = new JLabel("Inventory Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JTable inventoryTable = new JTable(inventoryManager.getInventoryModel());
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> navigateTo("MainMenu"));
        add(backButton, BorderLayout.SOUTH);
    }
}
