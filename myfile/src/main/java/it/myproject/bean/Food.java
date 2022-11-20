package it.myproject.bean;

public class Food extends Product {
	private Data expireDate;

	public Food(String description, double price, Data expireDate) {
		super(description, price);
		this.expireDate = expireDate;
	}

	public Data getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Data expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Food [" + super.toString() + "expireDate=" + expireDate + "]";
	}

	@Override
	public void applyDiscount() {
		Data data = new Data();
		int aDiff = data.getDifference(expireDate);
		if (aDiff < 10) {
			super.setPrice(getPrice() * 0.8);
			System.out.println("Sconto: 20%");
			System.out.println("Prezzo: " + getPrice());
		} else {
			super.applyDiscount();
			System.out.println("Sconto: 5%");
			System.out.println("Prezzo: " + getPrice());
		}

	}

}
