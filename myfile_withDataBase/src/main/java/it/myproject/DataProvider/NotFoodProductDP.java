package it.myproject.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.myproject.bean.NotFood;
import it.myproject.util.Constant;

public class NotFoodProductDP {

	/**
	 * metodi CRUD + connessione
	 */

	public NotFoodProductDP() {
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
	 * Inserire prodotti all'interno della tabella notfood del database
	 */
	private static final String INSERT_simpleproductdp = "INSERT INTO notfoodproductdp"
			+ "  (description, code, price, material) VALUES " + " (?, ?, ?, ?);";

	public void insertRecord(NotFood notFood) throws SQLException {
		System.out.println(INSERT_simpleproductdp);

		try (Connection connection = NotFoodProductDP.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_simpleproductdp)) {
			preparedStatement.setString(1, notFood.getDescription());
			preparedStatement.setString(2, notFood.getCode());
			preparedStatement.setDouble(3, notFood.getPrice());
			preparedStatement.setString(4, notFood.getMaterial());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			NotFoodProductDP.printSQLException(e);
		}

	}

	/**
	 * ottenere la lista di tutti i prodotti not food presenti nella tabella
	 */

	private static final String QUERY = "SELECT description, code, price, material FROM notfoodproductdp;";

	public void selectRecord() throws SQLException {
		try (Connection connection = NotFoodProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Not Food Products: ");
			ResultSet rs = statement.executeQuery(QUERY);
			while (rs.next()) {
				String description = rs.getString("description");
				String code = rs.getString("code");
				double price = rs.getDouble("price");
				String material = rs.getString("material");
				System.out.println("[Description: " + description + ", Code: " + code + ", Price: " + price
						+ ", Material: " + material + "]");
			}
		} catch (SQLException e) {
			NotFoodProductDP.printSQLException(e);
		}
	}

	/**
	 * Calcolo del totale parziale dei prezzi dei prodotti presenti nella tabella
	 * not food
	 */

	private static final String QUERYPRICE = "SELECT price FROM notfoodproductdp;";

	public double totalPrice() throws SQLException {
		double notFoodTotal = 0;
		try (Connection connection = SimpleProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Prodotti riciclabili: ");
			ResultSet rs = statement.executeQuery(QUERYPRICE);
			while (rs.next()) {
				double price = rs.getDouble("price");
				notFoodTotal = notFoodTotal + price;
			}
			System.out.println("Totale parziale: " + notFoodTotal);
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
		return notFoodTotal;
	}

	/**
	 * Rinominare la descrizione di un prodotto della tabella not food inserendone
	 * il codice identificativo
	 */

	private static final String UPDATE_simpleproductdp = "update notfoodproductdp set description = ? where code = ?;";

	public void updateRecord(String code, String description) throws SQLException {
		System.out.println(UPDATE_simpleproductdp);

		try (Connection connection = NotFoodProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_simpleproductdp)) {
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, code);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			NotFoodProductDP.printSQLException(e);
		}
	}

	/**
	 * Eliminare un prodotto della tabella food inserendone il codice identificativo
	 */

	private static final String DELETE_simpleproductdp = "delete from notfoodproductdp where code = ?;";

	public void deleteRecord(String code) throws SQLException {

		System.out.println(DELETE_simpleproductdp);
		try (Connection connection = NotFoodProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_simpleproductdp)) {
			preparedStatement.setString(1, code);
			preparedStatement.execute();
		} catch (SQLException e) {
			NotFoodProductDP.printSQLException(e);
		}
	}
}
