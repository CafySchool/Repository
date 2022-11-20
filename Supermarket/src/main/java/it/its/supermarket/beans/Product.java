package it.its.supermarket.beans;

import java.util.UUID;

public class Product {
private String code;
private String description;
private double price;


public Product(String description, double price) {
	super();
	this.code = UUID.randomUUID().toString();
	this.description = description;
	this.price = price;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


@Override
public String toString() {
	return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
}
public void applyDiscount () {
	 price *= 0.95;
}


}
