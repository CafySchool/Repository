package it.its.supermarket;

import java.sql.SQLException;
import java.util.Scanner;

import it.its.supermarket.logic.Logic;
import it.its.supermarket.utils.Constants;


public class Main {
	   public static void main(String[] args) throws SQLException {
	  Logic logic = new Logic();
	  Scanner scanner = new Scanner(System.in);

		System.out.println(Constants.INSERT+Constants.BADGE);
		boolean badge = logic.insertBadge();
		boolean repeat = true;
		while (repeat) {
			System.out.println(Constants.ONE +Constants.INSERT +Constants.PRODUCT);
			System.out.println(Constants.TWO + Constants.PRODUCTLIST);
			System.out.println(Constants.THREE + Constants.TOTAL);
			System.out.println(Constants.ZERO + Constants.TOTAL + Constants.CLOSE);
			String scelta = scanner.nextLine();
			switch (scelta) {
			case Constants.ZERO:
				logic.showList();
				logic.total();
				repeat = false;
				System.out.println(Constants.CLOSE);
				break;
			case Constants.ONE:
				logic.productType(badge);
				break;
			case Constants.TWO:
				logic.showList();
				break;

			case Constants.THREE:
				logic.total();
				break;

			default:
			}
		}
		scanner.close();
	    }
}
