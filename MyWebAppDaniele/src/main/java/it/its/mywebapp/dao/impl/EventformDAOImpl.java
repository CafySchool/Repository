package it.its.mywebapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.its.mywebapp.database.Database;
import it.its.mywebapp.idao.IEventformDAO;
import it.its.mywebapp.model.Event;

public class EventformDAOImpl implements IEventformDAO {

	private Connection connection;

	public EventformDAOImpl() {
		super();
		this.connection = Database.getInstance().getConnection();
	}

	public boolean save(Event event) {
		boolean b = false;
		PreparedStatement query;
		try {
			query = connection.prepareStatement("INSERT INTO EVENTFORM (EventName,Description,StartDate) VALUES (?,?,?)");
			query.setString(1, event.getEventName());
			query.setString(2, event.getDescription());
			query.setObject(3, event.getStartDate());
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
	public ArrayList<Event> findAll() {
		ArrayList<Event> list = new ArrayList<Event>();
		Statement query;
		try {
			query = connection.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM EVENTFORM");
			while (result.next()) {
				Event event = new Event();
				event.setId(result.getInt("Id"));
				event.setEventName(result.getString("EventName"));
				event.setDescription(result.getString("Description"));
				event.setStartDate(result.getDate("StartDate").toLocalDate());
				list.add(event);
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
			query = connection.prepareStatement("DELETE FROM EVENTFORM as c WHERE c.id = ?;");
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
	public Event findById(int id) {
		Event event = new Event();
		PreparedStatement query;
		try {
			query = connection.prepareStatement("SELECT * FROM EVENTFORM as c WHERE c.id=?");
			query.setInt(1, id);
			ResultSet result = query.executeQuery();
			while (result.next()) {
				event.setId(result.getInt("Id"));
				event.setEventName(result.getString("EventName"));
				event.setDescription(result.getString("Description"));
				event.setStartDate(result.getDate("StartDate").toLocalDate());
			}
			result.close();
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

}
