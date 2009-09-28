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

public class StockDefinitionsService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(StockDefinitionsService.class);

	public StockDefinitionsService() {

		super();

	}

	public List<Account> getStockDefinitions() {

		try {
			log.debug("** getStockDefinitions called...");
	
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query findAllQuery = em.createNamedQuery("Stock.findall");
			
			List<Account> stockDefinitions = findAllQuery.getResultList();
	
			if (stockDefinitions != null)
	
				log.debug("** Found " + stockDefinitions.size() + "records:");
	
			return stockDefinitions;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Account>();
	}

	public void addUpdateStockDefinitions(StockDefinition stockDefinitions) throws Exception {

		log.debug("** addUpdateStockDefinitions called...");

		try {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

			em = emf.createEntityManager();
						
		// When passing Boolean and Number values from the Flash client to a

		// Java object, Java interprets null values as the default values for

		// primitive types; for example, 0 for double, float, long, int, short,

		// byte.

		if (stockDefinitions.getId() == null || stockDefinitions.getId() == 0) {

			// New consultant is created

			stockDefinitions.setId(null);

			stockDefinitions.setCreated(new Timestamp(new Date().getTime()));

		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(stockDefinitions);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("Stock Created");
			
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

	public void deleteStockDefinitions(Long id) {

		log.debug("** deleteStockDefinitions called...");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("stock.byId");

		q.setParameter("id", id);

		StockDefinition stockDefinitions = (StockDefinition) q.getSingleResult();

		if (stockDefinitions != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(stockDefinitions);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("StockDefinitions Deleted");
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