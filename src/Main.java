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

        JavaCafeGUI teste = new JavaCafeGUI();
        new PickSize(teste, "Milk coffee", "Coffee with milk.", "R$10.90", "18.90", "29.70");
    }


}
