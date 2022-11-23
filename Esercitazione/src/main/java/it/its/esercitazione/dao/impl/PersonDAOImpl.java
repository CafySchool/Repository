package it.its.esercitazione.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.its.esercitazione.database.Database;
import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.IPersonDAO;

public class PersonDAOImpl implements IPersonDAO{

	private Connection connection;
	
	public PersonDAOImpl() {
		super();
		this.connection = Database.getInstance().getConnection();
	}



	@Override
	public Person save(Person person) {
		PreparedStatement query;
		try {
			query = connection.prepareStatement("INSERT INTO PERSON (Name,Surname) VALUES (?,?)");
			query.setString(1, person.getName());
			query.setString(2, person.getSurname());
			query.executeUpdate();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

}

