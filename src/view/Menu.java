package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Menu extends JPanel{
    
    public Menu(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        //addCoffee("milkCoffee", "/view/images/milkCoffee.jpeg");
    }

    // adds coffee to menu
    public void addCoffee(CoffeeButton coffee){
        this.add(coffee);
        this.revalidate();
        this.repaint();
    }

}
