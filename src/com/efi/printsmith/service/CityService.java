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

public class CityService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(CityService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public CityService() {
		super();
	}

	public List<City> getCitys() {
		try {
			log.debug("** getSalesReps called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("City.findall");
			List<City> citys = findAllQuery.getResultList();
			if (citys != null) {
				log.debug("** Found " + citys.size() + "records:");
			}
			return citys;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<City>();
	}

	public void addUpdateCity(City city) throws Exception {
		log.debug("** addUpdatecity called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (city.getId() == null || city.getId() == 0) {
				city.setId(null);
				city.setCreated(new Timestamp(new Date().getTime()));
				city.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(city);
				tx.commit();
				MessageServiceAdapter.sendNotification("City Created");
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

	public void deleteCity(Long id) {
		log.debug("** deleteCity called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("City.byId");
		q.setParameter("id", id);
		City city = (City) q.getSingleResult();

		if (city != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(city);
				tx.commit();
				MessageServiceAdapter.sendNotification("city Deleted");
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