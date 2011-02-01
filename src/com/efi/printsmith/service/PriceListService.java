package com.efi.printsmith.service;

import java.math.BigDecimal;
import java.util.Date;
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

public class PriceListService extends SnowmassHibernateService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(PriceListService.class);
	
//	protected static EntityManagerFactory entityManagerFactory = null;
	
	public PriceListService() {
		super();
	}
	@SuppressWarnings("unchecked")
	public List getCopierPriceList(CopierDefinition copierDefinition) throws Exception {
		DataService dataService = new DataService();
		List returnList = new ArrayList();
		List qtyList = new ArrayList();
		List sideOneList = new ArrayList();
		List sideTwoList = new ArrayList();
		List sideOnePerList = new ArrayList();
		List sideTwoPerList = new ArrayList();
		List<PreferencesQuantityBreaks>	quantityBreaks = (List<PreferencesQuantityBreaks>)dataService.getAll("PreferencesQuantityBreaks");
		if (quantityBreaks.size() == 0) {
			quantityBreaks = defaultQuantityBreaks(quantityBreaks);
		}
		boolean firstQuantity = true;
		for (int i=0;i<quantityBreaks.size();i++) {
			long qty = quantityBreaks.get(i).getQuantity();
			double price = 0.0;
			if (qty == 0 && firstQuantity != true) {
				break;
			}
			firstQuantity = false;
			if (qty != 0) {
				qtyList.add(qty);
				if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.TotalOfAllCopies.name())) {
					price = getTotalAllCopiesPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getTotalAllCopiesPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.FlatRate.name())) {
					price = getFlatRatePrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getFlatRatePrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CostPlus.name())) {
					price = getCostPlusPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCostPlusPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesPerOriginals.name())) {
					price = getCopiesPerOriginalPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCopiesPerOriginalPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesAndOriginals.name())) {
					price = getCopiesPlusOriginalsPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCopiesPlusOriginalsPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.TotalSquareArea.name())) {
					price = getTotalOfSquareAreaPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getTotalOfSquareAreaPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaPerCopy.name())) {
					price = getSquareAreaPerCopyPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaPerCopyPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndOriginals.name())) {
					price = getSquareAreaAndOriginalsPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaAndOriginalsPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
					price = getSquareAreaAndCopiesPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaAndCopiesPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				}
			}
		}
		returnList.add(qtyList);
		returnList.add(sideOneList);
		returnList.add(sideTwoList);
		returnList.add(sideOnePerList);
		returnList.add(sideTwoPerList);
		return returnList;
	}
	
	public List<PreferencesQuantityBreaks> defaultQuantityBreaks(List<PreferencesQuantityBreaks> breaks) {
		PreferencesQuantityBreaks quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(1);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(10);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(50);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(100);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(250);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(500);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(750);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(1000);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(1500);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(2000);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(2500);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(5000);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(7500);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(10000);
		breaks.add(quantityBreak);
		quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQuantity(15000);
		breaks.add(quantityBreak);
		return breaks;
	}
	
	@SuppressWarnings("unchecked")
	public List<?> getPressPriceList(PressDefinition pressDefinition) throws Exception {
		DataService dataService = new DataService();
		List returnList = new ArrayList();
		List qtyList = new ArrayList();
		List sideOneList = new ArrayList();
		List sideTwoList = new ArrayList();
		List sideOnePerList = new ArrayList();
		List sideTwoPerList = new ArrayList();
		List<PreferencesQuantityBreaks>	quantityBreaks = (List<PreferencesQuantityBreaks>)dataService.getAll("PreferencesQuantityBreaks");
		if (quantityBreaks.size() == 0) {
			quantityBreaks = defaultQuantityBreaks(quantityBreaks);
		}
		boolean firstQuantity = true;
		for (int i=0;i<quantityBreaks.size();i++) {
			double price = 0.0;
			long qty = quantityBreaks.get(i).getQuantity();
			if (qty == 0 && firstQuantity != true) {
				break;
			}
			firstQuantity = false;
			if (qty != 0) {
				qtyList.add(qty);
				price = getPrintPrice(pressDefinition, qty, false);
				sideOneList.add(new Double(Math.round(price * 100)) / 100);
				sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				price = getPrintPrice(pressDefinition, qty, true);
				sideTwoList.add(new Double(Math.round(price * 100)) / 100);
				sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
			}
		}	
		returnList.add(qtyList);
		returnList.add(sideOneList);
		returnList.add(sideTwoList);
		returnList.add(sideOnePerList);
		returnList.add(sideTwoPerList);
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<?> getStockPriceList(StockDefinition stockDefinition, CopierDefinition copierDefinition) throws Exception{
		DataService dataService = new DataService();
		List returnList = new ArrayList();
		List qtyList = new ArrayList();
		List sideOneList = new ArrayList();
		List sideTwoList = new ArrayList();
		List sideOnePerList = new ArrayList();
		List sideTwoPerList = new ArrayList();
		List<PreferencesQuantityBreaks>	quantityBreaks = (List<PreferencesQuantityBreaks>)dataService.getAll("PreferencesQuantityBreaks");
		if (quantityBreaks.size() == 0) {
			quantityBreaks = defaultQuantityBreaks(quantityBreaks);
		}
		boolean firstQuantity = true;
		for (int i=0;i<quantityBreaks.size();i++) {
			long qty = quantityBreaks.get(i).getQuantity();
			double price = 0.0;
			if (qty == 0 && firstQuantity != true) {
				break;
			}
			firstQuantity = false;
			if (qty != 0) {
				qtyList.add(qty);
				if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.TotalOfAllCopies.name())) {
					price = getTotalAllCopiesPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getTotalAllCopiesPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.FlatRate.name())) {
					price = getFlatRatePrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getFlatRatePrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CostPlus.name())) {
					price = getCostPlusPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCostPlusPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesPerOriginals.name())) {
					price = getCopiesPerOriginalPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCopiesPerOriginalPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesAndOriginals.name())) {
					price = getCopiesPlusOriginalsPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getCopiesPlusOriginalsPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.TotalSquareArea.name())) {
					price = getTotalOfSquareAreaPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getTotalOfSquareAreaPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaPerCopy.name())) {
					price = getSquareAreaPerCopyPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaPerCopyPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndOriginals.name())) {
					price = getSquareAreaAndOriginalsPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaAndOriginalsPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				} else if (copierDefinition.getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
					price = getSquareAreaAndCopiesPrice(copierDefinition,qty,false);
					sideOneList.add(new Double(Math.round(price * 100)) / 100);
					sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
					price = getSquareAreaAndCopiesPrice(copierDefinition,qty,true);
					sideTwoList.add(new Double(Math.round(price * 100)) / 100);
					sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				}
			}
		}
		returnList.add(qtyList);
		returnList.add(sideOneList);
		returnList.add(sideTwoList);
		returnList.add(sideOnePerList);
		returnList.add(sideTwoPerList);
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<?> getStockPriceList(StockDefinition stockDefinition, PressDefinition pressDefinition) throws Exception{
		DataService dataService = new DataService();
		List returnList = new ArrayList();
		List qtyList = new ArrayList();
		List sideOneList = new ArrayList();
		List sideTwoList = new ArrayList();
		List sideOnePerList = new ArrayList();
		List sideTwoPerList = new ArrayList();
		List<PreferencesQuantityBreaks>	quantityBreaks = (List<PreferencesQuantityBreaks>)dataService.getAll("PreferencesQuantityBreaks");
		if (quantityBreaks.size() == 0) {
			quantityBreaks = defaultQuantityBreaks(quantityBreaks);
		}
		boolean firstQuantity = true;
		for (int i=0;i<quantityBreaks.size();i++) {
			double price = 0.0;
			long qty = quantityBreaks.get(i).getQuantity();
			if (qty == 0 && firstQuantity != true) {
				break;
			}
			firstQuantity = false;
			if (qty != 0) {
				qtyList.add(qty);
				price = getPrintPrice(pressDefinition, qty, false);
				sideOneList.add(new Double(Math.round(price * 100)) / 100);
				sideOnePerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
				price = getPrintPrice(pressDefinition, qty, true);
				sideTwoList.add(new Double(Math.round(price * 100)) / 100);
				sideTwoPerList.add(new Double(Math.round((price / qty) * 1000)) / 1000);
			}
		}	
		returnList.add(qtyList);
		returnList.add(sideOneList);
		returnList.add(sideTwoList);
		returnList.add(sideOnePerList);
		returnList.add(sideTwoPerList);
		return returnList;
	}
	
	public double getPrintPrice(PressDefinition pressDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		BigDecimal pressSpeed;
		if (pressDefinition.getSpeedTable() != null) {
			pressSpeed = new BigDecimal(PriceListUtilities.getSpeedFromSpeedTable(pressDefinition.getSpeedTable(), qty));
		}
		else
			pressSpeed = pressDefinition.getAvgImpressPerHour();
		
		float runHours = qty /pressSpeed.floatValue();
		float setupHours = pressDefinition.getSetupMin().floatValue() / 60;
		float totalHours = runHours + setupHours;
		float minimumHours = pressDefinition.getMinLabor().floatValue() / 60;
		if (totalHours < minimumHours)
			totalHours = minimumHours;
		if (doubleSided == true)
			totalHours = totalHours * 2;
		price = totalHours * pressDefinition.getLaborRate().doubleValue() * pressDefinition.getLaborMarkup();
		return price;
	}
	
	public double getTotalAllCopiesPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (matrixElement != null) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price *= copierDefinition.getCopyMarkup2();
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price = copierDefinition.getBaseRate().doubleValue() * price;
				price *= copierDefinition.getCopyMarkup2();
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					price = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty*2);
				} else {
					price = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price = copierDefinition.getBaseRate().doubleValue() * price;
			}
			
			if (doubleSided) {
				if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
					price = price * qty;
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
					price = price * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
					price = matrixElement.getPrice2().doubleValue();
					price = price * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					price = price*copierDefinition.getSideTwoFactor();
					price = (price * qty) + (price * qty);					
				}
			} else {
				price = price * qty;
			}
		}
		
		return price;
	}
	
	public double getCopiesPerOriginalPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (matrixElement != null) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price *= copierDefinition.getCopyMarkup2();
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price = copierDefinition.getBaseRate().doubleValue() * price;
				price *= copierDefinition.getCopyMarkup2();
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					price = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty*2);
				} else {
					price = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					price = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
				else
					price = matrixElement.getPrice1().doubleValue();
				price = copierDefinition.getBaseRate().doubleValue() * price;
			}
			
			if (doubleSided) {
				if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
					price = price * qty;
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
					price = price * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
					price = matrixElement.getPrice2().doubleValue();
					price = price * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					price = price*copierDefinition.getSideTwoFactor();
					price = (price * qty) + (price * qty);					
				}
			} else {
				price = price * qty;
			}
		}
		
		return price;
	}
	
	public double getFlatRatePrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double ratePerCopy = copierDefinition.getFlatRate().doubleValue();
		price = ratePerCopy;
		price = price * qty;
		if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
			price *= copierDefinition.getSideTwoFactor();
		}
	
		return price;
	}
	
	public double getCostPlusPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double machineCost = copierDefinition.getMachineCostPerCopy().doubleValue();
		double pricePerCopy = machineCost*copierDefinition.getCopyMarkup2();
		price = pricePerCopy * qty;
		return price;
	}
	
	public double getCopiesPlusOriginalsPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		Matrix pricingMatrix = copierDefinition.getCopierMatrix();
		String side2PricingMethod = copierDefinition.getPriceTwoSide();
		long calcQty = qty; 
		if (pricingMatrix != null) {
			int i;
			for (i = 0; i < pricingMatrix.getElements().size(); i++) {
				if (pricingMatrix.getElements().get(i).getQty() > qty) break;
			}
			if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
			
			int j = 0;
			
			if (pricingMatrix.getHeader1() > qty) j = 0;
			else if (pricingMatrix.getHeader2() > qty) j = 1;
			else if (pricingMatrix.getHeader3() > qty) j = 2;
			else if (pricingMatrix.getHeader4() > qty) j = 3;
			else if (pricingMatrix.getHeader5() > qty) j = 4;
			else if (pricingMatrix.getHeader6() > qty) j = 5;
			else if (pricingMatrix.getHeader7() > qty) j = 6;
			else if (pricingMatrix.getHeader8() > qty) j = 7;
			else if (pricingMatrix.getHeader9() > qty) j = 8;
			else if (pricingMatrix.getHeader10() > qty) j = 9;

			double unitPrice = 0.0;
			switch (j) {
			case (0):
				unitPrice = pricingMatrix.getElements().get(i).getPrice1().doubleValue();
				break;
			case (1):
				unitPrice = pricingMatrix.getElements().get(i).getPrice2().doubleValue();
				break;
			case (2):
				unitPrice = pricingMatrix.getElements().get(i).getPrice3().doubleValue();
				break;
			case (3):
				unitPrice = pricingMatrix.getElements().get(i).getPrice4().doubleValue();
				break;
			case (4):
				unitPrice = pricingMatrix.getElements().get(i).getPrice5().doubleValue();
				break;
			case (5):
				unitPrice = pricingMatrix.getElements().get(i).getPrice6().doubleValue();
				break;
			case (6):
				unitPrice = pricingMatrix.getElements().get(i).getPrice7().doubleValue();
				break;
			case (7):
				unitPrice = pricingMatrix.getElements().get(i).getPrice8().doubleValue();
				break;
			case (8):
				unitPrice = pricingMatrix.getElements().get(i).getPrice9().doubleValue();
				break;
			case (9):
				unitPrice = pricingMatrix.getElements().get(i).getPrice10().doubleValue();
				break;
			}
			
			if (doubleSided) {
				if (side2PricingMethod.equals(Price2Side.NotChangingPrice)) {
					/* Do nothing - the price is the same */
				} else if (side2PricingMethod.equals(Price2Side.UsingFirstSideRate)) {
					unitPrice *= 2;
				} else if (side2PricingMethod.equals(Price2Side.UsingSecondSideRate)) {
					switch (j) {
					case (0):
						unitPrice += pricingMatrix.getElements().get(i).getPrice11().doubleValue();
						break;
					case (1):
						unitPrice += pricingMatrix.getElements().get(i).getPrice12().doubleValue();
						break;
					case (2):
						unitPrice += pricingMatrix.getElements().get(i).getPrice13().doubleValue();
						break;
					case (3):
						unitPrice += pricingMatrix.getElements().get(i).getPrice14().doubleValue();
						break;
					case (4):
						unitPrice += pricingMatrix.getElements().get(i).getPrice15().doubleValue();
						break;
					case (5):
						unitPrice += pricingMatrix.getElements().get(i).getPrice16().doubleValue();
						break;
					case (6):
						unitPrice += pricingMatrix.getElements().get(i).getPrice17().doubleValue();
						break;
					case (7):
						unitPrice += pricingMatrix.getElements().get(i).getPrice18().doubleValue();
						break;
					case (8):
						unitPrice += pricingMatrix.getElements().get(i).getPrice19().doubleValue();
						break;
					case (9):
						unitPrice += pricingMatrix.getElements().get(i).getPrice20().doubleValue();
						break;
					}
				} else if (side2PricingMethod.equals(Price2Side.CountingAsMoreOriginals)) {
					/* Note that we are completely overriding the unitPrice here instead of adding to it */
					for (; i < pricingMatrix.getElements().size(); i++) {
						if (pricingMatrix.getElements().get(i).getQty() >= qty) break;
					}
					if (i >0) i--;
					switch (j) {
					case (0):
						unitPrice = pricingMatrix.getElements().get(i).getPrice1().doubleValue();
						break;
					case (1):
						unitPrice = pricingMatrix.getElements().get(i).getPrice2().doubleValue();
						break;
					case (2):
						unitPrice = pricingMatrix.getElements().get(i).getPrice3().doubleValue();
						break;
					case (3):
						unitPrice = pricingMatrix.getElements().get(i).getPrice4().doubleValue();
						break;
					case (4):
						unitPrice = pricingMatrix.getElements().get(i).getPrice5().doubleValue();
						break;
					case (5):
						unitPrice = pricingMatrix.getElements().get(i).getPrice6().doubleValue();
						break;
					case (6):
						unitPrice = pricingMatrix.getElements().get(i).getPrice7().doubleValue();
						break;
					case (7):
						unitPrice = pricingMatrix.getElements().get(i).getPrice8().doubleValue();
						break;
					case (8):
						unitPrice = pricingMatrix.getElements().get(i).getPrice9().doubleValue();
						break;
					case (9):
						unitPrice = pricingMatrix.getElements().get(i).getPrice10().doubleValue();
						break;
					}
				} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor)) {
					unitPrice *= copierDefinition.getSideTwoFactor();
				}
			}
			double pricePerCopy = unitPrice;
			double pricePerSecondSide = unitPrice;
			double wastePrice = 0.0;
			if (copierDefinition.getMatrixType().equals("CopyCost"))
				pricePerCopy *= copierDefinition.getCopyMarkup2();
			else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = unitPrice;
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
			}  else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = unitPrice;
				
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
			}
			if (doubleSided) {
				if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
					price = pricePerCopy * qty;
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
					price = pricePerCopy * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
					pricePerSecondSide = unitPrice;
					price = pricePerSecondSide * qty;					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
					price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
				} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					price = (pricePerCopy * qty) + (pricePerSecondSide * qty) * 2;					
				}
			} else {
				price = pricePerCopy * qty;				
			}
		}
		return price;
	}
	
	public double getTotalOfSquareAreaPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (copierDefinition.getMatrixType().equals("CopyCost")) {
			if (copierDefinition.getInterpolateMatrix() == true)
				pricePerCopy = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				pricePerCopy = matrixElement.getPrice1().doubleValue();
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
			double discountPct = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				discountPct = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				discountPct = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("StepTable")) {
			if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty * 2);
			} else {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
			}
		}  else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
			double markup = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				markup = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				markup = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
		}
		if (doubleSided) {
			if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
				price = pricePerCopy * qty;
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
				price = pricePerCopy * qty * 2;					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
				pricePerSecondSide = matrixElement.getPrice2().doubleValue();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
				pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			}
		} else {
			price = pricePerCopy * qty;
		}
		return price;
	}
	
	public double getSquareAreaPerCopyPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (copierDefinition.getMatrixType().equals("CopyCost")) {
			if (copierDefinition.getInterpolateMatrix() == true)
				pricePerCopy = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				pricePerCopy = matrixElement.getPrice1().doubleValue();
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
			double discountPct = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				discountPct = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				discountPct = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("StepTable")) {
			if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty * 2);
			} else {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
			}
		}  else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
			double markup = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				markup = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				markup = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
		}
		if (doubleSided) {
			if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
				price = pricePerCopy * qty;
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
				price = pricePerCopy * qty * 2;					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
				pricePerSecondSide = matrixElement.getPrice2().doubleValue();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
				pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			}
		} else {
			price = pricePerCopy * qty;
		}
		return price;
	}
	
	public double getSquareAreaAndOriginalsPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (copierDefinition.getMatrixType().equals("CopyCost")) {
			if (copierDefinition.getInterpolateMatrix() == true)
				pricePerCopy = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				pricePerCopy = matrixElement.getPrice1().doubleValue();
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
			double discountPct = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				discountPct = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				discountPct = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("StepTable")) {
			if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty * 2);
			} else {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
			}
		}  else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
			double markup = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				markup = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				markup = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
		}
		if (doubleSided) {
			if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
				price = pricePerCopy * qty;
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
				price = pricePerCopy * qty * 2;					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
				pricePerSecondSide = matrixElement.getPrice2().doubleValue();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
				pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			}
		} else {
			price = pricePerCopy * qty;
		}
		return price;
	}
	
	public double getSquareAreaAndCopiesPrice(CopierDefinition copierDefinition, long qty, boolean doubleSided) {
		double price = 0.0;
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(copierDefinition.getCopierMatrix(), qty);
		
		if (copierDefinition.getMatrixType().equals("CopyCost")) {
			if (copierDefinition.getInterpolateMatrix() == true)
				pricePerCopy = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				pricePerCopy = matrixElement.getPrice1().doubleValue();
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
			double discountPct = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				discountPct = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				discountPct = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
			pricePerCopy *= copierDefinition.getCopyMarkup();
		} else if (copierDefinition.getMatrixType().equals("StepTable")) {
			if (doubleSided && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty * 2);
			} else {
				pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), qty);
			}
		}  else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
			double markup = 0.0;
			if (copierDefinition.getInterpolateMatrix() == true)
				markup = MatrixUtilities.calculateInterpolation(copierDefinition.getCopierMatrix(), qty);
			else
				markup = matrixElement.getPrice1().doubleValue();
			pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
		}
		if (doubleSided) {
			if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
				price = pricePerCopy * qty;
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
				price = pricePerCopy * qty * 2;					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
				pricePerSecondSide = matrixElement.getPrice2().doubleValue();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
				pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
				price = (pricePerCopy * qty) + (pricePerSecondSide * qty);					
			}
		} else {
			price = pricePerCopy * qty;
		}
		return price;
	}
	
	public PriceList createPriceList() {
		PriceList priceList = new PriceList();
		
		priceList.setIsDollar(true);
		
		PriceListElement element = null;
		for (int i = 0; i < 14; i++) {
			element = new PriceListElement();
			element.setAmount(0.0);
			element.setQuantity(0L);
			
			priceList.addElements(element);
		}
		return priceList;
	}
	
	public WasteChart createWasteChart() {
		WasteChart wasteChart = new WasteChart();
		
		wasteChart.setIsDollar(false);
		
		PriceListElement element = null;
		for (int i = 0; i < 14; i++) {
			element = new PriceListElement();
			element.setAmount(0.0);
			element.setQuantity(0L);
			
			wasteChart.addElements(element);
		}
		wasteChart.setInterpolate(true);
		wasteChart.setIsPercentage(true);
		return wasteChart;
	}
	
	public SpeedTable createSpeedTable() {
		SpeedTable speedTable = new SpeedTable();
		
		speedTable.setIsDollar(true);
		
		PriceListElement element = null;
		for (int i = 0; i < 14; i++) {
			element = new PriceListElement();
			element.setAmount(0.0);
			element.setQuantity(0L);
			
			speedTable.addElements(element);
		}
		speedTable.setInterpolate(false);
		speedTable.setIsPercentage(false);
		return speedTable;
	}
	
	public PaperPrice createPaperPrice() {
		PaperPrice paperPrice = new PaperPrice();
		
		//paperPrice.setIsDollar(true);
		
		PriceListElement element = null;
		for (int i = 0; i < 14; i++) {
			element = new PriceListElement();
			element.setAmount(0.0);
			element.setQuantity(0L);
			
			//paperPrice.addElements(element);
		}
		//paperPrice.setInterpolate(false);
		//paperPrice.setIsPercentage(false);
		return paperPrice;
	}
}