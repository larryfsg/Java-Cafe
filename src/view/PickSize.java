package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class PickSize extends JDialog {
    private JLabel coffeeName;
    private JLabel coffeeDescription;
    private JButton small;
    private JButton medium;
    private JButton large;
    private JButton cancel;


    public PickSize(JFrame parent, String name, String desc, String smallPrice, String mediumPrice, String largePrice){
        // JFrame parent | popup's name | blocks the user from interacting with the main frame
		super(parent, "Pick Size", true);

        // Customizing ---------------------------------------------------
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,5,10)); 

        this.setSize(300, 340);
        this.setLocationRelativeTo(parent);	// Positions window in the center of parent

        // Creating its components ---------------------------------------
        coffeeName = JavaCafeGUI.H3Text(name);
        coffeeDescription = JavaCafeGUI.smallerText(desc);
        JLabel message = JavaCafeGUI.H3Text("Choose the size:");
        small = pickSizeButton("Small: "+ smallPrice);
        medium = pickSizeButton("Medium: "+ mediumPrice);
        large = pickSizeButton("Large: "+ largePrice);
        cancel = pickSizeButton("Cancel");

        // Adding its components -----------------------------------------
        panel.add(coffeeName);
        panel.add(coffeeDescription);
        panel.add(Box.createVerticalStrut(16));
        panel.add(message);
        panel.add(Box.createVerticalStrut(10));
        panel.add(small);
        panel.add(Box.createVerticalStrut(10));
        panel.add(medium);
        panel.add(Box.createVerticalStrut(10));
        panel.add(large);
        panel.add(Box.createVerticalStrut(10));
        panel.add(cancel);
        this.add("Center", panel);

        this.setVisible(true);
    }

    // Helper method
    private static JButton pickSizeButton(String text){
        JButton button = new JButton(text);

        button.setFont(new Font("Inter", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(260, 30));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        button.setMinimumSize(new Dimension(Integer.MAX_VALUE, 30));

        return button;
    }


}
