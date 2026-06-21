import controller.InventoryController;
import controller.MenuController;
import controller.OrderController;
import model.Inventory;
import persistence.InventoryCSVLoader;
import view.*;


public class Main {
    
    public static void main(String args[]){
        // Loading inventory from csv file
        Inventory javaCafeInventory = InventoryCSVLoader.load("coffees.csv");
       
        JavaCafeGUI javaCafeGUI = new JavaCafeGUI();
        
        InventoryController inventoryController = new InventoryController(javaCafeGUI, javaCafeInventory);
        inventoryController.addProductsToInventory();
        
        MenuController menuController = new MenuController(javaCafeGUI, javaCafeInventory);
        menuController.addProductsToMenu();

        OrderController orderController = new OrderController(javaCafeGUI.getCart(), javaCafeInventory, inventoryController);
        menuController.setOrderController(orderController);
        inventoryController.setOrderController(orderController);
    }


}
