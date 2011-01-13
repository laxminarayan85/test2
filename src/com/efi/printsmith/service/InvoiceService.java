package com.efi.printsmith.service;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Estimate;
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
		List<JobBase> jobBaseList = new ArrayList<JobBase>();
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
		if(invoice.getJobs()!=null && !invoice.getJobs().isEmpty()) {
			int defaultJobCount = 0;
			for(JobBase jobBaseObj : invoice.getJobs()) {
				if(jobBaseObj.getDefaultJob()) {
					defaultJobCount++;
				}
			}
			if(defaultJobCount==0) {
				for(JobBase jobBaseObj : invoice.getJobs()) {
					jobBaseObj.setDefaultJob(true);
				}
			}
		}
		if(invoice.getJobs()!=null && !invoice.getJobs().isEmpty()) {
			for(JobBase jobBaseObj : invoice.getJobs()) {
				if(jobBaseObj.getDefaultJob()){
					jobBaseObj.setId(0L);
					jobBaseObj.setCreated(null);
					jobBaseObj.setModified(null);
					jobBaseObj.setMultiQtyJob(false);
					jobBaseObj.setParentInvoice(invoice);
					jobBaseObj.setReleasedToProduction(false);
					if(jobBaseObj.getCostingRecord()!=null) {
						jobBaseObj.getCostingRecord().setId(0L);
						jobBaseObj.getCostingRecord().setModified(null);
						jobBaseObj.getCostingRecord().setCreated(null);
					}
					if(jobBaseObj.getCharges()!=null && !jobBaseObj.getCharges().isEmpty()) {
						for(Charge charge : jobBaseObj.getCharges()) {
							charge.setId(0L);
							charge.setModified(null);
							charge.setCreated(null);
							charge.setParentJob(jobBaseObj);
						}
					}
					jobBaseList.add(jobBaseObj);
				}
			}
			invoice.setJobs(jobBaseList);
		}
		invoice.setJobs(jobBaseList);
		if(invoice.getCharges()!=null && !invoice.getCharges().isEmpty()) {
			for(Charge chargeObj : invoice.getCharges()) {
				chargeObj.setId(0L);
				chargeObj.setCreated(null);
				chargeObj.setModified(null);
				chargeObj.setParentInvoice(invoice);
			}
		}
		invoice.setId(estimate.getId());
		return invoice;
	}
	
	
	public Invoice copyToNewInvoice(ModelBase invoiceBase) throws Exception {
		Invoice invoice = new Invoice();
		List<JobBase> jobBaseList = new ArrayList<JobBase>();
		for (Field estimateField : invoiceBase.getClass().getSuperclass().getDeclaredFields()) {
			for (Field invoiceField : invoice.getClass().getSuperclass().getDeclaredFields()) {
				if(estimateField.getName().equals(invoiceField.getName()) && !estimateField.getName().equalsIgnoreCase("IsDeleted")) {
					String propertyName = estimateField.getName().substring(0, 1)
					.toUpperCase()
					+ estimateField.getName().substring(1,
							estimateField.getName().length());
					try {
						invoice.setProperty(propertyName, invoiceBase.getProperty(propertyName));
					} catch(PropertyException e) {
						break;
					}
					break;
				}
			}
		}
		if(invoiceBase instanceof Estimate) {
			int totalJobSize = 0;
			int defaultJobCount = 0;
			if(invoice.getJobs()!=null) {
				totalJobSize = invoice.getJobs().size();
			}
			for(JobBase jobBaseObj : invoice.getJobs()) {
				if(jobBaseObj.getDefaultJob()) {
					defaultJobCount++;
				}
			}
			if(totalJobSize!=0 && defaultJobCount==0) {
				for(JobBase jobBaseObj : invoice.getJobs()) {
					jobBaseObj.setDefaultJob(true);
				}
			}
			for(JobBase jobBaseObj : invoice.getJobs()) {
				if(jobBaseObj.getDefaultJob()){
					jobBaseObj.setId(0L);
					jobBaseObj.setCreated(null);
					jobBaseObj.setModified(null);
					jobBaseObj.setMultiQtyJob(false);
					jobBaseObj.setParentInvoice(invoice);
					jobBaseObj.setReleasedToProduction(false);
					if(jobBaseObj.getCostingRecord()!=null) {
						jobBaseObj.getCostingRecord().setId(0L);
						jobBaseObj.getCostingRecord().setModified(null);
						jobBaseObj.getCostingRecord().setCreated(null);
					}
					if(jobBaseObj.getCharges()!=null && !jobBaseObj.getCharges().isEmpty()) {
						for(Charge charge : jobBaseObj.getCharges()) {
							charge.setId(0L);
							charge.setModified(null);
							charge.setCreated(null);
							charge.setParentJob(jobBaseObj);
						}
					}
					jobBaseList.add(jobBaseObj);
				}
			}
			invoice.setJobs(jobBaseList);
		} else if(invoiceBase instanceof Invoice) {
			for(JobBase jobBaseObj : invoice.getJobs()) {
				jobBaseObj.setId(0L);
				jobBaseObj.setCreated(null);
				jobBaseObj.setModified(null);
				jobBaseObj.setMultiQtyJob(false);
				jobBaseObj.setParentInvoice(invoice);
				jobBaseObj.setReleasedToProduction(false);
				if(jobBaseObj.getCostingRecord()!=null) {
					jobBaseObj.getCostingRecord().setId(0L);
					jobBaseObj.getCostingRecord().setModified(null);
					jobBaseObj.getCostingRecord().setCreated(null);
				}
				if(jobBaseObj.getCharges()!=null && !jobBaseObj.getCharges().isEmpty()) {
					for(Charge charge : jobBaseObj.getCharges()) {
						charge.setId(0L);
						charge.setModified(null);
						charge.setCreated(null);
						charge.setParentJob(jobBaseObj);
					}
				}
			}
		}
		if(invoice.getCharges()!=null && !invoice.getCharges().isEmpty()) {
			for(Charge chargeObj : invoice.getCharges()) {
				chargeObj.setId(0L);
				chargeObj.setCreated(null);
				chargeObj.setModified(null);
				chargeObj.setParentInvoice(invoice);
			}
		}
		invoice.setConvertedInvoiceNo(null);
		invoice.setOffPendingDate(null);
		invoice.setOnPendingList(true);
		return invoice;
	}
	
	public Estimate copyToNewEstimate(ModelBase invoiceBase) throws Exception {
		Estimate estimate = new Estimate();
		for (Field estimateField : invoiceBase.getClass().getSuperclass().getDeclaredFields()) {
			for (Field invoiceField : estimate.getClass().getSuperclass().getDeclaredFields()) {
				if(estimateField.getName().equals(invoiceField.getName()) && !estimateField.getName().equalsIgnoreCase("IsDeleted")) {
					String propertyName = estimateField.getName().substring(0, 1)
					.toUpperCase()
					+ estimateField.getName().substring(1,
							estimateField.getName().length());
					try {
						estimate.setProperty(propertyName, invoiceBase.getProperty(propertyName));
					} catch(PropertyException e) {
						break;
					}
					break;
				}
			}
		}
		int totalJobSize = 0;
		int defaultJobCount = 0;
		if(estimate.getJobs()!=null) {
			totalJobSize = estimate.getJobs().size();
		}
		for(JobBase jobBaseObj : estimate.getJobs()) {
			if(jobBaseObj.getDefaultJob()) {
				defaultJobCount++;
			}
		}
		if(totalJobSize!=0 && defaultJobCount==0) {
			for(JobBase jobBaseObj : estimate.getJobs()) {
				jobBaseObj.setDefaultJob(true);
			}
		}
		for(JobBase jobBaseObj : estimate.getJobs()) {
			jobBaseObj.setId(0L);
			jobBaseObj.setCreated(null);
			jobBaseObj.setModified(null);
			if(invoiceBase instanceof Invoice) {
				jobBaseObj.setDefaultJob(true);
			}	
			if(invoiceBase instanceof Invoice) {
				jobBaseObj.setMultiQtyJob(false);
			}
			jobBaseObj.setParentInvoice(estimate);
			jobBaseObj.setReleasedToProduction(false);
			if(jobBaseObj.getCostingRecord()!=null) {
				jobBaseObj.getCostingRecord().setId(0L);
				jobBaseObj.getCostingRecord().setModified(null);
				jobBaseObj.getCostingRecord().setCreated(null);
			}
			if(jobBaseObj.getCharges()!=null && !jobBaseObj.getCharges().isEmpty()) {
				for(Charge charge : jobBaseObj.getCharges()) {
					charge.setId(0L);
					charge.setModified(null);
					charge.setCreated(null);
					charge.setParentJob(jobBaseObj);
				}
			}
		}
		if(estimate.getCharges()!=null && !estimate.getCharges().isEmpty()) {
			for(Charge chargeObj : estimate.getCharges()) {
				chargeObj.setId(0L);
				chargeObj.setCreated(null);
				chargeObj.setModified(null);
				chargeObj.setParentInvoice(estimate);
			}
		}
		estimate.setConvertedInvoiceNo(null);
		estimate.setOffPendingDate(null);
		estimate.setOnPendingList(true);
		return estimate;
	}
}
