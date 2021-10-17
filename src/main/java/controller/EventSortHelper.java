package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.EventSort;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 16, 2021
 */
public class EventSortHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject_EventCalendar");

	public void insertEventSort(EventSort d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}

	public List<EventSort> showAllEventSorts() {
		EntityManager em = emfactory.createEntityManager();
		List<EventSort> allEventSorts = em.createQuery("SELECT d  FROM EventSort d").getResultList();
		return allEventSorts;
	}
	public EventSort findEventSort(String nameToLookUp) { 
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin(); 
		TypedQuery<EventSort> typedQuery = em.createQuery("select de  from EventSort de where de.eventSortName = :selectedName", EventSort.class);
		typedQuery.setParameter("selectedName", nameToLookUp); typedQuery.setMaxResults(1); 
		EventSort foundEventSort; 
		try { 
		foundEventSort = typedQuery.getSingleResult(); 
		} catch (NoResultException ex) { 
		foundEventSort = new EventSort(nameToLookUp); 
		} 
		em.close(); 
		return foundEventSort; 
		}
