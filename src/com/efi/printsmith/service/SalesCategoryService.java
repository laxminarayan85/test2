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

public class SalesCategoryService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(SalesCategoryService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public SalesCategoryService() {
		super();
	}

	public List<SalesCategory> getSalesCategorys() {
		try {
			log.debug("** getSalesCategorys called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("SalesCategory.findall");
			List<SalesCategory> salesCategorys = findAllQuery.getResultList();
			if (salesCategorys != null) {
				log.debug("** Found " + salesCategorys.size() + "records:");
			}
			return salesCategorys;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<SalesCategory>();
	}

	public void addUpdateSalesCategory(SalesCategory salesCategory) throws Exception {
		log.debug("** addUpdateSalesCategory called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (salesCategory.getId() == null || salesCategory.getId() == 0) {
				salesCategory.setId(null);
				salesCategory.setCreated(new Timestamp(new Date().getTime()));
				salesCategory.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(salesCategory);
				tx.commit();
				MessageServiceAdapter.sendNotification("SalesCategory Created");
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

	public void deleteSalesCategory(Long id) {
		log.debug("** deleteSalesCategory called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("SalesCategory.byId");
		q.setParameter("id", id);
		SalesCategory salesCategory = (SalesCategory) q.getSingleResult();

		if (salesCategory != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(salesCategory);
				tx.commit();
				MessageServiceAdapter.sendNotification("salesCategory Deleted");
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