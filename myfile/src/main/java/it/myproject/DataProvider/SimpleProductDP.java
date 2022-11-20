package it.myproject.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.myproject.bean.Product;
import it.myproject.util.Constant;

public class SimpleProductDP {
	/**
	 * metodi CRUD + connessione
	 */
	
	private SimpleProductDP() {
	}

	private static String url = Constant.URL;
	private static String username = Constant.USERNAME;
	private static String password = Constant.PASSWORD;

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
}
