import controller.MenuController;
import model.Inventory;
import persistence.InventoryCSVLoader;
import view.*;
// import model.*;
// import model.Coffee;
// import persistence.InventoryCSVLoader;
// import persistence.InventoryCSVSaver;

public class Main {
    
    public static void main(String args[]){
        // Loading inventory from csv file
        Inventory javaCafeInventory = InventoryCSVLoader.load("coffees.csv");

        JavaCafeGUI javaCafeGUI = new JavaCafeGUI();

        MenuController menuController = new MenuController(javaCafeGUI, javaCafeInventory);
        menuController.addProductsToMenu();

    }


}
