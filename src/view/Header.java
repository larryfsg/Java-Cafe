package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Header extends JPanel {
    private JButton orderEntryButton;
    private JButton inventoryButton;


    public Header(){
        // Customization
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Align elements to the left with 10px gap between elements
		this.setBackground(new Color(84, 47, 49));
		this.setPreferredSize(new Dimension(0,40)); // setting height: 40px

        
        // Creating its buttons
        orderEntryButton = createHeaderButton("Order Entry");
        inventoryButton = createHeaderButton("Inventory");

        // Adding buttons to itself
        this.add(orderEntryButton);
        this.add(inventoryButton);
    }

    public JButton getOrderEntryButton(){
        return orderEntryButton;
    }

    public JButton getInventoryButton(){
        return inventoryButton;
    }

    // é private pq só a classe header vai usar e é estático pq nao precisa de uma instancia da header
    private static JButton createHeaderButton(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(238, 132, 132));
		button.setForeground(Color.WHITE);

        return button;
    }

    


}

