package view;


import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryScreen extends JPanel{

    // Array list to save the buttons
    private ArrayList<CoffeeStockButton> buttons = new ArrayList<>();
    private Image backgroundImage;

    // Constructor
    public InventoryScreen(){
        // Tries to load background image
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/images/polkaDotsTheme1.png"));
        } catch (IOException e) {
            System.err.println("Could not load background image.");
            e.printStackTrace();
        }
        
        this.setBackground(JavaCafeGUI.backgroundColor);
        this.setLayout(new WrapLayout(FlowLayout.LEFT,15, 15));
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

    // Needed to use background image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Paints background color in case image cannot be loaded
        
        if (backgroundImage != null) {
            
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

}

