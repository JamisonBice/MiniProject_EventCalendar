package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EventSort;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 16, 2021
 */
public class EventSortHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject_EventCalendar");

	public void insertEventSort(EventSort es) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(es);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<EventSort> showAllEventSorts(){
		EntityManager em = emfactory.createEntityManager();
		List<EventSort> allEventSorts = em.createQuery("SELECT es from EventSort es").getResultList();
		return allEventSorts;
	}

}
