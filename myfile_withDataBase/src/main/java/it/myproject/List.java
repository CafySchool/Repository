package it.myproject;

import java.sql.SQLException;
import java.util.Scanner;

import it.myproject.bean.MethodInput;
import it.myproject.util.Constant;

public class List {

	public static void main(String[] args) throws SQLException {
		MethodInput methodInput = new MethodInput();
		Scanner scanner = new Scanner(System.in);

		System.out.println("insert badge");
		boolean badge = methodInput.insertBadge();
		boolean repeat = true;
		while (repeat) {
			System.out.println("**digita 1 per inserire un nuovo prodotto********************");
			System.out.println("**digita 2 per visualizza elenco prodotti********************");
			System.out.println("**digita 3 per modificare la descrizione di un prodotto******");
			System.out.println("**digita 4 per eliminare un prodotto*************************");
			System.out.println("**digita 5 per il totale*************************************");
			System.out.println("**digita 0 per totale e uscire*******************************");
			String scelta = scanner.nextLine();
			switch (scelta) {
			case Constant.ZERO:
				methodInput.productListDB();
				methodInput.totalPrice();
				repeat = false;
				System.out.println("*************************Cassa chiusa************************");
				break;
			case Constant.ONE:
				methodInput.productType(badge);
				break;
			case Constant.TWO:
				methodInput.productListDB();
				break;
			case Constant.THREE:
				methodInput.renameProduct();
				break;
			case Constant.FOUR:
				methodInput.deleteProduct();
				break;
			case Constant.FIVE:
				methodInput.totalPrice();
				break;

			default:
			}
		}
		scanner.close();
	}
}
