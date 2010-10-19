package com.efi.printsmith.service;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.exceptions.PropertyException;

public class InvoiceService extends SnowmassHibernateService {
	protected static Logger log = Logger.getLogger(InvoiceService.class);

	public ModelBase saveInvoice(InvoiceBase invoice) throws Exception {
		if (invoice ==  null) {
			throw new InvalidParameterException("Null invoice passed to saveInvoice");
		}
		
		log.info("saveInvoice called. id: " + invoice.getId() + " invoiceNumber: " + invoice.getInvoiceNumber());

		List<JobBase> jobs = invoice.getJobs();
		List<Charge> charges = invoice.getCharges();
		
		/* First save the invoice itself */
		DataService dataService = new DataService();
		invoice = (InvoiceBase)dataService.addUpdate(invoice);
		
		if (jobs != null) {
			Iterator<JobBase> jobIter = jobs.iterator();
			
			while (jobIter.hasNext()) {
				JobBase job = jobIter.next();
				
				log.info("assigning parentInvoice to job. Invoice: " + invoice.getId() + " Job: " + job.getId());
				job.setParentInvoice(invoice);
				dataService.addUpdate(job);
			}
		}
		
		
		if (charges != null) {
			Iterator<Charge> chargeIter = charges.iterator();
			
			while (chargeIter.hasNext()) {
				Charge charge = chargeIter.next();

				log.info("assigning parentInvoice to charge. Invoice: " + invoice.getId() + " Charge: " + charge.getId());
				charge.setParentInvoice(invoice);
				dataService.addUpdate(charge);
			}
		}
		
		return invoice;		
	}

	public InvoiceBase getInvoice(long invoiceId) throws Exception {
		DataService dataService = new DataService();
		InvoiceBase invoice = (InvoiceBase)dataService.getById("InvoiceBase", invoiceId);
		
		Iterator<JobBase> jobIter = invoice.getJobs().iterator();
		while (jobIter.hasNext()) {
			JobBase job = jobIter.next();
			
			if (job == null) {
				log.error("Null job found in getInvoice");
			}
		}
		
		Iterator<Charge> chargeIter = invoice.getCharges().iterator();
		
		while(chargeIter.hasNext()) {
			Charge charge = chargeIter.next();

			if (charge == null) {
				log.error("Null charge found in getInvoice");
			}
		}
		return invoice;
		
	}
	
	
	public Invoice convertToInvoice(ModelBase estimate) throws Exception {
		Invoice invoice = new Invoice();
		for (Field estimateField : estimate.getClass().getSuperclass().getDeclaredFields()) {
			for (Field invoiceField : invoice.getClass().getSuperclass().getDeclaredFields()) {
				if(estimateField.getName().equals(invoiceField.getName()) && !estimateField.getName().equalsIgnoreCase("IsDeleted")) {
					String propertyName = estimateField.getName().substring(0, 1)
					.toUpperCase()
					+ estimateField.getName().substring(1,
							estimateField.getName().length());
					try {
						invoice.setProperty(propertyName, estimate.getProperty(propertyName));
					} catch(PropertyException e) {
						break;
					}
					break;
				}
			}
		}
		return invoice;
	}
}
