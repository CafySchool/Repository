package it.its.mywebapp.idao;

import java.util.ArrayList;

import it.its.mywebapp.model.Person;

public interface IWebformDAO {
	public boolean save(Person person);

	public ArrayList<Person> findAll();

	public boolean delete(int id);

	public Person findById(int id);

}
