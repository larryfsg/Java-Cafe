package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

import controller.NavegationListener;
// import model.Inventory;
// import persistence.InventoryCSVLoader;
// import persistence.loadInventoryIntoGUI;

public class JavaCafeGUI extends JFrame{

    private Header header = new Header();
    private JPanel contentPane = new JPanel();
    private CardLayout cardLayout = new CardLayout(); // Content pane's layout manager
    private OrderEntryScreen orderScreen = new OrderEntryScreen();
    private InventoryScreen inventoryScreen = new InventoryScreen();
    // inventory screen

    // Constructor
    public JavaCafeGUI(){
        // Inventory javaCafeInventory = InventoryCSVLoader.load("coffees.csv");
        // loadInventoryIntoGUI LIG = new loadInventoryIntoGUI(this, javaCafeInventory);
        // LIG.addCoffeToInventory();
        // LIG.addCoffeeToMenu();

        //setting window's appearence
		setTitle("Java Cafe");	
		setSize(1200, 780);		        // Window's dimensions (width, height)
		setLocationRelativeTo(null);	// Positions window in the center of the screen


        //contentPane's arrange
        contentPane.setLayout(cardLayout);
        contentPane.add(orderScreen, "orderScreen");
        contentPane.add(inventoryScreen, "inventoryScreen");

        addNavegationListener();

        // Window's arrangement
        setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(contentPane, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    // Adding listener to header's buttons
    private void addNavegationListener(){
        JButton orderButton = header.getOrderEntryButton();
        JButton inventoryButton = header.getInventoryButton();

        orderButton.addActionListener(new NavegationListener("orderScreen", cardLayout, contentPane));
        inventoryButton.addActionListener(new NavegationListener("inventoryScreen", cardLayout, contentPane));
    }

    public OrderEntryScreen getOrderScreen(){
        return this.orderScreen;
    }
    
    public Menu getMenu(){
        return this.orderScreen.getMenu();
    }

    public InventoryScreen getInventoryScreen(){
        return this.inventoryScreen;
    }


    // Creates a customized JLabel used for tittles
    public static JLabel H1Text(String text){
        JLabel h1Text = new JLabel(text);

        h1Text.setFont(new Font("Arial", Font.BOLD, 25));
	    h1Text.setForeground(new Color(84, 47, 49));

        return h1Text;
    }

    public static JLabel H3Text(String text){
        JLabel h3Text = new JLabel(text);

        h3Text.setFont(new Font("Inter", Font.BOLD, 16));
        h3Text.setForeground(new Color(84, 47, 49));

        return h3Text;
    }

    public static JLabel smallerText(String text){
        JLabel smallText = new JLabel(text);

        smallText.setFont(new Font("Inter", Font.BOLD, 12));
        smallText.setForeground(new Color(84, 47, 49));

        return smallText;
    }

    
}