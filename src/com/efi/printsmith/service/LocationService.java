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

public class LocationService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(LocationService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public LocationService() {
		super();
	}

	public List<Location> getLocations() {
		try {
			log.debug("** getLocations called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("Location.findall");
			List<Location> locations = findAllQuery.getResultList();
			if (locations != null) {
				log.debug("** Found " + locations.size() + "records:");
			}
			return locations;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Location>();
	}

	public void addUpdateLocation(Location location) throws Exception {
		log.debug("** addUpdateLocation called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (location.getId() == null || location.getId() == 0) {
				location.setId(null);
				location.setCreated(new Timestamp(new Date().getTime()));
				location.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(location);
				tx.commit();
				MessageServiceAdapter.sendNotification("Location Created");
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

	public void deleteLocation(Long id) {
		log.debug("** deleteLocation called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Location.byId");
		q.setParameter("id", id);
		Location location = (Location) q.getSingleResult();

		if (location != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(location);
				tx.commit();
				MessageServiceAdapter.sendNotification("location Deleted");
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