package it.myproject.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import it.myproject.DataProvider.FoodProductDP;
import it.myproject.DataProvider.NotFoodProductDP;
import it.myproject.DataProvider.SimpleProductDP;
import it.myproject.util.Constant;

public class MethodInput {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Product> addCart = new ArrayList<Product>();

	public MethodInput() {
	}

	SimpleProductDP simpleProductDP = new SimpleProductDP();
	NotFoodProductDP notFoodProductDP = new NotFoodProductDP();
	FoodProductDP foodProductDP = new FoodProductDP();

	/**
	 * Menu in cui è possibile accedere se si possiede il badge e si può selezionare
	 * il tipo di prodotto da inserire
	 */

	public void productType(boolean badge) throws SQLException {
		if (badge) {
			System.out.println("**digita 1 se il prodotto è un cibo *************************");
			System.out.println("**digita 2 se il prodotto è riciclabile *********************");
			System.out.println("**digita 3 se il prodotto non rientra nei casi precedenti****");
			String producType = scanner.nextLine();

			switch (producType) {
			case Constant.ONE:
				Food food = foodBadge();
				addFoodBadge(food);

				break;
			case Constant.TWO:
				NotFood notFood = notFoodBadge();
				addNotFoodBadge(notFood);

				break;
			case Constant.THREE:
				Product product = justBadge();
				addJustBadge(product);
				break;
			default:

			}

		} else {

			Product product = noBadge();
			addNoBadge(product);
		}
	}

	/**
	 * Menu in cui è possibile scegliere che tipo di prodotto rinominare
	 */

	public void renameProduct() throws SQLException {
		System.out.println("**digita 1 per rinominare un cibo *******************************************");
		System.out.println("**digita 2 per rinominare un prodotto riciclabile ***************************");
		System.out.println("**digita 3 per rinominare un prodotto che non rientra nei casi precedenti****");
		String rename = scanner.nextLine();

		switch (rename) {
		case Constant.ONE:
			renameFoodProduct();
			break;
		case Constant.TWO:
			renameNotFoodProduct();
			break;
		case Constant.THREE:
			renameSimpleProduct();
			break;
		default:
		}
	}

	/**
	 * Consente di rinominare un prodotto di altro tipo
	 */

