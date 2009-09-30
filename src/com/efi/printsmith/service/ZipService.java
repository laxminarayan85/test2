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

public class ZipService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ZipService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public ZipService() {
		super();
	}

	public List<Zip> getZips() {
		try {
			log.debug("** getSalesReps called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("Zip.findall");
			List<Zip> zips = findAllQuery.getResultList();
			if (zips != null) {
				log.debug("** Found " + zips.size() + "records:");
			}
			return zips;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Zip>();
	}

	public void addUpdateZip(Zip zips) throws Exception {
		log.debug("** addUpdateZip called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (zips.getId() == null || zips.getId() == 0) {
				zips.setId(null);
				zips.setCreated(new Timestamp(new Date().getTime()));
				zips.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(zips);
				tx.commit();
				MessageServiceAdapter.sendNotification("Zip Created");
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

	public void deleteZip(Long id) {
		log.debug("** deleteSalesRep called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("SalesRep.byId");
		q.setParameter("id", id);
		Zip zips = (Zip) q.getSingleResult();

		if (zips != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(zips);
				tx.commit();
				MessageServiceAdapter.sendNotification("Zip Deleted");
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