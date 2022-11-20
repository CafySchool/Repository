package it.its.supermarket.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import it.its.supermarket.beans.Food;
import it.its.supermarket.beans.Product;
import it.its.supermarket.beans.Recyclable;
import it.its.supermarket.dbconnection.ProductDB;
import it.its.supermarket.utils.Constants;

public class Logic {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Product> addCart = new ArrayList<Product>();
	ProductDB productDB = new ProductDB();
	public Logic() {
	}
	//UTILS
	private String setName() {
		System.out.println(Constants.INSERT + Constants.NAME);
		String name = scanner.nextLine();
		return name;
	}
	private String setMaterial() {
		System.out.println(Constants.INSERT + Constants.MATERIAL);
		String material = scanner.nextLine();
		return material;
	}
	public Double setPrice() {
		System.out.println(Constants.INSERT + Constants.PRICE);
		double price = scanner.nextDouble();
		scanner.nextLine();
		return price;
	}
	private Integer setYear() {
		System.out.println(Constants.INSERT + Constants.YEAR);
		int year = scanner.nextInt();
		scanner.nextLine();
		return year;	
	}
	
	//SETTINGS PRODUCT, RECYCLE, FOOD, NOBADGE
	public Product settingProductNoBadge() {
		Product product = new Product(setName(), setPrice());
		product.getPrice();
		return product;
	}
	public Product settingProductBadge() {
		Product product = settingProductNoBadge();
		product.applyDiscount();
		return product;
	}
	public Food settingFood() {
		Food food = new Food(setYear(), setName(), setPrice());
		food.applyDiscount();
		return food;
		
	}
	public Recyclable settingRecyclable() {
		Recyclable recyclable = new Recyclable(setMaterial(), setName(), setPrice());
		recyclable.applyDiscount();
		return recyclable;
	}
	//Check Badge
	public boolean insertBadge() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constants.CHECKBADGE))
				System.out.println(Constants.INVALID);
		} while (!str.matches(Constants.CHECKBADGE));
		boolean badge = Boolean.parseBoolean(str);
		return badge;
	}
	//INSERISCE RECORD DATABASE
	public void addProduct(Product product) throws SQLException {
		productDB.save(product);
	}
	//SELEZIONE TIPO PRODOTTO
	public void productType(boolean badge) throws SQLException {
		if (badge) {
			System.out.println(Constants.ONE + Constants.FOOD);
			System.out.println(Constants.TWO + Constants.RECYCLABLE);
			System.out.println(Constants.THREE + Constants.SIMPLEPRODUCT);
			String producType = scanner.nextLine();
			switch (producType) {
			case Constants.ONE:
				Food food = settingFood();
				addCart.add(food);
				break;
			case Constants.TWO:
				Recyclable recyclable = settingRecyclable();
				addCart.add(recyclable);
				break;
			case Constants.THREE:
				Product product = settingProductBadge();
				//addCart.add(product);
				addProduct(product);
				break;
			default:
			}
		} else {
			Product product = settingProductNoBadge();
			//addCart.add(product);
			addProduct(product);
		}
	}
	//LISTA PRODOTTI
	public void showList() throws SQLException {
		//for (Product product : addCart) {
			//System.out.println(product);
		productDB.getAll();
			
		//}
	}
	//TOTALE PREZZI
	public void total() {
		double total = 0 ;
		for(Product product : addCart) {
			total += product.getPrice();
		}
		System.out.println(total);
		
	}
}
