import controller.InventoryController;
import controller.MenuController;
import controller.OrderController;
import model.Inventory;
import persistence.InventoryCSVLoader;
import view.*;

//import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Main {
    
    public static void main(String args[]){

        //FlatMacLightLaf.setup();

        // Loading inventory from csv file --------------------------------------------------------
        Inventory javaCafeInventory = InventoryCSVLoader.load("coffees.csv");
        if (javaCafeInventory == null){
            return;
        }

        // Creating the application's GUI ---------------------------------------------------------
        JavaCafeGUI javaCafeGUI = new JavaCafeGUI();
        

        // Creatin Inventory Controller -----------------------------------------------------------
        // Manage inventory data: connects and synchronizes inventory business logic with the user interface, ensuring data persistence.
        InventoryController inventoryController = new InventoryController(javaCafeGUI, javaCafeInventory);
        inventoryController.addProductsToInventory();
        

        // Creating Menu Controler ----------------------------------------------------------------
        // Manages products in the menu: loads products into menu and handles user actions such as adding items to the cart.
        MenuController menuController = new MenuController(javaCafeGUI, javaCafeInventory);
        menuController.addProductsToMenu();
 

        // Creating Order Controller --------------------------------------------------------------
        // It represents the business logic of orders (removing orders, changing quantity, and handling order confirmations)
        OrderController orderController = new OrderController(javaCafeGUI, javaCafeInventory, inventoryController);
        menuController.setOrderController(orderController);
        inventoryController.setOrderController(orderController);
    }


}
