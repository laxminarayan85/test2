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

public class CopyDefinitionsService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(CopyDefinitionsService.class);

	public CopyDefinitionsService() {

		super();

	}

	public List<CopierDefinition> getCopyDefinitions() {

		try {
			log.debug("** getCopyDefinitions called...");
	
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query q = em.createNamedQuery("CopyDefinition.findall");

			List<CopierDefinition> copyDefinitions = q.getResultList();
	
			if (copyDefinitions != null)
				log.debug("** Found " + copyDefinitions.size() + "records:");
	
			return copyDefinitions;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<CopierDefinition>();
	}

	public void addUpdateCopyDefinitions(CopierDefinition copyDefinitions) throws Exception {

		log.debug("** addUpdateCopyDefinitions called...");

		try {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

			em = emf.createEntityManager();
						
		// When passing Boolean and Number values from the Flash client to a

		// Java object, Java interprets null values as the default values for

		// primitive types; for example, 0 for double, float, long, int, short,

		// byte.

		if (copyDefinitions.getId() == null || copyDefinitions.getId() == 0) {

			// New consultant is created

			copyDefinitions.setId(null);

			copyDefinitions.setCreated(new Timestamp(new Date().getTime()));
			copyDefinitions.setModified(new Timestamp(new Date().getTime()));

		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(copyDefinitions);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("CopyDefinitions Created");
			
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

	public void deleteCopyDefinitions(Long id) {

		log.debug("** deleteCopyDefinitions called...");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("CopierDefinition.byId");

		q.setParameter("id", id);

		CopierDefinition copydefinitions = (CopierDefinition) q.getSingleResult();

		if (copydefinitions != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(copydefinitions);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("CopyDefinitions Deleted");
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