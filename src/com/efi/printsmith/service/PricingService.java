package com.efi.printsmith.service;

import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.CopierPricingMethod;

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
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.copier.CopiesPerOriginalPricingMethod;
import com.efi.printsmith.pricing.copier.CopiesPlusOriginalsPricingMethod;
import com.efi.printsmith.pricing.copier.CostPlusPricingMethod;
import com.efi.printsmith.pricing.copier.FlatRatePricingMethod;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class PricingService {

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
	
	public Job priceJob(Job job) {
		PriceJobEngine.priceJob(job);

		for (int i=0; i < job.getCharges().size(); i++) {
			priceCharge(job.getCharges().get(i));
			
			job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice() + job.getCharges().get(i).getPrice());
		}

		return job;
	}
	
	public Invoice priceInvoice(Invoice invoice) {
		log.info("Start priceInvoice for invoice " + invoice.getId());
		for (Charge charge : invoice.getCharges()) {
			priceCharge(charge);
		}
		for (Job job : invoice.getJobs()) {
			priceJob(job);
		}
		
		invoice.setPriceTotal(0.0);
		for (int i=0; i < invoice.getJobs().size(); i++) {
			invoice.setPriceTotal(invoice.getPriceTotal()+invoice.getJobs().get(i).getPricingRecord().getTotalPrice());
		}
		
		log.info("Completed priceInvoice for invoice " + invoice.getId());
		return invoice;
	}
}