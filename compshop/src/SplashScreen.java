import javax.swing.*;
import java.awt.*;

public class SplashScreen extends Screen {
    public SplashScreen(CardLayout cardLayout, JPanel mainPanel) {
        super(cardLayout, mainPanel);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to PC HUB", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        Timer timer = new Timer(3000, e -> navigateTo("Login"));
        timer.setRepeats(false);
        timer.start();
    }
}
