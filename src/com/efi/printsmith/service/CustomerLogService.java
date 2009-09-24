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

public class CustomerLogService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(CustomerLogService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public CustomerLogService() {
		super();
	}

	public List<CustomerLog> getCustomerLogs() {
		try {
			log.debug("** getCustomerLogs called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("CustomerLog.findall");
			List<CustomerLog> customerLogs = findAllQuery.getResultList();
			if (customerLogs != null) {
				log.debug("** Found " + customerLogs.size() + "records:");
			}
			return customerLogs;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<CustomerLog>();
	}

	public void addUpdateCustomerLog(CustomerLog customerLog) throws Exception {
		log.debug("** addUpdateCustomerLog called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (customerLog.getId() == null || customerLog.getId() == 0) {
				customerLog.setId(null);
				customerLog.setCreated(new Timestamp(new Date().getTime()));
				customerLog.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(customerLog);
				tx.commit();
				MessageServiceAdapter.sendNotification("CustomerLog Created");
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

	public void deleteCustomerLog(Long id) {
		log.debug("** deleteCustomerLog called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("CustomerLog.byId");
		q.setParameter("id", id);
		CustomerLog customerLog = (CustomerLog) q.getSingleResult();

		if (customerLog != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(customerLog);
				tx.commit();
				MessageServiceAdapter.sendNotification("customerLog Deleted");
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