package persistence;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class that reads an CSV archive and loads into an inventory
public class InventoryCSVLoader {

    // load method
    public static Inventory load(String fileName) {

        Inventory inventory = new Inventory();

        // Try the Buffered Reader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Breaking the line into coffee parameters
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0].trim();
                String ingredients = data[1].trim();

                int qtdS = Integer.parseInt(data[2].trim());
                int qtdM = Integer.parseInt(data[3].trim());
                int qtdL = Integer.parseInt(data[4].trim());

                double priceS = Double.parseDouble(data[5].trim());
                double priceM = Double.parseDouble(data[6].trim());
                double priceL = Double.parseDouble(data[7].trim());

                // Creates a coffee object to each product found in the csv file
                Coffee coffee = new Coffee(
                    name,
                    ingredients,
                    priceS,
                    priceM,
                    priceL
                );

                coffee.setInventory('S', qtdS);
                coffee.setInventory('M', qtdM);
                coffee.setInventory('L', qtdL);

                // add the created coffee to the inventory
                inventory.addProduct(coffee);
            }

        // Verify IOException errors
        } catch (IOException e) {
            System.out.println("Falha no processamento do arquivo");
            return null;
        }
        return inventory;
    }
}