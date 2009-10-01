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

public class StockGroupService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(StockGroupService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public StockGroupService() {
		super();
	}

	public List<StockGroup> getStockGroup() {
		try {
			log.debug("** getStockGroup called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("StockGroup.findall");
			List<StockGroup> stockgroup = findAllQuery.getResultList();
			if (stockgroup != null) {
				log.debug("** Found " + stockgroup.size() + "records:");
			}
			return stockgroup;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<StockGroup>();
	}

public Boolean getStockGroupByName(String name) throws Exception {
		try {
			log.debug("** getStockGroupByName called...");
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			String queryString = "select a from StockGroup a where a.name = :name";
			Query query = em.createQuery(queryString);
			query.setParameter("name", name); 
			City city = (City) query.getSingleResult();   
			
	
			if (city != null)
	
				log.debug("** Found " );
	
			return true;
		} catch (Exception e) {
			log.error(e);
		}
		return false;		
	}
	public void addUpdateStockGroup(StockGroup stockgroup) throws Exception {
		log.debug("** addUpdateStockGroup called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (stockgroup.getId() == null || stockgroup.getId() == 0) {
				stockgroup.setId(null);
				stockgroup.setCreated(new Timestamp(new Date().getTime()));
				stockgroup.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(stockgroup);
				tx.commit();
				MessageServiceAdapter.sendNotification("StockGroup Created");
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw new Exception(e.getMessage());
			} finally {
				log.info("** Closing Entity Manager.");
				em.close();
			}
		} catch (Exception e) {
			log.error("Exception caught");
		}
	}

	public void deleteStockGroup(Long id) {
		log.debug("** deleteStockGroup called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("StockGroup.byId");
		q.setParameter("id", id);
		StockGroup stockgroup = (StockGroup) q.getSingleResult();

		if (stockgroup != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(stockgroup);
				tx.commit();
				MessageServiceAdapter.sendNotification("StockGroup Deleted");
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