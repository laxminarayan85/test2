package com.efi.printsmith.service;

import java.util.Iterator;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.CopierPricingMethod;
import com.efi.printsmith.data.enums.Price2Side;

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
			copierMatrix.addElements(newMatrixElement(i==14));
		}
		return copierMatrix;
	}
	
	private MatrixElement newMatrixElement(boolean lastLine) {
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
		element.setLastLine(lastLine);
		return element;
		
	}
	public CopierDefinition newCopier() {
		CopierDefinition copierDefinition = new CopierDefinition();
		
		copierDefinition.setMethod(CopierPricingMethod.CostPlus.toString());
		copierDefinition.setPriceTwoSide(Price2Side.UsingFirstSideRate.toString());
		copierDefinition.setLargeFormat(false);
		copierDefinition.setCopierMatrix(newCopierMatrix());
		copierDefinition.setMatrixType("CopyCost");
		return copierDefinition;
	}
	
	public CopierDefinition duplicateCopier(CopierDefinition copier) throws Exception {
		CopierDefinition newCopier = copier;
		
		newCopier.setId(0L);
		newCopier.setCreated(null);
		newCopier.setModified(null);
		newCopier.setPrevId("");
		newCopier.setCopierId(null);
		
		Matrix matrix = new Matrix();

		matrix.setHeader1(copier.getCopierMatrix().getHeader1());
		matrix.setHeader2(copier.getCopierMatrix().getHeader2());
		matrix.setHeader3(copier.getCopierMatrix().getHeader3());
		matrix.setHeader4(copier.getCopierMatrix().getHeader4());
		matrix.setHeader5(copier.getCopierMatrix().getHeader5());
		matrix.setHeader6(copier.getCopierMatrix().getHeader6());
		matrix.setHeader7(copier.getCopierMatrix().getHeader7());
		matrix.setHeader8(copier.getCopierMatrix().getHeader8());
		matrix.setHeader9(copier.getCopierMatrix().getHeader9());
		matrix.setHeader10(copier.getCopierMatrix().getHeader10());
		
		Iterator<MatrixElement> iter = copier.getCopierMatrix().getElements().iterator();
		while (iter.hasNext()) {
			MatrixElement newElement = new MatrixElement();
			MatrixElement element = iter.next();
			newElement.setPrice1(element.getPrice1());
			newElement.setPrice2(element.getPrice2());
			newElement.setPrice3(element.getPrice3());
			newElement.setPrice4(element.getPrice4());
			newElement.setPrice5(element.getPrice5());
			newElement.setPrice6(element.getPrice6());
			newElement.setPrice7(element.getPrice7());
			newElement.setPrice8(element.getPrice8());
			newElement.setPrice9(element.getPrice9());
			newElement.setPrice10(element.getPrice10());
			newElement.setPrice11(element.getPrice11());
			newElement.setPrice12(element.getPrice12());
			newElement.setPrice13(element.getPrice13());
			newElement.setPrice14(element.getPrice14());
			newElement.setPrice15(element.getPrice15());
			newElement.setPrice16(element.getPrice16());
			newElement.setPrice17(element.getPrice17());
			newElement.setPrice18(element.getPrice18());
			newElement.setPrice19(element.getPrice19());
			newElement.setPrice20(element.getPrice20());
			newElement.setQty(element.getQty());
			newElement.setLastLine(element.getLastLine());
			matrix.addElements(newElement);
		}
		newCopier.setCopierMatrix(matrix);
		
		
//		DataService dataService = new DataService();
//		newCopier = (CopierDefinition)dataService.addUpdate(newCopier);
		return newCopier;
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