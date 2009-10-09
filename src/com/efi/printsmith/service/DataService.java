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

public class DataService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(DataService.class);
	
	protected static EntityManagerFactory entityManagerFactory;
	
	public DataService() {
		super();
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public List<?> getAll(String className) {
		try {
			log.debug("** getAll called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createQuery("from " + className);
			List<?> resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList();
	}

	
	public List<Account> getByAccountsPartialName(String name) throws Exception {
		try {
			log.debug("** getAccountsByPartialName called...");
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			String queryString = "from Account where title like '" + name+ "%'";
			Query query = em.createQuery(queryString);
			List<Account> accounts = query.getResultList();
	
			if (accounts != null)
	
				log.debug("** Found " + accounts.size() + "records:");
	
			return accounts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Account>();		
	}
	public List<Employee> getByEmployeesPartialName(String name) throws Exception {
		try {
			log.debug("** getByEmployeesPartialName called...");
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			String queryString = "from Employee where title like '" + name+ "%'";
			Query query = em.createQuery(queryString);
			List<Employee> employees = query.getResultList();
	
			if (employees != null)
	
				log.debug("** Found " + employees.size() + "records:");
	
			return employees;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Employee>();		
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
	
	public void addUpdate(ModelBase object) throws Exception {
		log.debug("** addUpdateAccount called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();					
			if (object.getId() == null || object.getId() == 0) {
				object.setId(null);
				object.setCreated(new Timestamp(new Date().getTime()));
				object.setModified(new Timestamp(new Date().getTime()));
			} else {
				// Existing object is updated - do nothing.
			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(object);
				tx.commit();
				MessageServiceAdapter.sendNotification("Object Created");
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
	
    public ModelBase getById(String className, Long id) throws Exception {      
    	try {            
    		log.debug("** getById called...");                
    		EntityManager em = entityManagerFactory.createEntityManager();       
    		Query query = em.createNamedQuery(className + ".byId");           
    		query.setParameter("id", id);            
    		ModelBase object = (ModelBase) query.getSingleResult();                
    		return object;        
    	} catch (Exception e) { 
    		log.error(e);       
   		}        
    	return null;            
   	} 

	public void deleteItem(String className, Long id) {
		log.debug("** deleteObject called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery(className + ".byId");
		q.setParameter("id", id);
		ModelBase object = (ModelBase) q.getSingleResult();

		if (object != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(object);
				tx.commit();
				MessageServiceAdapter.sendNotification("Object Deleted");
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