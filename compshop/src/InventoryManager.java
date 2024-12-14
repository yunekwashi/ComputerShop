import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Scanner;

public class InventoryManager {
    private DefaultTableModel inventoryModel = new DefaultTableModel(new String[]{"Name", "Price", "Description"}, 0);
    private static final String INVENTORY_FILE = "inventory.txt";

    public InventoryManager() {
        loadInventoryData();
    }

    public DefaultTableModel getInventoryModel() {
        return inventoryModel;
    }

    public void addItem(String name, double price, String description) {
        inventoryModel.addRow(new Object[]{name, price, description});
        saveInventoryData();
    }

    public void removeItem(int row) {
        if (row >= 0) {
            inventoryModel.removeRow(row);
            saveInventoryData();
        }
    }

    private void loadInventoryData() {
        File file = new File(INVENTORY_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(";", 3); // Split data by semicolon
                    if (parts.length == 3) {
                        String name = parts[0];
                        double price = Double.parseDouble(parts[1]);
                        String description = parts[2];
                        inventoryModel.addRow(new Object[]{name, price, description});
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error loading inventory data: " + e.getMessage());
            }
        }
    }

    private void saveInventoryData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE))) {
            for (int i = 0; i < inventoryModel.getRowCount(); i++) {
                String name = inventoryModel.getValueAt(i, 0).toString();
                String price = inventoryModel.getValueAt(i, 1).toString();
                String description = inventoryModel.getValueAt(i, 2).toString();
                writer.println(name + ";" + price + ";" + description); // Save data as semicolon-separated values
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory data: " + e.getMessage());
        }
    }
}
