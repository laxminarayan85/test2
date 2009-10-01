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

public class ChargeCommandService {

	private static final String PERSISTENCE_UNIT = "printsmith_db";

	private static Logger log = Logger.getLogger(ChargeCommandService.class);

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public ChargeCommandService() {
		super();
	}

	public List<ChargeCommand> getChargeCommands() {
		try {
			log.debug("** getChargeCommands called...");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createNamedQuery("ChargeCommand.findall");
			List<ChargeCommand> chargeCommands = findAllQuery.getResultList();
			if (chargeCommands != null) {
				log.debug("** Found " + chargeCommands.size() + "records:");
			}
			return chargeCommands;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<ChargeCommand>();
	}

	public void addUpdateChargeCommand(ChargeCommand chargeCommand) throws Exception {
		log.debug("** addUpdateChargeCommand called...");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			for (ChargeCategory category:chargeCommand.getChildren()) {
				for(Charge charge:category.getChildren()) {
					if (charge.getId() == null || charge.getId() == 0) {
						charge.setId(null);
						charge.setCreated(new Timestamp(new Date().getTime()));
						charge.setModified(new Timestamp(new Date().getTime()));
					}
					EntityTransaction tx = em.getTransaction();
					tx.begin();
					try {
						em.merge(charge);
						tx.commit();
						MessageServiceAdapter.sendNotification("ChargeCommand Created");
					} catch (Exception e) {
						log.error("** Error: " + e.getMessage());
						tx.rollback();
						throw new Exception(e.getMessage());
					}
				}
				if (category.getId() == null || category.getId() == 0) {
					category.setId(null);
					category.setCreated(new Timestamp(new Date().getTime()));
					category.setModified(new Timestamp(new Date().getTime()));
				}
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					em.merge(category);
					tx.commit();
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());
				}
			}

			if (chargeCommand.getId() == null || chargeCommand.getId() == 0) {
				chargeCommand.setId(null);
				chargeCommand.setCreated(new Timestamp(new Date().getTime()));
				chargeCommand.setModified(new Timestamp(new Date().getTime()));
			} else {

			}
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.merge(chargeCommand);
				tx.commit();
				MessageServiceAdapter.sendNotification("ChargeCommand Created");
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

	
	public void deleteChargeCommand(Long id) {
		log.debug("** deleteChargeCommand called...");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("ChargeCommand.byId");
		q.setParameter("id", id);
		ChargeCommand chargeCommand = (ChargeCommand) q.getSingleResult();

		if (chargeCommand != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				em.remove(chargeCommand);
				tx.commit();
				MessageServiceAdapter.sendNotification("chargeCommand Deleted");
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
			} finally {
				log.info("** Closing Entity Manager.");
				em.close();
			}
		}
	}
	
	public void populateSampleData() {
		Charge charge = new Charge();
		charge.setTitle("Charge One");
		Charge charge2 = new Charge();
		charge2.setTitle("Charge Two");
		
		ChargeCategory category = new ChargeCategory();
		category.setName("Category One");
		ChargeCategory category2 = new ChargeCategory();
		category2.setName("Category Two");
		
		ChargeCommand command = new ChargeCommand();
		command.setName("Command One");
		ChargeCommand command2 = new ChargeCommand();
		command2.setName("Command Two");
		
		List<Charge> chargeList = new ArrayList<Charge>();
		charge.setParent(category);
		chargeList.add(charge);
		category.setChildren(chargeList);
		
		List<Charge> chargeList2 = new ArrayList<Charge>();
		charge2.setParent(category2);
		chargeList2.add(charge2);
		category2.setChildren(chargeList2);
		
		List<ChargeCategory> categoryList = new ArrayList<ChargeCategory>();
		category.setParent(command);
		categoryList.add(category);
		command.setChildren(categoryList);
		
		List<ChargeCategory> categoryList2 = new ArrayList<ChargeCategory>();
		category2.setParent(command2);
		categoryList2.add(category);
		command2.setChildren(categoryList2);
		
		try {
			this.addUpdateChargeCommand(command);
			this.addUpdateChargeCommand(command2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}