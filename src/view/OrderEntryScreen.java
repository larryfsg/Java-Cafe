package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class OrderEntryScreen extends JPanel{
    
    private Menu menu = new Menu(); // "wrapper" for the menu items (coffees)
    private ShoppingCart cart = new ShoppingCart(); // will exhibit the orders
    private Image backgroundImage;

    // constructor
    public OrderEntryScreen(){

        // Tries to load background image
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/images/polkaDotsTheme1.png"));
        } catch (IOException e) {
            System.err.println("Could not load background image.");
            e.printStackTrace();
        }


        this.setBackground(new Color(255, 235, 193));
        this.setLayout(new BorderLayout());
        this.add(cart, BorderLayout.EAST);
        this.add(menu, BorderLayout.CENTER);
    }

    public Menu getMenu(){
        return this.menu;
    }
    public ShoppingCart getCart(){
        return this.cart;
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

