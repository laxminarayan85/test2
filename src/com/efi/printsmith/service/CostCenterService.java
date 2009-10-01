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

public class CostCenterService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(CostCenterService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public CostCenterService() {
		super();
	}

	public List<CostCenter> getCostCenters() {
		try {
			log.debug("** getCostCenters called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("CostCenter.findall");
			List<CostCenter> costCenters = findAllQuery.getResultList();
			if (costCenters != null) {
				log.debug("** Found " + costCenters.size() + "records:");
			}
			return costCenters;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<CostCenter>();
	}

	public void addUpdateCostCenter(CostCenter costCenter) throws Exception {
		log.debug("** addUpdateCostCenter called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (costCenter.getId() == null || costCenter.getId() == 0) {
				costCenter.setId(null);
				costCenter.setCreated(new Timestamp(new Date().getTime()));
				costCenter.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(costCenter);
				tx.commit();
				MessageServiceAdapter.sendNotification("CostCenter Created");
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

	public void deleteCostCenter(Long id) {
		log.debug("** deleteCostCenter called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("CostCenter.byId");
		q.setParameter("id", id);
		CostCenter costCenter = (CostCenter) q.getSingleResult();

		if (costCenter != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(costCenter);
				tx.commit();
				MessageServiceAdapter.sendNotification("costCenter Deleted");
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