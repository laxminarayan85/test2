package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import flex.messaging.FlexContext;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.service.DataService;


public class EstimatorService extends HibernateService {

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
	
	public Invoice createInvoiceFromEstimate(ModelBase estimate, Job job) throws Exception {
		DataService dataService = new DataService();
		Invoice invoice = (Invoice)estimate;
		invoice.addJobs(job);
		dataService.addUpdate(invoice);
		return invoice;
	}
	public Object load(Class clazz, long id)
	{
       Session session = null;
       Object result;

       try
       {
           session = DataService.getSession();
           long tStart = new Date().getTime();
           result = session.get(clazz, id);
           long tEnd = new Date().getTime();
     //      log.debug("{load()}" +(tEnd-tStart) +"ms  class=" +clazz.getName() );
           
       }
       catch (HibernateException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       }
       catch (RuntimeException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       } finally {
    	   session.close();
       }

       return result;
	}
}