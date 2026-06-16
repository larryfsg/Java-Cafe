package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class JavaCafeGUI extends JFrame{

    private Header header = new Header();
    private JPanel contentPane = new JPanel();
    private CardLayout cardLayout = new CardLayout(); // Content pane's layout manager
    private OrderEntryScreen orderScreen = new OrderEntryScreen();
    // inventory screen

    // Constructor
    public JavaCafeGUI(){

        //setting window's appearence
		setTitle("Java Cafe");	
		setSize(1200, 780);		        // Window's dimensions (width, height)
		setLocationRelativeTo(null);	// Positions window in the center of the screen


        //contentPane's arrange
        contentPane.setLayout(cardLayout);
        contentPane.add(orderScreen, "orderScreen");


        // Window's arrangement
        setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(contentPane, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    
}