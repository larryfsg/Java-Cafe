package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class CoffeeButton extends JButton {
    private ImageIcon auxImg;
    private ImageIcon finalImg;

    public CoffeeButton(String coffeeName, String imgPath){
        super(coffeeName);

        // Settin coffee image -------------------------------------------
        auxImg = new ImageIcon(getClass().getResource(imgPath)); // getting image
        Image scaledImage = auxImg.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH); //resizing it
        finalImg = new ImageIcon(scaledImage);
        this.setIcon(finalImg);


        // Customizing button's appearence -------------------------------
        this.setBackground(new Color(124, 64, 67));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setPreferredSize(new Dimension(160, 200));
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);  
        this.setBorderPainted(false);      
        this.setFocusPainted(false);  
    }

}
