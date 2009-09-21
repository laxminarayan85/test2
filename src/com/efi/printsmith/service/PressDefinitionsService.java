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

public class PressDefinitionsService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(PressDefinitionsService.class);

	public PressDefinitionsService() {

		super();

	}

	public List<PressDefinitions> getPressDefinitions() {

		try {
			log.debug("** getPressDefinitions called...");
	
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query findAllQuery = em.createQuery("from Pressdefinitions");
			//Query findAllQuery = em.createNamedQuery("Account.findall");
			
			List<PressDefinitions> pressdefinitions = findAllQuery.getResultList();
	
			if (pressdefinitions != null)
	
				log.debug("** Found " + pressdefinitions.size() + "records:");
	
			return pressdefinitions;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<PressDefinitions>();
	}

	public void addUpdatepressdefinitions(PressDefinitions pressdefinitions) throws Exception {

		log.debug("** addUpdatePressDefinitions called...");

		try {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

			em = emf.createEntityManager();
						
		// When passing Boolean and Number values from the Flash client to a

		// Java object, Java interprets null values as the default values for

		// primitive types; for example, 0 for double, float, long, int, short,

		// byte.

		if (pressdefinitions.getId() == null || pressdefinitions.getId() == 0) {

			// New consultant is created

			pressdefinitions.setId(null);

			pressdefinitions.setCreated(new Timestamp(new Date().getTime()));

		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(pressdefinitions);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("PressDefinitions Created");
			
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

	public void deletePressDefinitions(Long id) {

		log.debug("** deletePressDefinitions called...");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("accounts.byId");

		q.setParameter("id", id);

		PressDefinitions pressdefinitions = (PressDefinitions) q.getSingleResult();

		if (pressdefinitions != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(pressdefinitions);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("PressDefinitions Deleted");
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