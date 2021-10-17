package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 16, 2021
 */
@Entity
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private EventSort eventSort;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<EventItem> listOfItems;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, EventSort eventSort, List<EventItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.eventSort = eventSort;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, EventSort eventSort, List<EventItem> listOfItems) {
		super();
		this.listName = listName;
		this.eventSort = eventSort;
		this.listOfItems = listOfItems;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public EventSort getEventSort() {
		return eventSort;
	}

	public void setEventSort(EventSort eventSort) {
		this.eventSort = eventSort;
	}

	public List<EventItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<EventItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, EventSort eventSort) {
		super();
		this.listName = listName;
		this.eventSort = eventSort;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", eventSort=" + eventSort
				+ ", listOfItems=" + listOfItems + "]";
	}

}
