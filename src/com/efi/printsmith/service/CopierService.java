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

public class CopierService extends SnowmassHibernateService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(CopierService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;
	
	public CopierService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (RuntimeException e) {
			log.error(e);
		}	
	}
	
	public double calculateMachineCostPerCopy(CopierDefinition copierDefinition) {
		/*
		 * Copies per year = 
		 * 			# days Open Per Year *
		 * 			# hours Open Per Day *
		 * 			# copies per minute (* 60 to get hourly rate)
		 * 
		 * Copies per month = Copies per year / 12;
		 */
		double copiesPerMonth = (copierDefinition.getDaysOpen() * copierDefinition.getHoursOpen() * copierDefinition.getCopyMinutes() * 60) / 12;
				
		/*
		 * Cost Per Copy = 
		 * 			(Monthly Payment + monthly maintenance + monthly labor) /            ie - the actual cost of the copier
		 * 			Potential Copies per Month at 100% usage * actual usage
		 * 
		 * 			+ Labor per copy + toner per copy + developer per copy
		 */
		double costPerCopy = (copierDefinition.getMonthlyPayment() + copierDefinition.getMonthlyMaintenance() + copierDefinition.getMonthlyLabor()) / 
						(copiesPerMonth * copierDefinition.getPercentUsage());
		
		costPerCopy += copierDefinition.getTonerCopy() + copierDefinition.getDeveloperCopy() + copierDefinition.getLaborCopy();
		
		return costPerCopy;
	}
}