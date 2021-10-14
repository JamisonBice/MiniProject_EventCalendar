package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.EventItem;


/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 14, 2021
 */
public class EventItemHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject_EventCalendar");
	
	public void insertItem(EventItem ei) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ei);
		em.getTransaction().commit();
		em.close();	
	}
	
	public List<EventItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<EventItem> allItems = em.createQuery("SELECT i from EventItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(EventItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EventItem> typedQuery = em.createQuery("select ei from EventItem ei where "
				//+ "ei.eventDate = :selectedEventDate and "
				+ "ei.eventType = :selectedEventType and "
				+ "ei.eventName = :selectedEventName", EventItem.class);
		
		//typedQuery.setParameter("selectedEventDate", toDelete.getEventDate());
		typedQuery.setParameter("selectedEventType", toDelete.getEventType());
		typedQuery.setParameter("selectedEventName", toDelete.getEventName());
		
		typedQuery.setMaxResults(1);
		
		EventItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public EventItem searchForEventById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		EventItem found = em.find(EventItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEvent(EventItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<EventItem> searchForEventByType(String eventType) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EventItem> typedQuery = em.createQuery("select ei from EventItem ei where ei.eventType = :selectedEventType", EventItem.class);
		
		typedQuery.setParameter("selectedEventType", eventType);
		
		List<EventItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<EventItem> searchForEventByName(String eventName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EventItem> typedQuery = em.createQuery("select ei from EventItem ei where ei.eventName = :selectedEventName", EventItem.class);
		
		typedQuery.setParameter("selectedEventName", eventName);
		
		List<EventItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<EventItem> searchForEventByDate(LocalDate eventDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EventItem> typedQuery = em.createQuery("select ei from EventItem ei where ei.eventDate = :selectedEventDate", EventItem.class);
		
		typedQuery.setParameter("selectedEventDate", eventDate);
		
		List<EventItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
