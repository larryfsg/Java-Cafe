package controller;

import model.Inventory;
import model.Coffee;
import view.InventoryScreen;
import view.JavaCafeGUI;
import view.UpdateStockDialog;
import persistence.*;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class InventoryController implements ActionListener{
    private JavaCafeGUI javaCafeGUI;
    private InventoryScreen inventoryScreen;
    private Inventory inventory;

    private OrderController orderController;

    public InventoryController(JavaCafeGUI javaCafe, Inventory invent){
        this.javaCafeGUI = javaCafe;
        this.inventoryScreen = javaCafe.getInventoryScreen();
        this.inventory = invent;
    }

    public void addProductsToInventory(){
        String coffeeName;
        String imgPath;
        int sQtd;
        int mQtd;
        int lQtd;

        for (Coffee coffee : inventory.getProducts()){
            coffeeName = coffee.getName();
            imgPath = coffee.getImgPath();
            sQtd = coffee.getStock('S');
            mQtd = coffee.getStock('M');
            lQtd = coffee.getStock('L');

            inventoryScreen.addProduct(coffeeName, imgPath, sQtd, mQtd, lQtd, this);
        }
    }

    public void setOrderController(OrderController oc){
        this.orderController = oc;
    }

    // When an update button is hit in inventory screen
    @Override
    public void actionPerformed(ActionEvent e){

        // Finds coffee in inventory
        String coffeeName = e.getActionCommand();

        // Shows the dialog screen
        UpdateStockDialog dialog = new UpdateStockDialog(javaCafeGUI);
        dialog.setVisible(true);

        // Get text, and convert to integer if necessary
        String sText = dialog.getStockSText();
        String mText = dialog.getStockMText();
        String lText = dialog.getStockLText();
        Integer s = parseOrNull(sText);
        Integer m = parseOrNull(mText);
        Integer l = parseOrNull(lText);
    
        boolean sInCart = orderController.isAlreadyInCart(coffeeName, 'S');
        boolean mInCart = orderController.isAlreadyInCart(coffeeName, 'M');
        boolean lInCart = orderController.isAlreadyInCart(coffeeName, 'L');
        

        if ((sText.length()> 0 && sInCart) ||(mText.length()> 0 && mInCart) || (lText.length()> 0 && lInCart)){
            JOptionPane.showMessageDialog(
                null,
                "One of the products you want to update is in the cart. Remove it to proceed.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }


        // If a field has an invalid value, show a message
        if ((sText.length() > 0 && s == null) || (mText.length() > 0 && m == null) ||
            (lText.length() > 0 && l == null)){

            JOptionPane.showMessageDialog(
                null,
                "Insert a valid value",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }


        // If the field was not filled, do not change inventory for that size
        if (s == null) s = inventory.getCoffee(coffeeName).getStock('S');
        if (m == null) m = inventory.getCoffee(coffeeName).getStock('M');
        if (l == null) l = inventory.getCoffee(coffeeName).getStock('L');

        // When the change is confirmed
        if(dialog.isConfirmed()){
            try {
                inventory.updateStock(coffeeName, s, m, l);
                inventoryScreen.updateCoffeeButton(coffeeName, s, m, l);
                InventoryCSVSaver.save(inventory, "coffees.csv");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }

    // Decreases stock quantity in memory (model) and visually (GUI)
    public void onPurchaseAction(String coffeeName, char size, int qtd){
        Coffee coffee = inventory.getCoffee(coffeeName);

        try {
            inventory.decreaseStockQtd(coffee, size, qtd);

            inventoryScreen.updateCoffeeButton(coffeeName, coffee.getStock('S'), coffee.getStock('M'), coffee.getStock('L'));
            InventoryCSVSaver.save(inventory, "coffee.csv");
        }
        catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }

    // Utility function to partial update functionality
    private Integer parseOrNull(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
