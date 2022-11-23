package it.its.mywebapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.its.mywebapp.database.Database;
import it.its.mywebapp.idao.IWebformDAO;
import it.its.mywebapp.model.Person;

public class WebformDAOImpl implements IWebformDAO {

	private Connection connection;

	public WebformDAOImpl() {
		super();
		this.connection = Database.getInstance().getConnection();
	}

	public boolean save(Person person) {
		boolean b = false;
		PreparedStatement query;
		try {
			query = connection.prepareStatement("INSERT INTO WEBFORM (Name,Surname,Age,Sex,Province,Email) VALUES (?,?,?,?,?,?)");
			query.setString(1, person.getName());
			query.setString(2, person.getSurname());
			query.setInt(3, person.getAge());
			query.setString(4, person.getSex());
			query.setString(5, person.getProvince());
			query.setString(6, person.getEmail());
			// System.out.println(query);
			int i = query.executeUpdate();
			if (i == 1) {
				b = true;
			} else {
				b = false;
			}
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public ArrayList<Person> findAll() {
		ArrayList<Person> list = new ArrayList<Person>();
		Statement query;
		try {
			query = connection.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM WEBFORM");
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getInt("Id"));
				person.setName(result.getString("Name"));
				person.setSurname(result.getString("Surname"));
				person.setAge(result.getInt("Age"));
				person.setSex(result.getString("Sex"));
				person.setProvince(result.getString("Province"));
				person.setEmail(result.getString("Email"));
				list.add(person);
			}
			result.close();
			query.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return list;

	}

	public boolean delete(int id) {
		boolean b = false;
		try {
			PreparedStatement query;
			query = connection.prepareStatement("DELETE FROM WEBFORM as c WHERE c.id = ?;");
			query.setInt(1, id);
			int result = query.executeUpdate();
			if (result == 1) {
				b = true;
			} else {
				b = false;
			}
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public Person findById(int id) {
		Person person = new Person();
		PreparedStatement query;
		try {
			query = connection.prepareStatement("SELECT * FROM WEBFORM as c WHERE c.id=?");
			query.setInt(1, id);
			ResultSet result = query.executeQuery();
			while (result.next()) {
				person.setId(result.getInt("Id"));
				person.setName(result.getString("Name"));
				person.setSurname(result.getString("Surname"));
				person.setAge(result.getInt("Age"));
				person.setSex(result.getString("Sex"));
				person.setProvince(result.getString("Province"));
				person.setEmail(result.getString("Email"));
			}
			result.close();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
}
