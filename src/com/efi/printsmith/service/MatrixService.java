package com.efi.printsmith.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.CopierPricingMethod;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.PriceScheduleMethod;

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
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;

import flex.messaging.io.ArrayList;

public class MatrixService extends SnowmassHibernateService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(MatrixService.class);
	
//	protected static EntityManagerFactory entityManagerFactory = null;
	
	public MatrixService() {
		super();
	}
	
	public PaperPrice newPaperPrice(int type) {
		PaperPrice paperPrice = new PaperPrice();
		
		paperPrice.setHeader1(1L);
		paperPrice.setHeader2(2L);
		paperPrice.setHeader3(3L);
		paperPrice.setHeader4(4L);
		paperPrice.setHeader5(5L);
		paperPrice.setHeader6(0L);
		paperPrice.setHeader7(0L);
		paperPrice.setHeader8(0L);
		paperPrice.setHeader9(0L);
		paperPrice.setHeader10(0L);
		paperPrice.setType(type);
		paperPrice.setMethod(PriceScheduleMethod.UseOrderedQuantity.name());
		if (type == 1)
			paperPrice.setName("New Copy Schedule");
		else
			paperPrice.setName("New Pass Schedule");
		
		for (int i=0; i<15; i++) {
			paperPrice.addElements(newMatrixElement(i==14));
		}
		
		return paperPrice;
	}
	
	public StampSchedule newStampSchedule() {
		StampSchedule stampSchedule = new StampSchedule();
		
		stampSchedule.setHeader1(0L);
		stampSchedule.setHeader2(0L);
		stampSchedule.setHeader3(0L);
		stampSchedule.setHeader4(0L);
		stampSchedule.setHeader5(0L);
		stampSchedule.setHeader6(0L);
		stampSchedule.setHeader7(0L);
		stampSchedule.setHeader8(0L);
		stampSchedule.setHeader9(0L);
		stampSchedule.setHeader10(0L);
		
		for (int i=0; i<20; i++) {
			stampSchedule.addElements(newMatrixElement(i==19));
		}
		
		return stampSchedule;
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
}