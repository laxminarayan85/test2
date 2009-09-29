package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.efi.printsmith.messaging.MessageServiceAdapter;

public class ContactService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ContactService.class);
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	public ContactService() {

		super();

	}

	public List<Contact> getContacts() {

		try {
			log.debug("** getContacts called...");
		
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query findAllQuery = em.createQuery("from Contact");
			//Query findAllQuery = em.createNamedQuery("Contact.findall");
			
			List<Contact> contacts = findAllQuery.getResultList();
	
			if (contacts != null)
	
				log.debug("** Found " + contacts.size() + "records:");
	
			return contacts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Contact>();
	}

	public List<Contact> getContactsByPartialName(String name) throws Exception {
		try {
			log.debug("** getCountactsByPartialName called...");
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			String queryString = "from Contact where title like '" + name+ "%'";
			Query query = em.createQuery(queryString);
			List<Contact> contacts = query.getResultList();
	
			if (contacts != null)
	
				log.debug("** Found " + contacts.size() + "records:");
	
			return contacts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Contact>();		
	}
	
	public void addUpdateContact(Contact contact) throws Exception {

		log.debug("** addUpdateCountact called...");

		try {
			EntityManager em;

			em = entityManagerFactory.createEntityManager();
						
		if (contact.getId() == null || contact.getId() == 0) {

			// New consultant is created

			contact.setId(null);

			contact.setCreated(new Timestamp(new Date().getTime()));
			contact.setModified(new Timestamp(new Date().getTime()));
		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(contact);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("Contact Created");
			
		} catch (Exception e) {

			log.error("** Error: " + e.getMessage());

			tx.rollback();

			throw new Exception(e.getMessage());

		} finally {

			log.info("** Closing Entity Manager.");

			em.close();

		}
		}
		catch (Exception e) {
			log.error("Exception caught");
		}

	}

	public void deleteContact(Long id) {

		log.debug("** deleteContact called...");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNamedQuery("contacts.byId");

		q.setParameter("id", id);

		Contact contact = (Contact) q.getSingleResult();

		if (contact != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(contact);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("Contact Deleted");
			} catch (Exception e) {

				log.error("** Error: " + e.getMessage());

				tx.rollback();

			} finally {

				log.info("** Closing Entity Manager.");

				em.close();

			}

		}

	}
}