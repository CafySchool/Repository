package it.myproject.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.myproject.bean.Product;
import it.myproject.util.Constant;

public class SimpleProductDP {
	/**
	 * metodi CRUD + connessione
	 */

	public SimpleProductDP() {
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
	 * Inserire prodotti all'interno della tabella altri prodotti del database
	 */

	private static final String INSERT_simpleproductdp = "INSERT INTO simpleproductdp"
			+ "  (description, code, price) VALUES " + " (?, ?, ?);";

	public void insertRecord(Product product) throws SQLException {
		System.out.println(INSERT_simpleproductdp);

		try (Connection connection = SimpleProductDP.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_simpleproductdp)) {
			preparedStatement.setString(1, product.getDescription());
			preparedStatement.setString(2, product.getCode());
			preparedStatement.setDouble(3, product.getPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			SimpleProductDP.printSQLException(e);
		}

	}

	/**
	 * ottenere la lista di tutti i prodotti presenti nella tabella altri prodotti
	 */

	private static final String QUERY = "SELECT description, code, price FROM simpleproductdp;";

	public void selectRecord() throws SQLException {
		try (Connection connection = SimpleProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Simple Products: ");
			ResultSet rs = statement.executeQuery(QUERY);
			while (rs.next()) {
				String description = rs.getString("description");
				String code = rs.getString("code");
				double price = rs.getDouble("price");
				System.out.println("[Description: " + description + ", Code: " + code + ", Price: " + price + "]");
			}
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
	}

	/**
	 * Calcolo del totale parziale dei prezzi dei prodotti presenti nella tabella
	 * altri prodotti
	 */

	private static final String QUERYPRICE = "SELECT price FROM simpleproductdp;";

	public double totalPrice() throws SQLException {
		double simpleTotal = 0;
		try (Connection connection = SimpleProductDP.getConnection();
				Statement statement = connection.createStatement();) {
			System.out.println("Altri prodotti: ");
			ResultSet rs = statement.executeQuery(QUERYPRICE);
			while (rs.next()) {
				double price = rs.getDouble("price");
				simpleTotal = simpleTotal + price;
			}
			System.out.println("Totale parziale: " + simpleTotal);
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
		return simpleTotal;
	}

	/**
	 * Rinominare la descrizione di un prodotto della tabella altri prodotti
	 * inserendone il codice identificativo
	 */

	private static final String UPDATE_simpleproductdp = "update simpleproductdp set description = ? where code = ?;";

	public void updateRecord(String code, String description) throws SQLException {
		System.out.println(UPDATE_simpleproductdp);

		try (Connection connection = SimpleProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_simpleproductdp)) {
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, code);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
	}

	/**
	 * Eliminare un prodotto della tabella altri prodotti inserendone il codice
	 * identificativo
	 */

	private static final String DELETE_simpleproductdp = "delete from simpleproductdp where code = ?;";

	public void deleteRecord(String code) throws SQLException {

		System.out.println(DELETE_simpleproductdp);
		try (Connection connection = SimpleProductDP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_simpleproductdp)) {
			preparedStatement.setString(1, code);
			preparedStatement.execute();
		} catch (SQLException e) {
			SimpleProductDP.printSQLException(e);
		}
	}
}
