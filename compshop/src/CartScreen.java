import javax.swing.*;
import java.awt.*;

public class CartScreen extends Screen {
    private CartManager cartManager;

    public CartScreen(CardLayout cardLayout, JPanel mainPanel, CartManager cartManager) {
        super(cardLayout, mainPanel);
        this.cartManager = cartManager;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Cart", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        DefaultListModel<String> cartListModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartListModel);
        JScrollPane scrollPane = new JScrollPane(cartList);
        add(scrollPane, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> {
            double total = cartManager.getTotal();
            JOptionPane.showMessageDialog(this, "Checkout complete! Total: $" + total);
            cartManager.clearCart();
            cartListModel.clear();
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> navigateTo("MainMenu"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkoutButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Update cart list when screen is displayed
        cardLayout.addLayoutComponent(this, "Cart");
        cartListModel.clear();
        for (CartItem item : cartManager.getCartItems()) {
            cartListModel.addElement(item.getName() + " - $" + item.getPrice());
        }
    }
}
