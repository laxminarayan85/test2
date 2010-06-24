package com.efi.printsmith.service;

import java.math.BigDecimal;
import java.util.Date;
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
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.copier.CopiesPerOriginalPricingMethod;
import com.efi.printsmith.pricing.copier.CopiesPlusOriginalsPricingMethod;
import com.efi.printsmith.pricing.copier.CostPlusPricingMethod;
import com.efi.printsmith.pricing.copier.FlatRatePricingMethod;
import com.efi.printsmith.pricing.job.PriceJobEngine;

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
	
	public Job priceJob(Job job) {
		PriceJobEngine.priceJob(job);

		if (job.getCharges() != null) {
			for (int i=0; i < job.getCharges().size(); i++) {
				priceCharge(job.getCharges().get(i));
				
				job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getCharges().get(i).getPrice().doubleValue());
			}
		}
		
		this.calculateOvers(job);
		job.getPricingRecord().setTotalPrice(new Double(Math.round(job.getPricingRecord().getTotalPrice().doubleValue() * 100)) / 100);
		job.getPricingRecord().setUnitPrice(new Double(Math.round(job.getPricingRecord().getUnitPrice().doubleValue() * 10000)) / 10000);
		return job;
	}
	
	public Invoice priceInvoice(Invoice invoice) {
		log.info("Start priceInvoice for invoice " + invoice.getId());
		if (invoice.getCharges() != null) {
			for (Charge charge : invoice.getCharges()) {
				priceCharge(charge);
			}
		}
		if (invoice.getJobs() != null) {
			for (Job job : invoice.getJobs()) {
				priceJob(job);
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