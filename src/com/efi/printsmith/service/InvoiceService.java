package com.efi.printsmith.service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ModelBase;

public class InvoiceService extends SnowmassHibernateService {
	protected static Logger log = Logger.getLogger(InvoiceService.class);

	public ModelBase saveInvoice(InvoiceBase invoice) throws Exception {
		if (invoice ==  null) {
			throw new InvalidParameterException("Null invoice passed to saveInvoice");
		}
		
		log.info("saveInvoice called. id: " + invoice.getId() + " invoiceNumber: " + invoice.getInvoiceNumber());

		/* First save the invoice itself */
		DataService dataService = new DataService();
		invoice = (InvoiceBase)dataService.addUpdate(invoice);
		
		/* Assign parent invoice to any associated jobs and save them */
		List<JobBase> jobs = invoice.getJobs();
		if (jobs != null) {
			Iterator<JobBase> jobIter = jobs.iterator();
			
			while (jobIter.hasNext()) {
				JobBase job = jobIter.next();
				
				log.info("assigining parentInvoice to job. Invoice: " + invoice.getId() + " Job: " + job.getId());
				job.setParentInvoice(invoice);
				dataService.addUpdate(job);
			}
		}
		
		/* Assign parent invoice to any associated charges and save them */
		List<Charge> charges = invoice.getCharges();
		
		if (charges != null) {
			Iterator<Charge> chargeIter = charges.iterator();
			
			while (chargeIter.hasNext()) {
				Charge charge = chargeIter.next();

				log.info("assigining parentInvoice to charge. Invoice: " + invoice.getId() + " Charge: " + charge.getId());
				charge.setParentInvoice(invoice);
				dataService.addUpdate(charge);
			}
		}

		return invoice;		
	}

}
