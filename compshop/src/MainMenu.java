import javax.swing.*;
import java.awt.*;

public class MainMenu extends Screen {
    public MainMenu(CardLayout cardLayout, JPanel mainPanel) {
        super(cardLayout, mainPanel);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton profileButton = new JButton("Profile");
        JButton inventoryButton = new JButton("Manage Inventory");
        JButton shopButton = new JButton("Shop");
        JButton cartButton = new JButton("Cart");

        profileButton.addActionListener(e -> navigateTo("Profile"));
        inventoryButton.addActionListener(e -> navigateTo("Inventory"));
        shopButton.addActionListener(e -> navigateTo("Shop"));
        cartButton.addActionListener(e -> navigateTo("Cart"));

        add(profileButton);
        add(inventoryButton);
        add(shopButton);
        add(cartButton);
    }
}
