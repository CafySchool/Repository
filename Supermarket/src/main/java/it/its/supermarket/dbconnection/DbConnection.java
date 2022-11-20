package it.its.supermarket.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.its.supermarket.utils.Constants;

public class DbConnection {
	private static DbConnection instance;
	private Connection connection;
	
	private static String url = Constants.URL;
	private static String username = Constants.USERNAME;
	private static String password = Constants.PASSWORD;

	private DbConnection() throws SQLException {
	    try {
	      Class.forName("org.postgresql.Driver");
	      this.connection = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException ex) {
	      System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
	    }
	  }
	  public Connection getConnection() {
	    return connection;
	  }
	  public static DbConnection getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new DbConnection();
	    } else if (instance.getConnection().isClosed()) {
	      instance = new DbConnection();
	    }
	    return instance;
	  }
}