	public void renameSimpleProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		System.out.println("Insert description: ");
		String description = insertString();
		simpleProductDP.updateRecord(code, description);
	}

	/**
	 * Consente di rinominare un prodotto riciclabile
	 */

	public void renameNotFoodProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		System.out.println("Insert description: ");
		String description = insertString();
		notFoodProductDP.updateRecord(code, description);
	}

	/**
	 * Consente di rinominare un prodotto alimentare
	 */

	public void renameFoodProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		System.out.println("Insert description: ");
		String description = insertString();
		foodProductDP.updateRecord(code, description);
	}

	/**
	 * Menu in cui è possibile scegliere che tipo di prodotto eliminare
	 */

	public void deleteProduct() throws SQLException {
		System.out.println("**digita 1 per eliminare un cibo *******************************************");
		System.out.println("**digita 2 per eliminare un prodotto riciclabile ***************************");
		System.out.println("**digita 3 per eliminare un prodotto che non rientra nei casi precedenti****");
		String delete = scanner.nextLine();

		switch (delete) {
		case Constant.ONE:
			deleteFoodProduct();
			break;
		case Constant.TWO:
			deleteNotFoodProduct();
			break;
		case Constant.THREE:
			deleteSimpleProduct();
			break;
		default:
		}
	}

	/**
	 * Consente di rinominare un prodotto di altro tipo
	 */

	public void deleteSimpleProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		simpleProductDP.deleteRecord(code);
	}

	/**
	 * Consente di eliminare un prodotto riciclabile
	 */

	public void deleteNotFoodProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		notFoodProductDP.deleteRecord(code);
	}

	/**
	 * Consente di eliminare un prodotto alimentare
	 */

	public void deleteFoodProduct() throws SQLException {
		System.out.println("Insert code");
		String code = insertCode();
		foodProductDP.deleteRecord(code);
	}

	/**
	 * Consente di prendere da tastiera i dati di un prodotto alimentare
	 */

	public Food foodBadge() {
		System.out.println("Insert description: ");
		String description = insertString();
		System.out.println("Insert price: ");
		double price = insertPrice();
		System.out.println("Insert Day: ");
		int day = insertDay();
		System.out.println("Insert Month: ");
		int month = insertMonth();
		System.out.println("Insert Year: ");
		int year = insertYear();
		Data data = new Data(day, month, year);
		Food food = new Food(description, price, data);
		System.out.println("Prezzo: " + price);
		food.applyDiscount();
		return food;
	}

	/**
	 * Aggiungere il prodotto alimentare al database
	 */

	public void addFoodBadge(Food food) throws SQLException {
		foodProductDP.insertRecord(food);
	}

	/**
	 * Consente di prendere da tastiera i dati di un prodotto riciclabile
	 */

	public NotFood notFoodBadge() {
		System.out.println("Insert description: ");
		String description = insertString();
		System.out.println("Insert price: ");
		double price = insertPrice();
		System.out.println("Insert material: ");
		String material = insertString();
		NotFood notFood = new NotFood(description, price, material);
		System.out.println("Prezzo: " + price);
		notFood.applyDiscount();
		return notFood;
	}

	/**
	 * Aggiungere il prodotto riciclabile al database
	 */

	public void addNotFoodBadge(NotFood notFood) throws SQLException {
		notFoodProductDP.insertRecord(notFood);
	}

	/**
	 * Consente di prendere da tastiera i dati di un prodotto di altro tipo
	 */

	public Product justBadge() {
		System.out.println("Insert description: ");
		String description = insertString();
		System.out.println("Insert price: ");
		double price = insertPrice();
		System.out.println("Prezzo: " + price);
		Product product = new Product(description, price);
		product.applyDiscount();
		return product;
	}

	/**
	 * Aggiungere il prodotto di altro tipo al database
	 */

	public void addJustBadge(Product product) throws SQLException {
		simpleProductDP.insertRecord(product);
	}

	/**
	 * Consente di prendere da tastiera i dati di un prodotto di altro tipo
	 */

	public Product noBadge() {
		System.out.println("Insert description: ");
		String description = insertString();
		System.out.println("Insert price: ");
		double price = insertPrice();
		Product product = new Product(description, price);
		System.out.println("Prezzo: " + price);
		product.getPrice();
		return product;
	}

	/**
	 * Aggiungere il prodotto di altro tipo al database
	 */

	public void addNoBadge(Product product) throws SQLException {
		simpleProductDP.insertRecord(product);
	}

	/**
	 * Consente di avere la lista prodotti completa
	 */

	public void productListDB() throws SQLException {
		notFoodProductDP.selectRecord();
		foodProductDP.selectRecord();
		simpleProductDP.selectRecord();
	}

	/**
	 * Consente di avere il totale della lista dei prodotti completa
	 */

	public void totalPrice() throws SQLException {
		double total = foodProductDP.totalPrice() + notFoodProductDP.totalPrice() + simpleProductDP.totalPrice();
		System.out.println("Totale: " + total);
	}

	/**
	 * Consente di ottenere il badge da tastiera e validarlo
	 */

	public boolean insertBadge() {
		String str;
		do {

			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKBADGE))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKBADGE));
		boolean badge = Boolean.parseBoolean(str);
		return badge;
	}

	/**
	 * Consente di ottenere il prezzo da tastiera e validarlo
	 */

	public double insertPrice() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKPRICE))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKPRICE));
		double i = Double.parseDouble(str);
		return i;
	}

	/**
	 * Consente di ottenere una descrizione o un materiale da tastiera e validarli
	 */

	public String insertString() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKSTRING))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKSTRING));
		return str;
	}

	/**
	 * Consente di ottenere una descrizione o un materiale da tastiera e validarli
	 */

	public String insertCode() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.CHECKCODE))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.CHECKCODE));
		return str;
	}

	/**
	 * Consente di ottenere un giorno da tastiera e validarlo
	 */

	public int insertDay() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTDAY))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTDAY));
		int i = Integer.parseInt(str);
		return i;
	}

	/**
	 * Consente di ottenere mese da tastiera e validarlo
	 */

	public int insertMonth() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTMONTH))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTMONTH));
		int i = Integer.parseInt(str);
		return i;
	}

	/**
	 * Consente di ottenere un anno da tastiera e validarlo
	 */

	public int insertYear() {
		String str;
		do {
			str = scanner.nextLine();
			if (!str.matches(Constant.INSERTYEAR))
				System.out.println("Invalid Value\n");
		} while (!str.matches(Constant.INSERTYEAR));
		int i = Integer.parseInt(str);
		return i;
	}

}
