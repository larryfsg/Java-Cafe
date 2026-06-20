package view;


import java.awt.*;
import javax.swing.*;

public class InventoryScreen extends JPanel{
    
    public InventoryScreen(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    }

    //adds coffee to the Inventory
    public void addProduct(String coffeeName, int sQtd, int mQtd, int lQtd){
        CoffeeStockButton button = new CoffeeStockButton(coffeeName, sQtd, mQtd, lQtd);

        this.add(button);
        this.revalidate();
        this.repaint();
    }
}

