package model;
import java.util.ArrayList;

public class Inventory{

    // Array List that stores all the coffees
    private ArrayList<Coffee> products;

    // Constructor
    public Inventory(){
        products = new ArrayList<>();
    }

    // Method that adds product (coffee) to inventory
    public void addProduct(Coffee coffee){
        products.add(coffee);
    }
    
    // Method that removes product (coffee) from inventory
    public void removesProduct(Coffee coffee){
        products.remove(coffee);
    }

    // Method that returns products list
    public ArrayList<Coffee> getProducts(){
        return products;
    }

    // Method that returns one coffee from inventory given its name
    public Coffee getCoffee(String coffeeName){

        for (Coffee coffee : products){
            if(coffeeName.equals(coffee.getName())){
                return coffee;
            }
        }
        // in case coffee wasn't found
        return null;
    }

    // Method that decreases a coffee's stock level
    public void decreaseStockQtd(Coffee coffee, char size, int qtd){
        int newQtd = coffee.getStock(size) - qtd;
       
        coffee.setInventory(size, newQtd);
    }

    // Method that updates the stock level of a coffee in the inventory
    public void updateStock(String coffeeName, int sQtd, int mQtd, int lQtd){

        for (Coffee coffee : products){
            if(coffeeName.equals(coffee.getName())){
                coffee.setInventory('S', sQtd);
                coffee.setInventory('M', mQtd);
                coffee.setInventory('L', lQtd);
            }

        }
    }
}