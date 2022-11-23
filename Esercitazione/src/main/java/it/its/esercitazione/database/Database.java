package it.its.esercitazione.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static private class InstanceHolder {
		static public Database instance = new Database();
	}
	static  public Database getInstance() {
		return InstanceHolder.instance;
	}

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}


	private Database() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EsercitazioneDB", "postgres", "=7N8H`9u9$E?JCWM");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
