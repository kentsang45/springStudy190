package org.kent.domain;

public class Menu {
	
	private String name;
	private int price;
	
	// 생성자
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// toString
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}
 
	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
