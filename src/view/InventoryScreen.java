package view;
import model.*;
import persistence.InventoryCSVLoader;

import java.awt.*;
import javax.swing.*;

public class InventoryScreen extends JPanel{
    
    public InventoryScreen(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        Inventory inventory = InventoryCSVLoader.load("coffees.csv");
        addInventoryItems(inventory);
    }

    // adds coffee to the Inventory
    public void addInventoryItems(Inventory inventory){

        for(Coffee coffee : inventory.getProducts()){

            CoffeeStockButton coffeeStockButton = 
            new CoffeeStockButton(coffee.getName(), "a", coffee.getStock('S'),
            coffee.getStock('M'), coffee.getStock('L'));

            this.add(coffeeStockButton);
            this.revalidate();
            this.repaint();
        }
    }
}

class CoffeeStockButton extends JPanel {

    private JButton button;
    private JLabel stockS;
    private JLabel stockM;
    private JLabel stockL;

    public CoffeeStockButton(String name,
                             String imgPath,
                             int s,
                             int m,
                             int l) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        button = new JButton(name);

        stockS = new JLabel("S: " + s);
        stockM = new JLabel("M: " + m);
        stockL = new JLabel("L: " + l);

        add(button);
        add(stockS);
        add(stockM);
        add(stockL);
    }
}
