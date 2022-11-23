package it.its.mywebapp.idao;

import java.util.ArrayList;

import it.its.mywebapp.model.Event;

public interface IEventformDAO {
	public boolean save(Event event);

	public ArrayList<Event> findAll();

	public boolean delete(int id);

	public Event findById(int id);
}
