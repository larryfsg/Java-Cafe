package controller;

import model.*;
import view.ShoppingCart;

public class OrderController {
    private ShoppingCart cart;
    private Inventory inventory;

    public OrderController(ShoppingCart shoppingCart, Inventory invent){
        this.cart = shoppingCart;
        this.inventory = invent;
    }

    // This method creates an order object and adds order to GUI
    public void addOrderToCart(String coffeeName, char size){
        Coffee coffee = inventory.getCoffee(coffeeName);
        Order order = new Order(coffee, size);
        String orderSize;
        String orderPrice = String.format("R$%.2f", order.getPrice());

        if (size == 'S'){
            orderSize = "Small";
        } else if (size == 'M'){
            orderSize = "Medium";
        } else{
            orderSize = "Large";
        }

        cart.addOrder(coffeeName, orderSize, orderPrice, coffee.getStock(size));   
    }


}
