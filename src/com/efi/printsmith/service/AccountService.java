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

public class AccountService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(AccountService.class);

	public AccountService() {

		super();

	}

	public List<Account> getAccounts() {

		try {
			log.debug("** getAccounts called...");
	
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
	
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query findAllQuery = em.createQuery("from Account");
			//Query findAllQuery = em.createNamedQuery("Account.findall");
			
			List<Account> accounts = findAllQuery.getResultList();
	
			if (accounts != null)
	
				log.debug("** Found " + accounts.size() + "records:");
	
			return accounts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Account>();
	}

	public void addUpdateAccount(Account account) throws Exception {

		log.debug("** addUpdateAccount called...");

		try {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

			em = emf.createEntityManager();
						
		// When passing Boolean and Number values from the Flash client to a

		// Java object, Java interprets null values as the default values for

		// primitive types; for example, 0 for double, float, long, int, short,

		// byte.

		if (account.getId() == null || account.getId() == 0) {

			// New consultant is created

			account.setId(null);

			account.setCreated(new Timestamp(new Date().getTime()));
			account.setModified(new Timestamp(new Date().getTime()));
		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(account);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("Account Created");
			
		} catch (Exception e) {

			log.error("** Error: " + e.getMessage());

			tx.rollback();

			throw new Exception(e.getMessage());

		} finally {

			log.info("** Closing Entity Manager.");

			em.close();

		}
		}
		catch (Exception e) {
			log.error("Exception caught");
		}

	}

	public void deleteAccount(Long id) {

		log.debug("** deleteAccount called...");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("accounts.byId");

		q.setParameter("id", id);

		Account account = (Account) q.getSingleResult();

		if (account != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(account);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("Account Deleted");
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