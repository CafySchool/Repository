package it.myproject;

import java.util.Scanner;

import it.myproject.bean.MethodInput;

public class List {

	public static void main(String[] args) {
		MethodInput methodInput = new MethodInput();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("insert badge");
		boolean badge = methodInput.checkBadge();
		boolean repeat = true;
		while (repeat) {
			System.out.println("**digita 1 per inserire un nuovo prodotto********************");
			System.out.println("**digita 2 per visualizza elenco prodotti********************");
			System.out.println("**digita 3 per il totale*************************************");
			System.out.println("**digita 0 per totale e uscire*******************************");
			String scelta = scanner.nextLine();
			switch (scelta) {
			case "0":
				methodInput.productList();
				methodInput.totalPrice();
				repeat = false;
				System.out.println("*************************Cassa chiusa************************");
				break;
			case "1":
				methodInput.badgeCondition(badge);
				break;
			case "2":
				
				methodInput.productList();
				break;
			case "3":
				methodInput.totalPrice();
				break;
			default:
			}
		}
		scanner.close();
	}
}
