package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.efi.printsmith.messaging.MessageServiceAdapter;

public class UserService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger logger = Logger.getLogger(UserService.class);

	public UserService() {

		super();

	}

	public List<User> getUsers() {

		try {
			logger.debug("** getUsers called...");

			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);

			EntityManager em = entityManagerFactory.createEntityManager();

//			Query findAllQuery = em.createNamedQuery("users.findAll");

			Query findAllQuery = em.createQuery("from User");
			
			List<User> users = findAllQuery.getResultList();

			if (users != null)

				logger.debug("** Found " + users.size() + "records:");

			return users;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public void addUpdateUser(User user) throws Exception {

		logger.debug("** addUpdateUser called...");

		try {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

			em = emf.createEntityManager();
						
		// When passing Boolean and Number values from the Flash client to a

		// Java object, Java interprets null values as the default values for

		// primitive types; for example, 0 for double, float, long, int, short,

		// byte.

		if (user.getId() == null || user.getId() == 0) {
			// New user is created
			user.setId(null);
			user.setCreated(new Date());
			user.setModified(new Date());
		} else {
		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			user.setModified(new Date());
			em.merge(user);
			tx.commit();
			MessageServiceAdapter.sendNotification("User Created");
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
			throw new Exception(e.getMessage());

		} finally {

			logger.info("** Closing Entity Manager.");

			em.close();

		}
		}
		catch (Exception e) {
			logger.error("Exception caught");
		}

	}

	public void deleteUser(Long userId) {

		logger.debug("** deleteUser called...");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("users.byId");

		q.setParameter("id", userId);

		User user = (User) q.getSingleResult();

		if (user != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(user);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("User Deleted");
			} catch (Exception e) {

				logger.error("** Error: " + e.getMessage());

				tx.rollback();

			} finally {

				logger.info("** Closing Entity Manager.");

				em.close();

			}

		}

	}
}