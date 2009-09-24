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

public class SalesRepService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(SalesRepService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public SalesRepService() {
		super();
	}

	public List<SalesRep> getSalesReps() {
		try {
			log.debug("** getSalesReps called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("SalesRep.findall");
			List<SalesRep> salesReps = findAllQuery.getResultList();
			if (salesReps != null) {
				log.debug("** Found " + salesReps.size() + "records:");
			}
			return salesReps;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<SalesRep>();
	}

	public void addUpdateSalesRep(SalesRep salesRep) throws Exception {
		log.debug("** addUpdateSalesRep called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (salesRep.getId() == null || salesRep.getId() == 0) {
				salesRep.setId(null);
				salesRep.setCreated(new Timestamp(new Date().getTime()));
				salesRep.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(salesRep);
				tx.commit();
				MessageServiceAdapter.sendNotification("SalesRep Created");
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

	public void deleteSalesRep(Long id) {
		log.debug("** deleteSalesRep called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("SalesRep.byId");
		q.setParameter("id", id);
		SalesRep salesRep = (SalesRep) q.getSingleResult();

		if (salesRep != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(salesRep);
				tx.commit();
				MessageServiceAdapter.sendNotification("salesRep Deleted");
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