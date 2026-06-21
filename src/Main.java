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

        // Loading inventory from csv file
        Inventory javaCafeInventory = InventoryCSVLoader.load("coffees.csv");
       
        JavaCafeGUI javaCafeGUI = new JavaCafeGUI();
        
        InventoryController inventoryController = new InventoryController(javaCafeGUI, javaCafeInventory);
        inventoryController.addProductsToInventory();
        
        MenuController menuController = new MenuController(javaCafeGUI, javaCafeInventory);
        menuController.addProductsToMenu();

        OrderController orderController = new OrderController(javaCafeGUI, javaCafeInventory, inventoryController);
        menuController.setOrderController(orderController);
        inventoryController.setOrderController(orderController);
    }


}
