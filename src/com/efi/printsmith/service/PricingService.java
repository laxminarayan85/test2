package com.efi.printsmith.service;

import java.util.List;

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

	private double interpolatePriceFromPriceList(PriceList priceList, long qty) {
		double retVal = 0.0;
		if (priceList != null) {
			List <PriceListElement> priceListElements = priceList.getElements();
			PriceListElement elementToUse = null;
			if(priceListElements != null && priceListElements.size() > 0) {
				elementToUse = priceListElements.get(0);
				for (int i=1; i < priceListElements.size(); i++) {
					PriceListElement curElement = priceListElements.get(i);
					if (curElement.getQuantity() > qty) {
						elementToUse = priceListElements.get(i-1);
						break;
					}
				}
				if (elementToUse.getQuantity() > 0) {
					retVal = elementToUse.getAmount()/elementToUse.getQuantity()*qty;
				}
			}
		}
		return retVal;
		
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
	
	private double getStockPrice(StockDefinition stockDefinition, long qty) {
		double retVal = 0.0;
		if (stockDefinition != null) {
			if (stockDefinition.getCostunits() > 0) {
				if (qty <= stockDefinition.getQtybreak1()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;
				} else if (qty <= stockDefinition.getQtybreak2()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;
				} else if (qty <= stockDefinition.getQtybreak3()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;
				} else if (qty <= stockDefinition.getQtybreak4()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;
				} else if (qty <= stockDefinition.getQtybreak5()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;
				} else if (qty <= stockDefinition.getQtybreak6()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty;				
				}
			}
		}
		return retVal;
	}
	
	public Job priceJob(Job job) {		
		log.info("Start priceJob for job " + job.getId());
		double price = 0.0;

		/* Press Price */
		PressDefinition pricingPress = job.getPricingPress();
		double time = getTimePerSheetFromSpeedTable(pricingPress.getSpeedTable(), job.getPressQty()) * job.getPressQty()/60;
		time += pricingPress.getSetupMin();
		if (time < pricingPress.getMinLabor()) {
			time = pricingPress.getMinLabor();
		}
		price = pricingPress.getLaborRate() * pricingPress.getLaborMarkup() * time/60;
		
		/* Stock Price */
		StockDefinition stock = job.getStock();
		if (stock != null) {
			price += getStockPrice(stock, job.getPressQty());
		}
		
		if (job.getCharges() != null) {
			for (Charge charge : job.getCharges()) {
				priceCharge(charge);
			}
		}

		job.setPrice(price);
		log.info("Completed priceJob for job " + job.getId());
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