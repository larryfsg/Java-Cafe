package controller;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import model.Coffee;
import model.Inventory;
import model.OutOfStockException;
import view.JavaCafeGUI;
import view.Menu;
import view.PickSize;

public class MenuController implements ActionListener{
   // Needs order controller for when user tries to add coffee to cart
   private OrderController orderController;

   private JavaCafeGUI javaCafeGUI;
   private Menu menu;
   private Inventory inventory;

   // Constructor
   public MenuController(JavaCafeGUI javaCafe, Inventory inputInventory){
      this.javaCafeGUI = javaCafe;
      this.menu = javaCafe.getMenu();
      this.inventory = inputInventory;
   }
    
   // Loads all products from inventory to menu
   public void addProductsToMenu(){
      String coffeeName;
      String coffeeImgPath;

      // For each coffee in inventory
      for (Coffee coffee : inventory.getProducts()){

         coffeeName = coffee.getName();
         coffeeImgPath = coffee.getImgPath();

         menu.addCoffee(coffeeName, coffeeImgPath, this);
      }

   }

   // Action listener for coffee buttons
   @Override 
    public void actionPerformed(ActionEvent e){
		String coffeeName = e.getActionCommand();

      PickSize pickSizePopUp;

      Coffee coffee = inventory.getCoffee(coffeeName);
      if (coffee != null){ // if coffee is found in inventory

         // Formatting coffee's prices for view (pickSizePopUp)
         String sPrice = String.format("R$%.2f", coffee.getPrice('S'));
         String mPrice = String.format("R$%.2f", coffee.getPrice('M'));
         String lPrice = String.format("R$%.2f", coffee.getPrice('L'));
         pickSizePopUp = new PickSize(javaCafeGUI, coffee.getName(), coffee.getIngredients(), sPrice, mPrice, lPrice);
      
         // When pickSize is closed:
         if (pickSizePopUp.getStatus()){ // If size was selected

            char size = pickSizePopUp.getSelectedSize();

            // Tries to add coffee to cart
            try{
               orderController.addOrderToCart(coffeeName, size);  
            
            } catch(OutOfStockException ex){
               JOptionPane.showMessageDialog(menu, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

         }
      }
   }

   // Sets order controller
   public void setOrderController(OrderController oc){
      this.orderController = oc;
   }

}
