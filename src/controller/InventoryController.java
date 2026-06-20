package controller;

import model.Inventory;
import model.Coffee;
import view.InventoryScreen;
import view.JavaCafeGUI;

public class InventoryController {
    private JavaCafeGUI javaCafeGUI;
    private InventoryScreen inventoryScreen;
    private Inventory inventory;

    public InventoryController(JavaCafeGUI javaCafe, Inventory invent){
        this.javaCafeGUI = javaCafe;
        this.inventoryScreen = javaCafe.getInventoryScreen();
        this.inventory = invent;
    }

    public void addProductsToInventory(){
        String coffeeName;
        int sQtd;
        int mQtd;
        int lQtd;

        for (Coffee coffee : inventory.getProducts()){
            coffeeName = coffee.getName();
            sQtd = coffee.getStock('S');
            mQtd = coffee.getStock('M');
            lQtd = coffee.getStock('L');

            inventoryScreen.addProduct(coffeeName, sQtd, mQtd, lQtd);
        }
    }

}
