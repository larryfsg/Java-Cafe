package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Order;

// Class that puts an order in the sales records csv file
public class SalesReportUpdater{
    
    public static void update(ArrayList<Order> orderList, String fileName){

        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName), true)){

            for(Order order : orderList){
                writer.println(
                    order.getCoffeeName() + "," +
                    order.getSize() + "," +
                    order.getUnityPrice() + "," +
                    order.getQuantity() + "," +
                    order.getPrice()
                );
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}