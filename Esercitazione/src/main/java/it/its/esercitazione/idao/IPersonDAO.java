package it.its.esercitazione.idao;

import java.util.ArrayList;

import it.its.esercitazione.domain.Person;

public interface IPersonDAO {
	public void save(Person person);
	public void delete(String id);
	public Person findById(String id);
	public ArrayList<Person> findAll();
}
