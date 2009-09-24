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

public class ShippingMethodService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ShippingMethodService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public ShippingMethodService() {
		super();
	}

	public List<ShippingMethod> getShippingMethods() {
		try {
			log.debug("** getShippingMethods called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("ShippingMethod.findall");
			List<ShippingMethod> shippingMethods = findAllQuery.getResultList();
			if (shippingMethods != null) {
				log.debug("** Found " + shippingMethods.size() + "records:");
			}
			return shippingMethods;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<ShippingMethod>();
	}

	public void addUpdateShippingMethod(ShippingMethod shippingMethod) throws Exception {
		log.debug("** addUpdateShippingMethod called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (shippingMethod.getId() == null || shippingMethod.getId() == 0) {
				shippingMethod.setId(null);
				shippingMethod.setCreated(new Timestamp(new Date().getTime()));
				shippingMethod.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(shippingMethod);
				tx.commit();
				MessageServiceAdapter.sendNotification("ShippingMethod Created");
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

	public void deleteShippingMethod(Long id) {
		log.debug("** deleteShippingMethod called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("ShippingMethod.byId");
		q.setParameter("id", id);
		ShippingMethod shippingMethod = (ShippingMethod) q.getSingleResult();

		if (shippingMethod != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(shippingMethod);
				tx.commit();
				MessageServiceAdapter.sendNotification("shippingMethod Deleted");
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