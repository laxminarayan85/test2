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

public class ChargeService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ChargeService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public ChargeService() {
		super();
	}

	public List<Charge> getCharges() {
		try {
			log.debug("** getCharges called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("Charge.findall");
			List<Charge> charges = findAllQuery.getResultList();
			if (charges != null) {
				log.debug("** Found " + charges.size() + "records:");
			}
			return charges;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Charge>();
	}

	public void addUpdateCharge(Charge charge) throws Exception {
		log.debug("** addUpdateCharge called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (charge.getId() == null || charge.getId() == 0) {
				charge.setId(null);
				charge.setCreated(new Timestamp(new Date().getTime()));
				charge.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(charge);
				tx.commit();
				MessageServiceAdapter.sendNotification("Charge Created");
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

	public void deleteCharge(Long id) {
		log.debug("** deleteCharge called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Charge.byId");
		q.setParameter("id", id);
		Charge charge = (Charge) q.getSingleResult();

		if (charge != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(charge);
				tx.commit();
				MessageServiceAdapter.sendNotification("charge Deleted");
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