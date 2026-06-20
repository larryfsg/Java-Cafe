package model;

public class Order{
	private int id;
	private Coffee coffee;		
	private String coffeeName;
	private char Size;
	private int quantity;
	private double unityPrice;
	private double totalPrice;
	
	// Constructos: creates an order
	public Order(int ID, Coffee coffee, char size){
		this.id = ID;

		this.coffee = coffee;
		this.coffeeName = coffee.getName();
		this.quantity = 1;
		this.Size = size;
		this.unityPrice = coffee.getPrice(Size);
		this.totalPrice = unityPrice;
	}

    // This method changes the quantity of an order
	public void changeQtd(int newQtd){
		this.quantity = newQtd;
		this.totalPrice = quantity * unityPrice;
	}

	// Method that returns order's quantity
	public int getQuantity(){
		return this.quantity;
	}

	// Method that returns order's total price
	public double getPrice(){
		return this.totalPrice;
	}

	public String getCoffeeName(){
		return this.coffeeName;
	}

	public char getSize(){
		return this.Size;
	}

	public double getUnityPrice(){
		return this.unityPrice;
	}

	public int getId(){
		return this.id;
	}

}
