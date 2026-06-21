package controller;

import java.util.ArrayList;

import model.*;
import view.ShoppingCart;
import view.OrderJPanel;

public class OrderController {
    private ShoppingCart cart;
    private ArrayList<Order> orders;
    private ArrayList<OrderJPanel> visualOrders;
    private Inventory inventory;

    public OrderController(ShoppingCart shoppingCart, Inventory invent){
        this.cart = shoppingCart;
        this.inventory = invent;
        this.orders = new ArrayList<>();
        this.visualOrders = new ArrayList<>();
    }

    // This method creates an order object and adds order to GUI
    public void addOrderToCart(String coffeeName, char size) throws OutOfStockException{
        Coffee coffee = inventory.getCoffee(coffeeName);
        Order order; OrderJPanel visualOrder;
        

        // If order already exists ----------------------------------------
        // Tries to increase order's quantity
        if (isAlreadyInCart(coffeeName, size)){

            int orderId = getOrderId(coffeeName, size);

            order = orders.get(orderId);
            visualOrder = visualOrders.get(orderId);

            if (order.getQuantity() == coffee.getStock(size)) {
                throw new OutOfStockException(coffeeName + " ("+size+") is out of stock :(", size);
            } else{
      
                // Increases order quantity
                int newQtd = (order.getQuantity() +1);
                changeOrderQtd(newQtd, order, visualOrder);
            }
        }
        // If order doesn't exist ----------------------------------------
        // Tries to create it
        else{
            
            if (coffee.getStock(size) <= 0){
                throw new OutOfStockException(coffeeName + " ("+size+") is out of stock :(", size);
            } 


            order = new Order(coffee, size);
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

            visualOrder = cart.addOrder(coffeeName, orderSize, orderPrice, coffee.getStock(size));   
            visualOrders.add(visualOrder);

            // Action listener for order removal
            visualOrder.onRemoveAction(e-> {
                orders.remove(order);           // Removes order object (model)
                visualOrders.remove(visualOrder);
                cart.removeOrder(visualOrder);
                calculatePrices();
            });

            // Action listener for quantity change
            visualOrder.onQuantityChange(e -> {
                int newQtd = visualOrder.getOrderQuantity();
                changeOrderQtd(newQtd, order, visualOrder);
                calculatePrices();
            });
        }

        calculatePrices();
    }

    public boolean isAlreadyInCart(String coffeeName, char size){
        for (Order order : orders){
            if (order.getCoffeeName().equals(coffeeName) && (order.getSize() == size)){
                return true;
            }
        }
        return false;
    }

    public int getOrderId(String coffeeName, char size){

        for (Order order : orders){
            if (order.getCoffeeName().equals(coffeeName) && (order.getSize() == size)){
                return orders.indexOf(order);
            }
        }

        return -1;
    }

    public void changeOrderQtd(int newQtd, Order order, OrderJPanel visualOrder){
        order.changeQtd(newQtd);
        String newPrice = String.format("R$%.2f", order.getPrice());
        visualOrder.changeQtd(newQtd, newPrice);
    }

    public void calculatePrices(){

        double subTotal = 0;
        double totalPrice;
        double tax;

        for (Order order : orders){
            subTotal = subTotal + (order.getPrice());
        }

        tax = (subTotal * 0.10);
        totalPrice = subTotal + tax;

        String subTotalText = String.format("Subtotal: R$%.2f", subTotal);
        String taxesText = String.format("Taxes (10%%): R$%.2f", tax);
        String totalPriceText = String.format("Total: R$%.2f", totalPrice);

        cart.setPrices(subTotalText, taxesText, totalPriceText);
    }

}
