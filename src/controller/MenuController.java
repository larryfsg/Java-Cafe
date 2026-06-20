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
    
   // Adds all products to menu
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

         String sPrice = String.format("R$%.2f", coffee.getPrice('S'));
         String mPrice = String.format("R$%.2f", coffee.getPrice('M'));
         String lPrice = String.format("R$%.2f", coffee.getPrice('L'));
         pickSizePopUp = new PickSize(javaCafeGUI, coffee.getName(), coffee.getIngredients(), sPrice, mPrice, lPrice);
      
         if (pickSizePopUp.getStatus()){
            char size = pickSizePopUp.getSelectedSize();

            // Tries to add coffee to cart
            try{
               orderController.addOrderToCart(coffeeName, size);  
            
            } catch(OutOfStockException ex){

               JOptionPane.showMessageDialog(menu, ex.getMessage());
            }
         }
      }
   }

   public void setOrderController(OrderController oc){
      this.orderController = oc;
   }

}
