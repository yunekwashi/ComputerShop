import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<CartItem> cart = new ArrayList<>();

    public void addItem(CartItem item) {
        cart.add(item);
    }

    public void clearCart() {
        cart.clear();
    }

    public List<CartItem> getCartItems() {
        return cart;
    }

    public double getTotal() {
        return cart.stream().mapToDouble(CartItem::getPrice).sum();
    }
}
