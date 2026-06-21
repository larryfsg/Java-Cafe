package model;


public class Coffee{
    // Attributes
	private String name; 		// Holds the coffee's name
	private String ingredients; // Coffee's ingredients
	private String imgPath;

	private double priceSizeS; // Coffee's price by size
	private double priceSizeM;
	private double priceSizeL;

	private int qtdS;			// Coffee's inventory level by size
	private int qtdM;
	private int qtdL;
				     

	// Class constructor
	public Coffee(String nameinput, String ingred, double priceS, double priceM, double priceL){
		this.name = nameinput;
		this.ingredients = ingred;
		String aux = ("/view/images/"+ nameinput.replaceAll("\\s","") +".jpeg");
		this.imgPath = aux;
		this.priceSizeS= priceS;
		this.priceSizeM = priceM;
		this.priceSizeL = priceL;
	}

	// Method that sets coffee's inventory level
	public void setInventory(char size, int amount){
		if (size == 'S'){
			this.qtdS = amount;
		}
		else if (size == 'M'){
			this.qtdM = amount;
		}
		else{
			this.qtdL = amount;
		}
	}

	// Method that returns coffee's name
	public String getName(){
		return this.name;
	}

	// Method that returns coffee's price given its size
	public double getPrice(char size){
		if (size == 'S'){
			return this.priceSizeS;
		}
		else if (size == 'M'){
			return this.priceSizeM;
		}
		else{
			return this.priceSizeL;
		}
	}

	// Method that returns coffees ingredients
	public String getIngredients(){
		return this.ingredients;
	}
    
	// Method that returns coffee's img path
	public String getImgPath(){
		return this.imgPath;
	}

	// Method that returns coffee's stock level given its size
	public int getStock(char size){
		if (size == 'S'){
			return this.qtdS;
		}
		else if (size == 'M'){
			return this.qtdM;
		}
		else{
			return this.qtdL;
		}
	}





	@Override
	public String toString() {
		return "Coffee{" +
			"name='" + name + '\'' +
			", ingredients='" + ingredients + '\'' +
			", qtdS=" + qtdS +
			", qtdM=" + qtdM +
			", qtdL=" + qtdL +
			", priceS=" + priceSizeS +
			", priceM=" + priceSizeM +
			", priceL=" + priceSizeL +
			'}';
	}
}