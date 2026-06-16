package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Menu extends JPanel{
    
    public Menu(){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

    }

    // adds coffee to menu
    public void addCoffee(String coffeeName, String imgPath){
        //ImageIcon icon = new ImageIcon(imgPath);

        JButton coffeeButton = new JButton(coffeeName);

        coffeeButton.setBackground(new Color(123, 57, 51));
        coffeeButton.setForeground(Color.WHITE);

        this.add(coffeeButton);
        this.revalidate();
        this.repaint();
    }

}
