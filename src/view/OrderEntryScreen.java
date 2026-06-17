package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class OrderEntryScreen extends JPanel{
    
    private Menu menu = new Menu(); // "wrapper" for the menu items (coffees)
    private ShoppingCart cart = new ShoppingCart(); // will exhibit the orders

    // constructor
    public OrderEntryScreen(){
        this.setBackground(new Color(246, 242, 175));



        this.setLayout(new BorderLayout());
        this.add(cart, BorderLayout.EAST);
        this.add(menu, BorderLayout.CENTER);
    }

    
    
}
