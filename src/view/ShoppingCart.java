package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class ShoppingCart extends JPanel {
    
    private JLabel yourCart;
    private JPanel yourOrders;
    private JScrollPane scroller;
    private JLabel totalPrice;
    private JButton buyButton;
    private JPanel buyWrapper;
    

    public ShoppingCart(){
        // Customizing----------------------------------------------------
        this.setBackground(new Color(255,236,102));
        this.setPreferredSize(new Dimension(370, 0));

        // Creating its components ---------------------------------------
        yourCart = JavaCafeGUI.H1Text("Your Cart");
        totalPrice = new JLabel("R$00.00");
        buyButton = new JButton("Buy");
        
        // Setting order's wrapper
        yourOrders = new JPanel();
        yourOrders.setLayout(new BoxLayout(yourOrders, BoxLayout.Y_AXIS)); // Para que os pedidos fiquem um embaixo do outro
        yourOrders.setOpaque(false);

        // Setting order's scroller
        scroller = new JScrollPane(yourOrders); // agora os pedidos são scrollaveis
        scroller.setBorder(BorderFactory.createEmptyBorder());
        scroller.setOpaque(false);
        scroller.getViewport().setOpaque(false);

        // Setting buy wrapper
        buyWrapper = new JPanel();
        buyWrapper.setLayout(new BoxLayout(buyWrapper, BoxLayout.Y_AXIS));
        buyWrapper.setOpaque(false);
        buyWrapper.add(totalPrice);
        buyWrapper.add(buyButton);

        // só para ver como o jpanel de pedido está
        this.addOrder("Milk coffee", "S", "R$19.75");


        // Adding components to itself -----------------------------------
        this.setLayout(new BorderLayout());
        this.add(yourCart, BorderLayout.NORTH);
        this.add(scroller, BorderLayout.CENTER);
        this.add(buyWrapper, BorderLayout.SOUTH);
    }

    // Method that adds order to cart
    public void addOrder(String coffeeName, String size, String price){
        OrderJPanel order = new OrderJPanel(coffeeName, size, price);

        // Adding order to your orders
        this.yourOrders.add(order);
        this.yourOrders.revalidate();
        this.yourOrders.repaint();
    }

}
