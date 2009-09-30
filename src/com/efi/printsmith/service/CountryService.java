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

public class CountryService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(Country.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public CountryService() {
		super();
	}

	public List<Country> getCountrys() {
		try {
			log.debug("** getSalesReps called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("Country.findall");
			List<Country> countrys = findAllQuery.getResultList();
			if (countrys != null) {
				log.debug("** Found " + countrys.size() + "records:");
			}
			return countrys;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Country>();
	}

	public void addUpdateCountry(Country countrys) throws Exception {
		log.debug("** addCountry called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (countrys.getId() == null || countrys.getId() == 0) {
				countrys.setId(null);
				countrys.setCreated(new Timestamp(new Date().getTime()));
				countrys.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(countrys);
				tx.commit();
				MessageServiceAdapter.sendNotification("Country Created");
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

	public void deleteCountry(Long id) {
		log.debug("** deleteCountry called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Country.byId");
		q.setParameter("id", id);
		Country countrys = (Country) q.getSingleResult();

		if (countrys != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(countrys);
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