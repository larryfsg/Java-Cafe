package model;


// Exception for when user tries order unavailable coffee
public class OutOfStockException extends Exception {
    private char size;

    public OutOfStockException(String message, char s){
        super(message);
        this.size = s;
    }

    public char getSize(){
        return this.size;
    }

}
