import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {
    protected CardLayout cardLayout;
    protected JPanel mainPanel;

    public Screen(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }

    protected void navigateTo(String screenName) {
        cardLayout.show(mainPanel, screenName);
    }
}
