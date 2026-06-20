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

    // Method thar returns one coffee from inventory
    public Coffee getCoffee(String coffeeName){

        for (Coffee coffee : products){
            if(coffeeName.equals(coffee.getName())){
                return coffee;
            }

        }

        // in case coffee wasn't found
        return null;
    }
}