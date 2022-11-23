package it.its.mywebapp.model;

import java.sql.Timestamp;

public class Registration {
	private int id;
	private int personId;
	private int eventId;
	private Timestamp registrationtime;
	
	public Registration() {
		super();
	}

	public Registration(int id, int personId, int eventId, Timestamp registrationtime) {
		super();
		this.id = id;
		this.personId = personId;
		this.eventId = eventId;
		this.registrationtime = registrationtime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Timestamp getRegistrationtime() {
		return registrationtime;
	}

	public void setRegistrationtime(Timestamp registrationtime) {
		this.registrationtime = registrationtime;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", personId=" + personId + ", eventId=" + eventId + ", registrationtime="
				+ registrationtime + "]";
	}

}

