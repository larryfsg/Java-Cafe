package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import view.ShoppingCart;
import view.JavaCafeGUI;
import view.OrderJPanel;
import view.ReceiptJDialog;
import persistence.*;

public class OrderController {

    // Needs inventory controller for when the user makes a purchase because it requires stock reduction
    private InventoryController inventoryController;
    private Inventory inventory;

    private JavaCafeGUI parent;
    private ShoppingCart cart;

    private ArrayList<Order> orders;
    private ArrayList<OrderJPanel> visualOrders;

    private double subTotal;
    private double totalPrice;
    private double tax;

    // Constructor 
    public OrderController(JavaCafeGUI javaCafe, Inventory invent, InventoryController ic){
        this.inventoryController = ic;
        this.inventory = invent;

        // view end
        this.parent = javaCafe;
        this.cart = javaCafe.getCart();

        // model end
        this.orders = new ArrayList<>();
        this.visualOrders = new ArrayList<>();

        // ActionListener for "Buy" button
        cart.onBuyAction(e->{
            makePurchase();
        });
    }

    // This method creates an order both in model and in view
    public void addOrderToCart(String coffeeName, char size) throws OutOfStockException{
        Coffee coffee = inventory.getCoffee(coffeeName);
        Order order; OrderJPanel visualOrder;
        

        // If order already exists in cart -------------------------------
        // Tries to increase order's quantity
        if (isAlreadyInCart(coffeeName, size)){

            // The order ID is usefull to have direct access to view and model representation of the same order
            int orderId = getOrderId(coffeeName, size);
            order = orders.get(orderId);
            visualOrder = visualOrders.get(orderId);

            // If the order quantity can't be increased due to lack of stock 
            if (order.getQuantity() == coffee.getStock(size)) {
                throw new OutOfStockException(coffeeName + " ("+size+") is out of stock :(", size);
            }
            else{
      
                // Increases order quantity
                int newQtd = (order.getQuantity() +1);
                changeOrderQtd(newQtd, order, visualOrder);
            }
        }

        // If order doesn't exist ----------------------------------------
        // Tries to create it
        else{
            
            // Checks if coffee is available in stock
            if (coffee.getStock(size) <= 0){
                throw new OutOfStockException(coffeeName + " ("+size+") is out of stock :(", size);
            } 

            // Creates order in model:
            order = new Order(coffee, size);
            orders.add(order);

            // Creates order in view:
            String orderPrice = String.format("R$%.2f", order.getPrice());
            String orderSize;
            if (size == 'S'){
                orderSize = "Small";
            } else if (size == 'M'){
                orderSize = "Medium";
            } else{
                orderSize = "Large";
            }
            visualOrder = cart.addOrder(coffeeName, orderSize, orderPrice, coffee.getStock(size));   
            visualOrders.add(visualOrder);

            // Action listeners:
            // Action listener for order removal
            visualOrder.onRemoveAction(e-> {
                orders.remove(order);               // Removes order from model array list
                visualOrders.remove(visualOrder);   // Removes order from view array list
                cart.removeOrder(visualOrder);      // Removes order from GUI
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

    // This method changes the quantity of an existing order both in model and in view
    public void changeOrderQtd(int newQtd, Order order, OrderJPanel visualOrder){
        order.changeQtd(newQtd);
        String newPrice = String.format("R$%.2f", order.getPrice());
        visualOrder.changeQtd(newQtd, newPrice);
    }

    // This method makes a purchase removing order from model and view and reducing stock
    private void makePurchase(){
        
        // If there are no orders in the cart
        if (totalPrice == 0){
            JOptionPane.showMessageDialog(null, "There are no products in your cart.");
            return;
        }


        StringBuilder finalTextReceip = new StringBuilder();
        finalTextReceip.append("qtd\tproduct\tsize\tunity\ttotal\n");

        // Removing orders from GUI --------------------------------------
        for (OrderJPanel visualOrder : visualOrders){
            cart.removeOrder(visualOrder);
        }

        // Decreasing stock quantity -------------------------------------- 
        // And building receipt text
        for (Order order : orders){

            // Ex: 3x   Milk Coffee   S   2.00 6.00
            finalTextReceip.append(order.getQuantity()+"x\t");
            finalTextReceip.append(order.getCoffeeName()+"\t");
            finalTextReceip.append(order.getSize()+"\t");
            finalTextReceip.append(String.format("R$%.2f", order.getUnityPrice())+"\t");
            finalTextReceip.append(String.format("R$%.2f", order.getPrice())+"\n");

            // Decreases stock
            inventoryController.onPurchaseAction(order.getCoffeeName(), order.getSize(), order.getQuantity());
        }   

        // Adding sub total, tax and total price to Text Receipt
        finalTextReceip.append("\n\nSubtotal:\t\t\t\t"+String.format("R$%.2f",subTotal)+"\n");
        finalTextReceip.append("Tax:\t\t\t\t"+String.format("R$%.2f",tax)+"\n");
        finalTextReceip.append("Total:\t\t\t\t"+String.format("R$%.2f",totalPrice)+"\n");


        // Updating sales file -------------------------------------------
        SalesReportUpdater.update(orders, "../data/sales.csv");

        // Emptying array lists  -----------------------------------------
        orders.clear();
        visualOrders.clear();
        
        calculatePrices();

        // Displaying receipt to user -------------------------------------
        ReceiptJDialog receiptJDialog = new ReceiptJDialog(parent, finalTextReceip.toString());
        receiptJDialog.setVisible(true);
    } 

    // This method checks if a given product (coffee and its size) is already in cart
    public boolean isAlreadyInCart(String coffeeName, char size){
        for (Order order : orders){
            if (order.getCoffeeName().equals(coffeeName) && (order.getSize() == size)){
                return true;
            }
        }
        return false;
    }

    // Thid method returns an order position inside the orders array list
    public int getOrderId(String coffeeName, char size){

        for (Order order : orders){
            if (order.getCoffeeName().equals(coffeeName) && (order.getSize() == size)){
                return orders.indexOf(order);
            }
        }

        return -1;
    }

    // This method calculates sub total, tax and total price of the orders in cart
    public void calculatePrices(){

        subTotal = 0;

        // Accumulating the price of all existing orders
        for (Order order : orders){
            subTotal = subTotal + (order.getPrice());
        }

        tax = (subTotal * 0.10);
        totalPrice = subTotal + tax;

        // Formatting data for view 
        String subTotalText = String.format("Subtotal: R$%.2f", subTotal);
        String taxesText = String.format("Taxes (10%%): R$%.2f", tax);
        String totalPriceText = String.format("Total: R$%.2f", totalPrice);

        cart.setPrices(subTotalText, taxesText, totalPriceText);
    }

}
