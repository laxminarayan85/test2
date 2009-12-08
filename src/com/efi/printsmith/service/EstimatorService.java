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

public class EstimatorService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(EstimatorService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;
	
	public EstimatorService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (RuntimeException e) {
			log.error(e);
		}
	}
	
	public Invoice saveInvoice(Invoice invoice) {
		log.info("Start saveInvoice for invoice " + invoice.getId());
		
		log.info("Completed saveInvoice for invoice " + invoice.getId());
		return invoice;
	}
	
	public boolean validateInvoice(Invoice invoice) {
		boolean invoiceValid = true;
		log.info("Start validateInvoice for invoice " + invoice.getId());
		
		log.info("Start validateInvoice for invoice " + invoice.getId());
		return invoiceValid;
	}

}