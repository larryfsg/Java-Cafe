package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ShoppingCart extends JPanel {
    
    private JLabel yourCart;
    private JPanel yourOrders;
    private JScrollPane scroller;
    private JLabel subTotal;
    private JLabel taxes;
    private JLabel totalPrice;
    private JButton buyButton;
    private JPanel buyWrapper;
    

    public ShoppingCart(){
        // Customizing----------------------------------------------------
        this.setBackground(new Color(238, 132, 132));
        this.setPreferredSize(new Dimension(370, 0));
        this.setBorder(BorderFactory.createEmptyBorder(20,10,10,10)); 

        // Creating its components ---------------------------------------
        yourCart = JavaCafeGUI.H1Text("Your Cart");
        totalPrice = JavaCafeGUI.H1Text("Total: R$00.00");
        subTotal = JavaCafeGUI.smallerText("Subtotal: R$00.00");
        taxes = JavaCafeGUI.smallerText("Tax (10%): R$00.00");
        buyButton = createBuyButton();
        
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
        buyWrapper.add(subTotal);
        buyWrapper.add(taxes);
        buyWrapper.add(totalPrice);
        buyWrapper.add(buyButton);

        // Adding components to itself -----------------------------------
        this.setLayout(new BorderLayout());
        this.add(yourCart, BorderLayout.NORTH);
        this.add(scroller, BorderLayout.CENTER);
        this.add(buyWrapper, BorderLayout.SOUTH);
    }

    // Method that adds order to cart
    public OrderJPanel addOrder(String coffeeName, String size, String price, int maxQtd){
        OrderJPanel order = new OrderJPanel(coffeeName, size, price, maxQtd);

        // Adding order to your orders
        this.yourOrders.add(order);
        this.yourOrders.revalidate();
        this.yourOrders.repaint();

        return order;
    }

    // Method that removes order from cart
    public void removeOrder(OrderJPanel order){
        this.yourOrders.remove(order);
        this.yourOrders.revalidate();
        this.yourOrders.repaint();
    }

    public void setPrices(String subTotalText, String taxText, String totalText){
        this.subTotal.setText(subTotalText);
        this.taxes.setText(taxText);
        this.totalPrice.setText(totalText);
    }

    public void onBuyAction(ActionListener listener){
        buyButton.addActionListener(listener);
    }

    private static JButton createBuyButton(){
        JButton button = new JButton("Buy");
        button.setBackground(new Color(115,218,129));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 35));
        button.setPreferredSize(new Dimension(370, 45));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        button.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));

        return button;
    }
}
