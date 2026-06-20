package view;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventoryScreen extends JPanel{

    // Array list to save the buttons
    private ArrayList<CoffeeStockButton> buttons = new ArrayList<>();
    
    // Constructor
    public InventoryScreen(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    }

    //adds coffee to the Inventory
    public void addProduct(String coffeeName, String imgPath, int sQtd, int mQtd, int lQtd, ActionListener inventoryController){
        CoffeeStockButton button = new CoffeeStockButton(coffeeName, imgPath, sQtd, mQtd, lQtd, inventoryController);

        // Stores on the buttons list
        buttons.add(button);

        this.add(button);
        this.revalidate();
        this.repaint();
    }

    // Update the view of the inventory for a specific coffee
    public void updateCoffeeButton(String coffeeName, int s, int m, int l) {
        // Finds the coffe button
        for (CoffeeStockButton button : buttons) {

            // Update
            if (button.getCoffeeName().equals(coffeeName)) {
                button.updateStock(s, m, l);
                break;
            }
        }
    }
}

