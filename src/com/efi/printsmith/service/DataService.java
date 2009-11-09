package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.efi.printsmith.messaging.MessageServiceAdapter;

public class DataService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(DataService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;
	
	public DataService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (RuntimeException e) {
			log.error(e);
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
	
	public ModelBase addUpdate(ModelBase object) throws Exception {
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
				object = em.merge(object);
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
		return object;
	}

	public void addChargeCategoryToCommand(ChargeCategory category, ChargeCommand command) throws Exception {
		log.debug("** addChargeCategoryToCommand called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			
			if (command == null || category == null) {
				String msg = "null value passed to addChargeCategoryToCommand";
				log.error(msg);
				throw new Exception (msg);
			} else {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					command.addChildren(category);
					em.merge(command);
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
		}
		catch (Exception e) {
			log.error("Exception caught");
		}
	}
	
	public Charge addChargeToCategory(Charge charge, ChargeCategory category) throws Exception {
		log.debug("** addChargeCategoryToCommand called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			
			if (charge == null || category == null) {
				String msg = "null value passed to addChargeCategoryToCommand";
				log.error(msg);
				throw new Exception (msg);
			} else {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					category.addChildren(charge);
					em.merge(category);
					tx.commit();
					MessageServiceAdapter.sendNotification("Object Created");
					return charge;
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());
					
				} finally {
					log.info("** Closing Entity Manager.");
					em.close();
				}
			}
		}
		catch (Exception e) {
			log.error("Exception caught");
		}
		return null;
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
    public List<Invoice> getByAccountId(String className, Long id) throws Exception {      
    	try {            
    		log.debug("** getByaccountid Id called...");                
    		EntityManager em = entityManagerFactory.createEntityManager();  
    		
    		String queryString = "select a from "+className+" a where a.account.id = :id";
    		
    		Query query = em.createQuery(queryString);           
    		query.setParameter("id", id);            
    		List<Invoice>  invoicelist = query.getResultList();   
    		if (invoicelist != null)
    		 	log.debug("** Found " + invoicelist.size() + "records:");
    		return invoicelist;        
    	} catch (Exception e) { 
    		log.error(e);       
   		}        
    	return null;            
   	} 

    
	public List<TimeCard> getByClockInOut(String className, Employee employee) throws Exception {      
    	try {            
    		log.debug("** getByEmployee Id called...");                
    		EntityManager em = entityManagerFactory.createEntityManager();  
    		
    		DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = new java.util.Date();
    		
    		String queryString = "from "+className+" where to_char(startdatetime,'YYYY-MM-DD') = '"+dateFormat.format(date).toString() + "' and employee = :employee and onClock = 1";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
    		List<TimeCard>  timecardlist = query.getResultList();   
    		if (timecardlist != null)
    		 	log.debug("** Found " + timecardlist.size() + "records:");
    		return timecardlist;
    	} catch (Exception e) { 
    		log.error(e);       
   		}        
    	return null;            
   	} 

	public List<TimeCard> getByClockInOutBreak(String className, Employee employee) throws Exception {      
    	try {            
    		log.debug("** getByEmployee Id called...");                
    		EntityManager em = entityManagerFactory.createEntityManager();  
    		
    		DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = new java.util.Date();
    		
    		String queryString = "from "+className+" where to_char(breaktime,'YYYY-MM-DD') = '"+dateFormat.format(date).toString() + "' and employee = :employee and endDateTime = ''";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
    		List<TimeCard>  timecardlist = query.getResultList();   
    		if (timecardlist != null)
    		 	log.debug("** Found " + timecardlist.size() + "records:");
    		return timecardlist;
    	} catch (Exception e) { 
    		log.error(e);       
   		}        
    	return null;            
   	} 
    
    
    public List<SecuritySetup> getByAccessGroup(String className, AccessGroup accessGroup) throws Exception {      
    	try {            
    		log.debug("** getByAccess called...");                
    		EntityManager em = entityManagerFactory.createEntityManager(); 
    		String queryString = "select a from SecuritySetup a where a.accessGroup.id = :id";
			Query query = em.createQuery(queryString);
    		query.setParameter("id", accessGroup.getId());            
    		List<SecuritySetup>  securitySetups = query.getResultList();                
    		 
    		if (securitySetups != null)
    		 	log.debug("** Found " + securitySetups.size() + "records:");
    		return securitySetups;
    		 
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