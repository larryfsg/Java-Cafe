package controller;

import java.util.ArrayList;

import model.*;
import view.ShoppingCart;
import view.OrderJPanel;

public class OrderController{
    private ShoppingCart cart;
    private ArrayList<Order> orders;
    private Inventory inventory;

    public OrderController(ShoppingCart shoppingCart, Inventory invent){
        this.cart = shoppingCart;
        this.inventory = invent;
        this.orders = new ArrayList<>();
    }

    // This method creates an order object and adds order to GUI
    public void addOrderToCart(String coffeeName, char size){
        Coffee coffee = inventory.getCoffee(coffeeName);



        Order order = new Order(coffee, size);
        orders.add(order);

        String orderSize;
        String orderPrice = String.format("R$%.2f", order.getPrice());

        if (size == 'S'){
            orderSize = "Small";
        } else if (size == 'M'){
            orderSize = "Medium";
        } else{
            orderSize = "Large";
        }

        OrderJPanel visualOrder = cart.addOrder(coffeeName, orderSize, orderPrice, coffee.getStock(size));   
    
        // Action listener for order removal
        visualOrder.onRemoveAction(e-> {
            orders.remove(order);           // Removes order object (model)
            cart.removeOrder(visualOrder);    
        });


    
    }


}
