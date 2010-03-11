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
import com.efi.printsmith.pricing.copier.CopiesPerOriginalPricingMethod;
import com.efi.printsmith.pricing.copier.CopiesPlusOriginalsPricingMethod;
import com.efi.printsmith.pricing.copier.CostPlusPricingMethod;
import com.efi.printsmith.pricing.copier.FlatRatePricingMethod;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class PricingService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(PricingService.class);
	
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
	 
	private double getTimePerSheetFromSpeedTable(SpeedTable speedTable, long qty) {
		double retVal = 0.0;
		
		if (speedTable != null) {
			List <PriceListElement> speedTableElements = speedTable.getElements();
			PriceListElement elementToUse = null;
			if(speedTableElements != null && speedTableElements.size() > 0) {
				elementToUse = speedTableElements.get(0);
				for (int i=1; i < speedTableElements.size(); i++) {
					PriceListElement curElement = speedTableElements.get(i);
					if (curElement.getQuantity() > qty) {
						elementToUse = speedTableElements.get(i-1);
						break;
					}
				}
				if (elementToUse.getQuantity() > 0) {
					retVal = 3600/elementToUse.getAmount();
				}
			}
		}
		return retVal;
	}
	
	public Job priceJob(Job job) {
		PriceJobEngine.priceJob(job);
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
		log.info("Completed priceInvoice for invoice " + invoice.getId());
		return invoice;
	}
}