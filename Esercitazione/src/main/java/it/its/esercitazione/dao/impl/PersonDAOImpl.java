package it.its.esercitazione.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.its.esercitazione.database.Database;
import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.IPersonDAO;

public class PersonDAOImpl implements IPersonDAO{

	private Connection connection;
	
	public PersonDAOImpl() {
		super();
		this.connection = Database.getInstance().getConnection();
	}
	public void save(Person person) {
		PreparedStatement query;
		try {
			query = connection.prepareStatement("INSERT INTO PERSON (Id,Name,Surname) VALUES (?,?,?)");
			query.setString(1, person.getId());
			query.setString(2, person.getName());
			query.setString(3, person.getSurname());
			query.executeUpdate();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public ArrayList<Person> findAll() {
		ArrayList<Person> list = new ArrayList<Person>();
		Statement query;
		try {
			query = connection.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM PERSON");
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getString("Id"));
				person.setName(result.getString("Name"));
				person.setSurname(result.getString("Surname"));
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

	public void delete(String id) {
		try {
			PreparedStatement query;
			query = connection.prepareStatement("DELETE FROM PERSON as p WHERE p.id = ?;");
			query.setString(1, id);
			query.executeUpdate();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Person findById(String id) {
		Person person = new Person();
		PreparedStatement query;
		try {
			query = connection.prepareStatement("SELECT * FROM PERSON as p WHERE p.id=?");
			query.setString(1, id);
			ResultSet result = query.executeQuery();
			while (result.next()) {
				person.setId(result.getString("Id"));
				person.setName(result.getString("Name"));
				person.setSurname(result.getString("Surname"));
			}
			result.close();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
//	@Override
//	public void update(Person person) {
//		PreparedStatement query;
//		try {
//			query = connection.prepareStatement("INSERT INTO PERSON (Id,Name,Surname) VALUES (?,?,?)");
//			query.setString(1, person.getId());
//			query.setString(2, person.getName());
//			query.setString(3, person.getSurname());
//			query.executeUpdate();
//			query.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
}

