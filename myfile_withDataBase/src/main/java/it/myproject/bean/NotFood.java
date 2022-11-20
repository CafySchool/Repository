package it.myproject.bean;

import it.myproject.util.Constant;

public class NotFood extends Product {
	private String material;
	

	public NotFood(String description, double price, String material) {
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
		return "NotFood [" + super.toString() + "material=" + material + "]";
	}

	@Override
	public void applyDiscount() {
		if (Constant.PLASTIC.equals(this.material) || Constant.GLASS.equals(this.material)
				|| Constant.PAPER.equals(this.material)) {
			super.setPrice(getPrice() * 0.90);
			System.out.println("Sconto: 10%");
			System.out.println("Prezzo: " + getPrice());
		} else {
			super.applyDiscount();
			System.out.println("Sconto: 5%");
			System.out.println("Prezzo: " + getPrice());
		}
	}

}
