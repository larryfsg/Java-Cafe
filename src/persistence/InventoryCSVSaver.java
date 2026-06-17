package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Coffee;
import model.Inventory;

// Class that saves an inventory to a csv file
public class InventoryCSVSaver {

    // Save method
    public static void save(Inventory inventory, String fileName) {

        // Try writing
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            // For each coffee in inventory, save in one line
            for (Coffee coffee : inventory.getProducts()) {

                writer.println(
                    coffee.getName() + "," +
                    coffee.getIngredients() + "," +
                    coffee.getStock('S') + "," +
                    coffee.getStock('M') + "," +
                    coffee.getStock('L') + "," +
                    coffee.getPrice('S') + "," +
                    coffee.getPrice('M') + "," +
                    coffee.getPrice('L')
                );
            }

        // Verify IOException errors
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}