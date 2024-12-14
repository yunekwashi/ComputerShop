import javax.swing.*;
import java.awt.*;

public class ShopScreen extends Screen {
    private InventoryManager inventoryManager;
    private CartManager cartManager;

    public ShopScreen(CardLayout cardLayout, JPanel mainPanel, InventoryManager inventoryManager, CartManager cartManager) {
        super(cardLayout, mainPanel);
        this.inventoryManager = inventoryManager;
        this.cartManager = cartManager;

        setLayout(new BorderLayout());

        // Example UI
        JLabel titleLabel = new JLabel("Shop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JTable shopTable = new JTable(inventoryManager.getInventoryModel());
        JScrollPane scrollPane = new JScrollPane(shopTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> {
            int selectedRow = shopTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = inventoryManager.getInventoryModel().getValueAt(selectedRow, 0).toString();
                double price = Double.parseDouble(inventoryManager.getInventoryModel().getValueAt(selectedRow, 1).toString());
                cartManager.addItem(new CartItem(name, price));
                JOptionPane.showMessageDialog(this, "Item added to cart!");
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item.");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> navigateTo("MainMenu"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addToCartButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
