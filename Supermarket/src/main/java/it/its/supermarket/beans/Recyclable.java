package it.its.supermarket.beans;

import it.its.supermarket.utils.Constants;

public class Recyclable extends Product {
private String material;
	public Recyclable(String material, String description, double price) {
		super(description, price);
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	@Override
	public String toString() {
		 
		return super.toString() + "NotFood [material=" + material + "]";
	}
@Override
public void applyDiscount () {
	if(Constants.PLASTIC.equals(this.material) || Constants.GLASS.equals(this.material)
	|| Constants.PAPER.equals(this.material)) {
		super.setPrice(getPrice() * 0.90); 
	} else {
		super.applyDiscount();
	}
	
}
	

}
