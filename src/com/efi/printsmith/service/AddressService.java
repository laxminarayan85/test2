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

public class AddressService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(AddressService.class);
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	public AddressService() {

		super();

	}

	public List<Address> getAddresss() {

		try {
			log.debug("** getAddresss called...");
		
			EntityManager em = entityManagerFactory.createEntityManager();
	
			Query findAllQuery = em.createQuery("from Address");
			//Query findAllQuery = em.createNamedQuery("Address.findall");
			
			List<Address> addresss = findAllQuery.getResultList();
	
			if (addresss != null)
	
				log.debug("** Found " + addresss.size() + "records:");
	
			return addresss;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Address>();
	}
	
	public Address addUpdateAddress(Address address) throws Exception {

		log.debug("** addUpdateAddress called...");

		try {
			EntityManager em;

			em = entityManagerFactory.createEntityManager();
						
		if (address.getId() == null || address.getId() == 0) {

			// New consultant is created

			address.setId(null);

			address.setCreated(new Timestamp(new Date().getTime()));
			address.setModified(new Timestamp(new Date().getTime()));
		} else {

			// Existing consultant is updated - do nothing.

		}

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			em.merge(address);

			tx.commit();
			
			MessageServiceAdapter.sendNotification("Address Created");
			
			return address;
			
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
		return null;
	}

	public void deleteAddress(Long id) {

		log.debug("** deleteAddress called...");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNamedQuery("addresss.byId");

		q.setParameter("id", id);

		Address address = (Address) q.getSingleResult();

		if (address != null) {

			EntityTransaction tx = em.getTransaction();

			tx.begin();
			

			try {

				em.remove(address);

				tx.commit();
				
				MessageServiceAdapter.sendNotification("Address Deleted");
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