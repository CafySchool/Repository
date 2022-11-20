package it.myproject.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.myproject.bean.Food;
import it.myproject.util.Constant;

public class FoodProductDP {

	/**
	 * metodi CRUD + connessione
	 */

	public FoodProductDP() {
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

	/**
	 * Inserire prodotti all'interno della tabella food del database
	 */
	private static final String INSERT_foodproductdp = "INSERT INTO foodproductdp"
			+ "  (description, code, price, expire_date) VALUES " + " (?, ?, ?, ?);";

	public void insertRecord(Food food) throws SQLException {
		System.out.println(INSERT_foodproductdp);

		try (Connection connection = FoodProductDP.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_foodproductdp)) {
			preparedStatement.setString(1, food.getDescription());
			preparedStatement.setString(2, food.getCode());
			preparedStatement.setDouble(3, food.getPrice());
			preparedStatement.setString(4, food.getExpireDate().toString());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			FoodProductDP.printSQLException(e);
		}

	}

	/**
	 * ottenere la lista di tutti i prodotti food presenti nella tabella
	 */

	private static final String QUERY = "SELECT description, code, price, expire_date FROM foodproductdp;";

	public void selectRecord() throws SQLException {
		try (Connection connection = FoodProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Food Products: ");
			ResultSet rs = statement.executeQuery(QUERY);
			while (rs.next()) {

				String description = rs.getString("description");
				String code = rs.getString("code");
				double price = rs.getDouble("price");
				String expire_date = rs.getString("expire_date");
				System.out.println("[Description: " + description + ", Code: " + code + ", Price: " + price
						+ ", Expire Date: " + expire_date + "]");
			}
		} catch (SQLException e) {
			FoodProductDP.printSQLException(e);
		}
	}

	/**
	 * Calcolo del totale parziale dei prezzi dei prodotti presenti nella tabella
	 * food
	 */

	private static final String QUERYPRICE = "SELECT price FROM foodproductdp;";

	public double totalPrice() throws SQLException {
		double foodTotal = 0;
		try (Connection connection = SimpleProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Prodotti alimnetari: ");
			ResultSet rs = statement.executeQuery(QUERYPRICE);
			while (rs.next()) {
				double price = rs.getDouble("price");
				foodTotal = foodTotal + price;
			}
			System.out.println("Totale parziale: " + foodTotal);
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
		return foodTotal;
	}

	/**
	 * Rinominare la descrizione di un prodotto della tabella food inserendone il
	 * codice identificativo
	 */

	private static final String UPDATE_foodproductdp = "update foodproductdp set description = ? where code = ?;";

	public void updateRecord(String code, String description) throws SQLException {
		System.out.println(UPDATE_foodproductdp);

		try (Connection connection = FoodProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_foodproductdp)) {
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, code);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			FoodProductDP.printSQLException(e);
		}
	}

	/**
	 * Eliminare un prodotto della tabella food inserendone il codice identificativo
	 */
	private static final String DELETE_foodproductdp = "delete from foodproductdp where code = ?;";

	public void deleteRecord(String code) throws SQLException {

		System.out.println(DELETE_foodproductdp);
		try (Connection connection = FoodProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_foodproductdp)) {
			preparedStatement.setString(1, code);
			preparedStatement.execute();
		} catch (SQLException e) {
			FoodProductDP.printSQLException(e);
		}
	}
}
