package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nick - ntambroson CIS175 - Fall 2021 Oct 16, 2021
 */
@Entity
@Table(name = "sort")
public class EventSort {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "Sort_Name")
	private String eventSortName;

	public EventSort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventSort(int id, String eventSortName) {
		super();
		this.id = id;
		this.eventSortName = eventSortName;
	}

	public EventSort(String eventSortName) {
		super();
		this.eventSortName = eventSortName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventSortName() {
		return eventSortName;
	}

	public void setEventSortName(String eventSortName) {
		this.eventSortName = eventSortName;
	}

	@Override
	public String toString() {
		return "Event Name [id=" + id + ", eventSortName=" + eventSortName + "]";
	}

}
