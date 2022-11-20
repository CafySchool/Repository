package it.myproject.bean;

import java.util.UUID;

public class Product {
	private String description;
	private String code;
	private double price;

	public Product(String description, double price) {
		this.description = description;
		this.code = UUID.randomUUID().toString();
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [description=" + description + ", code=" + code + ", price=" + price + "]";
	}

	public void applyDiscount() {
		this.price = price * 0.95;
		System.out.println("Sconto: 5%");
		System.out.println("Prezzo: " + price);
	}

}
