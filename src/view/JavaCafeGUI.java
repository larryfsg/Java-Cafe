package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

import controller.NavegationListener;
import controller.SalesSummaryListener;
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
        JButton salesSummaryButton = header.getSalesSummaryButton();

        orderButton.addActionListener(new NavegationListener("orderScreen", cardLayout, contentPane));
        inventoryButton.addActionListener(new NavegationListener("inventoryScreen", cardLayout, contentPane));
        salesSummaryButton.addActionListener(new SalesSummaryListener(this));
    }

    public OrderEntryScreen getOrderScreen(){
        return this.orderScreen;
    }
    
    public Menu getMenu(){
        return this.orderScreen.getMenu();
    }
    public ShoppingCart getCart(){
        return this.orderScreen.getCart();
    }

    public InventoryScreen getInventoryScreen(){
        return this.inventoryScreen;
    }

    // Static methods / object used to set the application theme
    public static Color darkestShade = new Color(54,42,66);
    public static Color darkShade = new Color(87,73,100);
    public static Color secondaryColor = new Color(255,240,190);
    public static Color tertColor = new Color(230,178,186);
    public static Color buttonColor01 = new Color(255,240,190);
    public static Color buttonColor02 = new Color(197,153,182);

    // Creates a customized JLabel used for tittles
    public static JLabel H1Text(String text){
        JLabel h1Text = new JLabel(text);

        h1Text.setFont(new Font("Arial", Font.BOLD, 25));
	    h1Text.setForeground(darkestShade);

        return h1Text;
    }

    public static JLabel H3Text(String text){
        JLabel h3Text = new JLabel(text);

        h3Text.setFont(new Font("Inter", Font.BOLD, 16));
        h3Text.setForeground(darkestShade);

        return h3Text;
    }

    public static JLabel smallerText(String text){
        JLabel smallText = new JLabel(text);

        smallText.setFont(new Font("Inter", Font.BOLD, 12));
        smallText.setForeground(darkestShade);

        return smallText;
    }

    
}