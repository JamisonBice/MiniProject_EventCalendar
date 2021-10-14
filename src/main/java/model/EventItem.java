package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 13, 2021
 */
@Entity
@Table(name="events")
public class EventItem {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "EVENT_TYPE")
	private String eventType;
	@Column(name = "EVENT_NAME")
	private String eventName;
	@Column(name = "EVENT_DATE")
	private LocalDate eventDate;
	
	public EventItem() {
		super();
	}
	
	public EventItem(String eventType, String eventName, LocalDate eventDate) {
		super();
		this.eventType = eventType;
		this.eventName = eventName;
		this.eventDate = eventDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	
	public String returnEventDetails() {
		
		return this.eventDate + ";" + this.eventType + ":" + this.eventName;
	}

}
