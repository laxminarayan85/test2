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

public class StateService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(StateService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public StateService() {
		super();
	}

	public List<State> getStates() {
		try {
			log.debug("** getSalesReps called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("State.findall");
			List<State> states = findAllQuery.getResultList();
			if (states != null) {
				log.debug("** Found " + states.size() + "records:");
			}
			return states;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<State>();
	}

	public void addUpdateState(State states) throws Exception {
		log.debug("** addUpdateState called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (states.getId() == null || states.getId() == 0) {
				states.setId(null);
				states.setCreated(new Timestamp(new Date().getTime()));
				states.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(states);
				tx.commit();
				MessageServiceAdapter.sendNotification("states Created");
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

	public void deleteState(Long id) {
		log.debug("** deleteState called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("State.byId");
		q.setParameter("id", id);
		State states = (State) q.getSingleResult();

		if (states != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(states);
				tx.commit();
				MessageServiceAdapter.sendNotification("State Deleted");
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