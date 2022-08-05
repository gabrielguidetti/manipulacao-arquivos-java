package application;

public class Product implements Comparable<Product>{
	private String name;
	private double price;
	private int qtd;
	
	public Product(String name, double price, int qtd) {
		this.name = name;
		this.price = price;
		this.qtd = qtd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public double amount() {
		return price*qtd;
	}
	
	@Override
	public String toString() {
		return name+","+amount();
	}

	@Override
	public int compareTo(Product o) {
		return name.compareTo(o.getName());
	}
	
}
