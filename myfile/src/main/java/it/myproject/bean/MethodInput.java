package it.myproject.bean;

import java.util.ArrayList;
import java.util.Scanner;

import it.myproject.util.Constant;

public class MethodInput {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Product> addCart = new ArrayList<Product>();

	public MethodInput() {

	}

	public void badgeCondition(boolean badge) {
		if (badge) {
			System.out.println("**digita 1 se il prodotto è un cibo *************************");
			System.out.println("**digita 2 se il prodotto è riciclabile *********************");
			System.out.println("**digita 3 se il prodotto non rientra nei casi precedenti****");
			String producType = scanner.nextLine();
			switch (producType) {
			case "1":
				foodBadge();
				break;
			case "2":
				notFoodBadge();
				break;
			case "3":
				justBadge();
				break;
			default:

			}

		} else {

			noBadge();
		}
	}

	public void foodBadge() {
		System.out.println("Insert description: ");
		String description = insertValue();
		System.out.println("Insert price: ");
		double price = checkPrice();
		System.out.println("Insert Day: ");
		int day = InsertDay();
		System.out.println("Insert Month: ");
		int month = InsertMonth();
		System.out.println("Insert Year: ");
		int year = InsertYear();
		Data data = new Data(day, month, year);
		Food food = new Food(description, price, data);
		System.out.println("Prezzo: " + price);
		food.applyDiscount();
		addProduct(food);
	}

	public void notFoodBadge() {
		System.out.println("Insert description: ");
		String description = insertValue();
		System.out.println("Insert price: ");
		double price = checkPrice();
		System.out.println("Insert material: ");
		String material = insertValue();
		NotFood notFood = new NotFood(description, price, material);
		System.out.println("Prezzo: " + price);
		notFood.applyDiscount();
		addProduct(notFood);
	}

	public void justBadge() {
		System.out.println("Insert description: ");
		String description = insertValue();
		System.out.println("Insert price: ");
		double price = checkPrice();
		Product product = new Product(description, price);
		System.out.println("Prezzo: " + price);
		product.applyDiscount();
		addProduct(product);
	}

	public void noBadge() {
		System.out.println("Insert description: ");
		String description = insertValue();
		System.out.println("Insert price: ");
		double price = checkPrice();
		Product product = new Product(description, price);
		System.out.println("Prezzo: " + price);
		product.getPrice();
		addProduct(product);
	}

	/**
	 * 
	 */
	public void addProduct(Product product) {
		addCart.add(product);
	}

	public void productList() {
		//
		for (int i = 0; i < addCart.size(); i++) {
			System.out.println(addCart.get(i));
			/*
			 * System.out.println("Description: " + addCart.get(i).getDescription());
			 * System.out.println("Price: " + addCart.get(i).getPrice());
			 * System.out.println("Code: " + addCart.get(i).getCode());
			 */
		}
	}

	public void totalPrice() {
		double total = 0;
		for (int i = 0; i < addCart.size(); i++) {
			total = total + addCart.get(i).getPrice();
		}
		System.out.println("totale = " + total);
	}

	public boolean checkBadge() {
		String str;
		do {

			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKBADGE))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKBADGE));
		boolean badge = Boolean.parseBoolean(str);
		return badge;
	}

	public double checkPrice() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKPRICE))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKPRICE));
		double i = Double.parseDouble(str);
		return i;
	}

	public static boolean isNullAndEmpty(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public String insertValue() {
		String str;
		do {
			str = scanner.nextLine();
			isNullAndEmpty(str);
			if (isNullAndEmpty(str)) {
				System.out.println("Enter a valid Value");
			}
		} while (isNullAndEmpty(str));
		return str;
	}

	public int InsertDay() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTDAY))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTDAY));
		int i = Integer.parseInt(str);
		return i;
	}

	public int InsertMonth() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTMONTH))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTMONTH));
		int i = Integer.parseInt(str);
		return i;
	}

	public int InsertYear() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTYEAR))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTYEAR));
		int i = Integer.parseInt(str);
		return i;
	}

	/*
	 * public void productInput() { System.out.println("Insert description: ");
	 * String description = scanner.nextLine();
	 * System.out.println("Insert price: "); double price = scanner.nextDouble();
	 * scanner.nextLine(); System.out.println("insert type: "); String type =
	 * scanner.nextLine(); if ("food".equals(type) && badge) {
	 * System.out.println("Insert Day: "); int day = scanner.nextInt();
	 * scanner.nextLine(); System.out.println("Insert Month: "); int month =
	 * scanner.nextInt(); scanner.nextLine(); System.out.println("Insert Year: ");
	 * int year = scanner.nextInt(); scanner.nextLine(); Data data = new Data(day,
	 * month, year); Food food = new Food(description, price, data);
	 * addCart.add(food = new Food(description, price, data));
	 * System.out.println("Prezzo: " + price); food.applyDiscount();
	 * 
	 * } else if ("not food".equals(type) && badge) {
	 * System.out.println("Insert material: "); String material =
	 * scanner.nextLine(); NotFood notFood = new NotFood(description, price,
	 * material); addCart.add(notFood = new NotFood(description, price, material));
	 * System.out.println("Prezzo: " + price); notFood.applyDiscount();
	 * 
	 * } else if (badge) { Product product = new Product(description, price);
	 * addCart.add(product = new Product(description, price));
	 * System.out.println("Prezzo: " + price); product.applyDiscount(); } else {
	 * Product product = new Product(description, price); addCart.add(product = new
	 * Product(description, price)); System.out.println("Prezzo: " + price);
	 * product.getPrice(); } }
	 */
	/*
	 * System.out.
	 * println("**digita 1 se il prodotto è un cibo e possiede il badge******");
	 * System.out.
	 * println("**digita 2 se il prodotto è riciclabile e possiede il badge**");
	 * System.out.
	 * println("**digita 3 possiede solo il badge****************************");
	 * System.out.
	 * println("**digita 0 se non possiede il badge**************************");
	 * String producType = scanner.nextLine(); switch (producType) { case "0":
	 * methodInput.noBadge(); break; case "1": methodInput.foodBadge(); break; case
	 * "2": methodInput.notFoodBadge(); break; case "3": methodInput.justBadge();
	 * break; default:
	 * 
	 * }
	 */

}
