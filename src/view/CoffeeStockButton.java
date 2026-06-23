package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class CoffeeStockButton extends JPanel {

    private String coffeeName;

    private ImageIcon auxImg;
    private ImageIcon finalImg;
    private JLabel imageLabel;

    private JLabel nameLabel;
    private JLabel stockS;
    private JLabel stockM;
    private JLabel stockL;
    private JButton updateButton;

    public CoffeeStockButton(String coffeeName, String imgPath, int s, int m, int l, ActionListener inventoryController) {

        this.coffeeName = coffeeName;

        setBackground(JavaCafeGUI.buttonColor02);
        setPreferredSize(new Dimension(180, 300));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        // Settin coffee image -------------------------------------------
        try{    // tries to get coffee image
            auxImg = new ImageIcon(getClass().getResource(imgPath)); // getting image

        } catch (NullPointerException e){
            // if the image doesn't exist, use a blank picture as placeholder
            auxImg = new ImageIcon(getClass().getResource("/view/images/empty.jpg"));
        }

        // Scaling image
        Image scaledImage = auxImg.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH); //resizing it
        finalImg = new ImageIcon(scaledImage);

        // Setting image as icon for a JLabel
        imageLabel = new JLabel(finalImg);

        imageLabel.setPreferredSize(new Dimension(140, 140));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Coffee Name Label
        nameLabel = new JLabel(coffeeName);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Stock labels
        stockS = new JLabel("S: " + s);
        stockM = new JLabel("M: " + m);
        stockL = new JLabel("L: " + l);

        stockS.setForeground(Color.WHITE);
        stockM.setForeground(Color.WHITE);
        stockL.setForeground(Color.WHITE);

        stockS.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockM.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockL.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Update Button
        updateButton = new JButton("Add");
        updateButton.setBackground(JavaCafeGUI.buttonColor01);
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Listener
        updateButton.setActionCommand(coffeeName);
        updateButton.addActionListener(inventoryController);

        // Formatting the button
        add(Box.createVerticalStrut(20));
        add(imageLabel);
        add(Box.createVerticalStrut(10));
        add(nameLabel);
        add(Box.createVerticalStrut(10));
        add(stockS);
        add(stockM);
        add(stockL);
        add(Box.createVerticalStrut(15));
        add(updateButton);
    }

    // Getters
    public String getCoffeeName(){
        return coffeeName;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    // Uptade the stock quantities in the button
    public void updateStock(int s, int m, int l) {
        stockS.setText("S: " + s);
        stockM.setText("M: " + m);
        stockL.setText("L: " + l);
    }
}