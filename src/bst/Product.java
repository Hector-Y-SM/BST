package bst;

public class Product  implements Comparable<Product>{

	private int id;
	private String name;
	private String category;
	private double price;
	private int stock;
	
	Product(int id, String name, String category, double price, int stock){
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	
	int getId(){ return id; }
	void setId(int id){ this.id = id; }

	String getName(){ return name; }
	void setName(String name) { this.name = name; }
	
	String getCategory(){ return category; }
	void setCategory(String category) { this.category = category; }
	
	double getPrice(){ return price; }
	void setPrice(double price) { this.price = price; }
	
	double getStock(){ return stock; }
	void setStock(int stock) { this.stock = stock; }
	
	@Override
	//this method defines how to order or compare two Product objects using the id
	public int compareTo(Product arg0) {
		// return -n if this.id < arg0.id
		// return  0 if this.id == arg0.id
		// return +n if this.id > arg0.id
		return Integer.compare(this.id, arg0.id);
	}
	
	public String toString() {
        return "ID: " + id + ", nameProduct: " + name + ", Category: " + category + 
                ", Price: " + price + ", Stock: " + stock;
	}
}
