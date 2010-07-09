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
import com.efi.printsmith.data.enums.CopierPricingMethod;

public class CopierService extends SnowmassHibernateService {
	protected static Logger log = Logger.getLogger(CopierService.class);
	
	public CopierService() {
		super();
	}
	
	private Matrix newCopierMatrix() {
		Matrix copierMatrix = new Matrix();
		copierMatrix.setHeader1(0L);
		copierMatrix.setHeader2(0L);
		copierMatrix.setHeader3(0L);
		copierMatrix.setHeader4(0L);
		copierMatrix.setHeader5(0L);
		copierMatrix.setHeader6(0L);
		copierMatrix.setHeader7(0L);
		copierMatrix.setHeader8(0L);
		copierMatrix.setHeader9(0L);
		copierMatrix.setHeader10(0L);

		for (int i=0; i<15; i++) {
			copierMatrix.addElements(newMatrixElement());
		}
		return copierMatrix;
	}
	
	private MatrixElement newMatrixElement() {
		MatrixElement element = new MatrixElement();
		
		element.setPrice1(0.0);
		element.setPrice2(0.0);
		element.setPrice3(0.0);
		element.setPrice4(0.0);
		element.setPrice5(0.0);
		element.setPrice6(0.0);
		element.setPrice7(0.0);
		element.setPrice8(0.0);
		element.setPrice9(0.0);
		element.setPrice10(0.0);
		element.setPrice11(0.0);
		element.setPrice12(0.0);
		element.setPrice13(0.0);
		element.setPrice14(0.0);
		element.setPrice15(0.0);
		element.setPrice16(0.0);
		element.setPrice17(0.0);
		element.setPrice18(0.0);
		element.setPrice19(0.0);
		element.setPrice20(0.0);
		return element;
		
	}
	public CopierDefinition newCopier() {
		CopierDefinition copierDefinition = new CopierDefinition();
		
		copierDefinition.setMethod(CopierPricingMethod.CostPlus.toString());
		copierDefinition.setLargeFormat(false);
		copierDefinition.setCopierMatrix(newCopierMatrix());
		return copierDefinition;
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
		double costPerCopy = (copierDefinition.getMonthlyPayment().doubleValue() + copierDefinition.getMonthlyMaintenance().doubleValue() + copierDefinition.getMonthlyLabor().doubleValue()) / 
						(copiesPerMonth * copierDefinition.getPercentUsage());
		
		costPerCopy += copierDefinition.getTonerCopy().doubleValue() + copierDefinition.getDeveloperCopy().doubleValue() + copierDefinition.getLaborCopy().doubleValue();
		
		return costPerCopy;
	}
}