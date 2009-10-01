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

public class ProductCodeService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ProductCodeService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public ProductCodeService() {
		super();
	}

	public List<ProductCode> getProductCodes() {
		try {
			log.debug("** getProductCodes called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("ProductCode.findall");
			List<ProductCode> productCodes = findAllQuery.getResultList();
			if (productCodes != null) {
				log.debug("** Found " + productCodes.size() + "records:");
			}
			return productCodes;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<ProductCode>();
	}

	public void addUpdateProductCode(ProductCode productCode) throws Exception {
		log.debug("** addUpdateProductCode called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (productCode.getId() == null || productCode.getId() == 0) {
				productCode.setId(null);
				productCode.setCreated(new Timestamp(new Date().getTime()));
				productCode.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(productCode);
				tx.commit();
				MessageServiceAdapter.sendNotification("ProductCode Created");
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

	public void deleteProductCode(Long id) {
		log.debug("** deleteProductCode called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("ProductCode.byId");
		q.setParameter("id", id);
		ProductCode productCode = (ProductCode) q.getSingleResult();

		if (productCode != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(productCode);
				tx.commit();
				MessageServiceAdapter.sendNotification("productCode Deleted");
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