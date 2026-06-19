package persistence;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.*;
import view.CoffeeButton;
import view.JavaCafeGUI;
import view.*;

public class loadInventoryIntoGUI{
    // Coffee model -> Coffee JPanel
    private JavaCafeGUI mainFrame;
    private Inventory inventory;

    public loadInventoryIntoGUI(JavaCafeGUI javaCafe, Inventory invent){
        this.mainFrame = javaCafe;
        this.inventory = invent;
    }

    // This method creates a visual representation of a coffee and adds it to the GUI menu
    public void addCoffeeToMenu(){
        Menu menu = mainFrame.getOrderScreen().getMenu();

        for (Coffee coffee : inventory.getProducts()){
            String name = coffee.getName();
            String imgPath = coffee.getImgPath();

            CoffeeButton coffeeButton =  new CoffeeButton(name, imgPath);
            menu.addCoffee(coffeeButton);
        }
    }

    public void addCoffeToInventory(){
        
        for(Coffee coffee : inventory.getProducts()){
            InventoryScreen inventoryScreen = mainFrame.getInventoryScreen();

            CoffeeStockButton coffeeStockButton = 
            new CoffeeStockButton(coffee.getName(), "a", coffee.getStock('S'),
            coffee.getStock('M'), coffee.getStock('L'));

            inventoryScreen.addInventoryItems(coffeeStockButton);
        }

    }


    



}
