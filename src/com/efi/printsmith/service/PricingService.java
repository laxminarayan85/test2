package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.efi.printsmith.messaging.MessageServiceAdapter;

public class PricingService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(DataService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;
	
	public PricingService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (RuntimeException e) {
			log.error(e);
		}
	}
	
	public Charge priceCharge(Charge charge) {
		log.info("Start priceCharge for charge " + charge.getId());
		
		log.info("Completed priceCharge for charge " + charge.getId());
		return charge;
	}

	public Job priceJob(Job job) {
		log.info("Start priceJob for job " + job.getId());
		
		log.info("Completed priceJob for job " + job.getId());
		return job;
	}
	
	public Invoice priceInvoice(Invoice invoice) {
		log.info("Start priceInvoice for invoice " + invoice.getId());
		
		log.info("Completed priceInvoice for invoice " + invoice.getId());
		return invoice;
	}
}