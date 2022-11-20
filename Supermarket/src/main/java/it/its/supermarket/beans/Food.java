package it.its.supermarket.beans;

import java.time.Year;

public class Food extends Product {
private int expireYear;
	public Food(int expireYear, String description, double price) {
		super(description, price);
		this.expireYear = expireYear;
	}
	public int getYear() {
		return expireYear;
	}
	public void setYear(int expireYear) {
		this.expireYear = expireYear;
	}
	@Override
	public String toString() {
		return super.toString() + "Food [expireYear=" + expireYear + "]";
	}
	@Override
	public void applyDiscount () {
		if(expireYear == Year.now().getValue()) {
			super.setPrice(getPrice() * 0.80); 
		} else {
			super.applyDiscount();
		}
		
	}

	
}
