package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CoffeeButton extends JButton {
    private ImageIcon auxImg;
    private ImageIcon finalImg;

    public CoffeeButton(String coffeeName, String imgPath, ActionListener listener){
        super(coffeeName);
        
        // Settin coffee image -------------------------------------------
        try{    // tries to get coffee image
            auxImg = new ImageIcon(getClass().getResource(imgPath)); // getting image

        } catch (NullPointerException e){
            // if the image doesn't exist, use a blank picture as placeholder
            auxImg = new ImageIcon(getClass().getResource("/view/images/empty.jpg"));
        }
        Image scaledImage = auxImg.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH); //resizing it
        finalImg = new ImageIcon(scaledImage);
        this.setIcon(finalImg);

        // Adding its action listener ------------------------------------
        this.addActionListener(listener);
        this.setActionCommand(coffeeName);

        // Customizing button's appearence -------------------------------
        this.setBackground(JavaCafeGUI.buttonColor02);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setPreferredSize(new Dimension(180, 200));
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);  
        this.setBorderPainted(false);      
        this.setFocusPainted(false);  
    }

}
