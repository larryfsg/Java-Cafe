package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Menu extends JPanel{
    
    public Menu(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    }

    // Creates and adds coffee button to menu
    public void addCoffee(String coffeeName, String imgPath, ActionListener listener){
        CoffeeButton coffee = new CoffeeButton(coffeeName, imgPath, listener);

        this.add(coffee);
        this.revalidate();
        this.repaint();
    }

}
