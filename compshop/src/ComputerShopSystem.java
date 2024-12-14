import javax.swing.*;
import java.awt.*;

public class ComputerShopSystem {
    static CardLayout cardLayout = new CardLayout();
    static JPanel mainPanel = new JPanel(cardLayout);
    static CartManager cartManager = new CartManager();
    static InventoryManager inventoryManager = new InventoryManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("PC HUB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Add screens
        mainPanel.add(new SplashScreen(cardLayout, mainPanel), "Splash");
        mainPanel.add(new LoginScreen(cardLayout, mainPanel), "Login");
        mainPanel.add(new MainMenu(cardLayout, mainPanel), "MainMenu");
        mainPanel.add(new ProfileScreen(cardLayout, mainPanel), "Profile");
        mainPanel.add(new InventoryScreen(cardLayout, mainPanel, inventoryManager), "Inventory");
        mainPanel.add(new ShopScreen(cardLayout, mainPanel, inventoryManager, cartManager), "Shop");
        mainPanel.add(new CartScreen(cardLayout, mainPanel, cartManager), "Cart");

        cardLayout.show(mainPanel, "Splash");
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
