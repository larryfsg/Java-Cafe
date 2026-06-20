package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Coffee;
import model.Inventory;
import view.JavaCafeGUI;
import view.Menu;
import view.PickSize;

public class MenuController implements ActionListener{
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

   // Action listener for coffee buttons and Jdialog for size selection
   @Override 
    public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();

      // If coffee size was chosen ----------------------------------------------------------------
      if (command.equals("S") || command.equals("M") || command.equals("L")){
         // add order to cart !!
      }
      else{
      // If coffee button was clicked ------------------------------------------------------------
         
         Coffee coffee = inventory.getCoffee(command);
         if (coffee != null){
            String sPrice = String.format("R$%.2f", coffee.getPrice('S'));
            String mPrice = String.format("R$%.2f", coffee.getPrice('M'));
            String lPrice = String.format("R$%.2f", coffee.getPrice('L'));
            new PickSize(javaCafeGUI, coffee.getName(), coffee.getIngredients(), sPrice, mPrice, lPrice);
         }
      }
   }


}
