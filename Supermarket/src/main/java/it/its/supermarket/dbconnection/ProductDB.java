package it.its.supermarket.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.its.supermarket.beans.Product;
import it.its.supermarket.utils.Constants;


public class ProductDB {
	public ProductDB() {}
	
	//POST
	public void save(Product product) throws SQLException {
		System.out.println(Constants.INSERT_productdb+Constants.COLUMNS+Constants.VALUES);
		try (Connection connection = DbConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_productdb + Constants.COLUMNS + Constants.VALUES))
		{
			preparedStatement.setString(1, product.getDescription());
			preparedStatement.setString(2, product.getCode());
			preparedStatement.setDouble(3, product.getPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getErrorCode();
		} 

	}
	//GET
	public void getAll() throws SQLException {
		try (Connection connection = DbConnection.getInstance().getConnection();
				Statement statement = connection.createStatement();)
			{
			ResultSet resultSet = statement.executeQuery(Constants.QUERY);
			while (resultSet.next()) {
				
				String code = resultSet.getString("code");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				System.out.println("[Code: " + code + ", Description: " + description + ", Price: " + price + "]");
			}
			
			} catch (SQLException e) {
				e.getErrorCode();
			}
	}

}
