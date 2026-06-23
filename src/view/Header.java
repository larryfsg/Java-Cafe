package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Header extends JPanel {
    private JButton orderEntryButton;
    private JButton inventoryButton;
    private JButton salesSummaryButton;

    public Header(){
        // Customizing ---------------------------------------------------
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Align elements to the left with 10px gap between elements
		this.setBackground(JavaCafeGUI.darkShade);
		this.setPreferredSize(new Dimension(0,40)); // setting height: 40px

        // Creating its buttons ------------------------------------------
        orderEntryButton = createHeaderButton("Order Entry");
        inventoryButton = createHeaderButton("Inventory");
        salesSummaryButton = createHeaderButton("Sales Summary");

        // Adding buttons to itself --------------------------------------
        this.add(orderEntryButton);
        this.add(inventoryButton);
        this.add(salesSummaryButton);
    }

    // getter methods
    public JButton getOrderEntryButton(){
        return orderEntryButton;
    }

    public JButton getInventoryButton(){
        return inventoryButton;
    }

    public JButton getSalesSummaryButton(){
        return salesSummaryButton;
    }

    // helper method to create the custom header buttons
    private static JButton createHeaderButton(String text){
        JButton button = new JButton(text);

        button.setBackground(JavaCafeGUI.buttonColor01);
		button.setForeground(JavaCafeGUI.darkestShade);

        return button;
    }

    


}