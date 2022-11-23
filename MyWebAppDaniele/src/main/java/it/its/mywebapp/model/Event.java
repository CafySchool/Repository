package it.its.mywebapp.model;

import java.time.LocalDate;

public class Event {
	private int id;
	private String eventName;
	private String description;
	private LocalDate startDate;
	
	public Event() {
		super();
	}
	
	public Event(int id, String eventName, String description, LocalDate startDate) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.description = description;
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", startDate=" + startDate + "]";
	}
	
}
