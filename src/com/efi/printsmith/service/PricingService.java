package com.efi.printsmith.service;

import com.efi.printsmith.data.*;
import org.apache.log4j.Logger;
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.job.PriceJobEngine;
import com.efi.printsmith.pricing.utilities.JobUtilities;
import com.efi.printsmith.pricing.utilities.StockUtilities;

public class PricingService extends SnowmassHibernateService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(PricingService.class);
	
//	protected static EntityManagerFactory entityManagerFactory = null;
	
	public PricingService() {
		super();
//		try {
//			if (entityManagerFactory == null) {
//				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
//			}
//		} catch (RuntimeException e) {
//			log.error(e);
//		}	
	}
	
	public Charge priceCharge(Charge charge) {
		log.info("Start priceCharge for charge " + charge.getId());
		PriceChargeEngine.priceCharge(charge);
		log.info("Completed priceCharge for charge " + charge.getId());
		return charge;
	}
	
	public Job priceJob(Job job) throws Exception {
		if (job == null) {
			return null;
		}else{
		 PriceJobEngine.priceJob(job);
		}	
		PricingRecord pricingRecord = job.getPricingRecord();
		JobUtilities.calculateBinderyWaste(job);

		if (job.getCharges() != null) {
			for (int i=0; i < job.getCharges().size(); i++) {
				Charge charge = job.getCharges().get(i);
				priceCharge(charge);
				
				ChargeCategory category = charge.getChargeDefinition().getParent();
				if (category != null) {
					ChargeCommand command = category.getParent();
					if (command != null) {
						if (command.getName().equals("Pre Press")) {
							job.getPricingRecord().setPrepPrice(pricingRecord.getPrepPrice().add(charge.getPrice()));
						} else if (command.getName().equals("Bindery")) {
							job.getPricingRecord().setBindPrice(pricingRecord.getBindPrice().add(charge.getPrice()));
						} else {
							job.getPricingRecord().setOtherChargePrice(pricingRecord.getOtherChargePrice().add(charge.getPrice()));
						}
					}
					
				}
				//job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getCharges().get(i).getPrice().doubleValue());
			}
		}
		
		this.calculateOvers(job);
		job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getPricingRecord().getProductionPrice().doubleValue());
		job.getPricingRecord().setTotalPrice(new Double(Math.round(job.getPricingRecord().getTotalPrice().doubleValue() * 100)) / 100);
		job.getPricingRecord().setUnitPrice(new Double(Math.round(job.getPricingRecord().getUnitPrice().doubleValue() * 10000)) / 10000);
		JobUtilities.calculateSignatures(job);
		StockUtilities.calculateJobWeight(job);
		return job;
	}
	
	public Invoice priceInvoice(Invoice invoice) throws Exception {
		log.info("Start priceInvoice for invoice " + invoice.getId());
		if (invoice.getCharges() != null) {
			for (Charge charge : invoice.getCharges()) {
				priceCharge(charge);
			}
		}
		if (invoice.getJobs() != null) {
			for (JobBase job : invoice.getJobs()) {
				priceJob((Job)job);
			}
			
			invoice.setPriceTotal(0.0);
			for (int i=0; i < invoice.getJobs().size(); i++) {
				invoice.setPriceTotal(invoice.getPriceTotal().doubleValue()+invoice.getJobs().get(i).getPricingRecord().getTotalPrice().doubleValue());
			}
		}
		invoice.setPriceTotal(new Double(Math.round(invoice.getPriceTotal().doubleValue() * 100)) / 100);
		log.info("Completed priceInvoice for invoice " + invoice.getId());
		return invoice;
	}
	
	public void calculateOvers(Job job) {
		double oversUnitPrice = 0.0;
		double oversPrice = 0.0;
		
		if (job.getQtyOrdered() > 0 && job.getOversUnders() > 0) {
			oversUnitPrice = job.getPricingRecord().getTotalPrice().doubleValue() / job.getQtyOrdered();
			oversPrice = oversUnitPrice * job.getOversUnders();
		}
		job.getPricingRecord().setOversUnitPrice(new Double(Math.round(oversUnitPrice * 10000)) / 10000);
		job.getPricingRecord().setOversTotalPrice(new Double(Math.round(oversPrice * 100)) / 100);
		job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getPricingRecord().getOversTotalPrice().doubleValue());
	}
}