package com.efi.printsmith.pricing.stock;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;

public class PriceStockEngine {
	public double priceStock(Job job) throws Exception {
		if (job == null) return 0.0;
		double retVal = 0.0;
		PreferencesPricingMethod pricingMethod = job.getPricingMethod();
		if (pricingMethod.getTitle().equals("Printing")) {
			retVal = pricePrintStock(job);
		} else { if (pricingMethod.getTitle().equals("Blank")) {
			retVal = priceBlankStock(job);
		} else
			retVal = priceCopierStock(job);
		}
		return retVal;
	}
	
	private double priceBlankStock(Job job) throws Exception {
		double retVal = 0.0;
		PricingRecord pricingRecord = null;
		PriceLogEntry parentEntry= null;
		PriceLogEntry priceLogEntry = null;
		
		
		if (job == null) return 0.0;
		
		pricingRecord = job.getPricingRecord();
		parentEntry = pricingRecord.getPriceLogEntry();
		
		StockDefinition stockDefinition = job.getStock();
		
		if (stockDefinition == null) return 0.0;
		
		priceLogEntry = PriceLogUtilities.createPriceLogEntry(parentEntry, "priceBlankStock", "");
		
		long qty = job.getQtyOrdered();
		if (qty < stockDefinition.getMinorder())
			qty = stockDefinition.getMinorder();
		
		for (int i = 1; i <= 6; i++) {
			if (i == 1) {
				if (qty >= stockDefinition.getBlankSheetqty1() && qty < stockDefinition.getBlankSheetqty2()) {
					retVal = stockDefinition.getBlankSheetPrice1();
					retVal = retVal / stockDefinition.getBlankSheetqty1();
					break;
				}
			}else if (i == 2) {
				if (qty >= stockDefinition.getBlankSheetqty2() && qty < stockDefinition.getBlankSheetqty3()) {
					retVal = stockDefinition.getBlankSheetPrice2();
					retVal = retVal / stockDefinition.getBlankSheetqty2();
					break;
				}
			}else if (i == 3) {
				if (qty >= stockDefinition.getBlankSheetqty3() && qty < stockDefinition.getBlankSheetqty4()) {
					retVal = stockDefinition.getBlankSheetPrice3();
					retVal = retVal / stockDefinition.getBlankSheetqty3();
					break;
				}
			}else if (i == 4) {
				if (qty >= stockDefinition.getBlankSheetqty4() && qty < stockDefinition.getBlankSheetqty5()) {
					retVal = stockDefinition.getBlankSheetPrice4();
					retVal = retVal / stockDefinition.getBlankSheetqty4();
					break;
				}
			}else if (i == 5) {
				if (qty >= stockDefinition.getBlankSheetqty5() && qty < stockDefinition.getBlankSheetqty6()) {
					retVal = stockDefinition.getBlankSheetPrice5();
					retVal = retVal / stockDefinition.getBlankSheetqty5();
					break;
				}
			}else if (i == 6) {
				if (qty >= stockDefinition.getBlankSheetqty6()) {
					retVal = stockDefinition.getBlankSheetPrice6();
					retVal = retVal / stockDefinition.getBlankSheetqty6();
					break;
				}
			}
		}
		return retVal;
	}
	
	private double pricePrintStock(Job job) throws Exception {
		PricingRecord pricingRecord = null;
		PriceLogEntry parentEntry= null;
		PriceLogEntry priceLogEntry = null;
		
		
		if (job == null) return 0.0;
		
		pricingRecord = job.getPricingRecord();
		parentEntry = pricingRecord.getPriceLogEntry();
		
		StockDefinition stockDefinition = job.getStock();
		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (stockDefinition == null || copierDefinition == null) return 0.0;
		
		double sheetPrice = 0.0;
		long qty = job.getSheets();
		if (qty < stockDefinition.getMinorder())
			qty = stockDefinition.getMinorder();
		priceLogEntry = PriceLogUtilities.createPriceLogEntry(parentEntry, "pricePrintStock", "");
		sheetPrice = getSheetPrice(job, priceLogEntry);
		priceLogEntry.setValue(sheetPrice * qty);
		return sheetPrice;		
	}
	
	private double priceCopierStock(Job job) throws Exception {
		PricingRecord pricingRecord = null;
		PriceLogEntry parentEntry= null;
		PriceLogEntry priceLogEntry = null;
		
		
		if (job == null) return 0.0;
		
		pricingRecord = job.getPricingRecord();
		parentEntry = pricingRecord.getPriceLogEntry();
		
		StockDefinition stockDefinition = job.getStock();
		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (stockDefinition == null || copierDefinition == null) return 0.0;
		
		double sheetPrice = 0.0;

		priceLogEntry = PriceLogUtilities.createPriceLogEntry(parentEntry, "priceCopierStock", "");
		if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.MarkedUpStockCost.name())) {
			sheetPrice = getSheetPrice(job, priceLogEntry);
			priceLogEntry.setValue(sheetPrice);
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.IncludeInRate.name())) {
			sheetPrice = 0.0; /* By definition the stock price is already included in the copier rate */
			priceLogEntry.setDescription("Stock price included in rate");
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier1InStockDefinition.name())) {
			if (job.getTotalCopies() > 0)
			{
				sheetPrice = stockDefinition.getCopier1PricePerSheet().doubleValue();
			}
			priceLogEntry.setDescription("Stock price is copier 1 price per sheet");
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier2InStockDefinition.name())) {
			if (job.getTotalCopies() > 0)
			{
				sheetPrice = stockDefinition.getCopier2PricePerSheet().doubleValue();
			}
			priceLogEntry.setDescription("Stock price is copier 2 price per sheet");
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier3InStockDefinition.name())) {
			if (job.getTotalCopies() > 0)
			{
				sheetPrice = stockDefinition.getCopier3PricePerSheet().doubleValue();
			}
			priceLogEntry.setDescription("Stock price is copier 3 price per sheet");
		} else {
			priceLogEntry.setDescription("Stock price method unknown - setting stock price to 0");
		}
		priceLogEntry.setValue(sheetPrice);
		return sheetPrice;		
	}
	
	private double getSheetPrice(Job job, PriceLogEntry priceLogEntry) {
		double retVal = 0.0;
		long qty = 0;
		
		if (job == null) return 0.0;
		PreferencesPricingMethod pricingMethod = job.getPricingMethod();
		StockDefinition stockDefinition = job.getStock();
		CopierDefinition copierDefinition = job.getPricingCopier();
		if (stockDefinition == null) return 0.0;

		if (stockDefinition.getCostunits() > 0) {
			if (pricingMethod.getMethod().equals("Large Format")) {
				try {
					if (copierDefinition.getSquareAreaType() == "AreaFinishSize")
						qty = PriceListUtilities.getAreaFromSizeString(job.getFinishSize()) * job.getTotalCopies();
					else
						if (job.getStock() != null && job.getStock().getStockunit() == 4)
							qty = PriceListUtilities.getAreaFromSizeString(job.getRunSize()) * job.getTotalCopies();
						else
							qty = new Double(Double.parseDouble(job.getParentSize()
									.getName())
									* job.getCutOff()).longValue() * job.getTotalCopies();
				}
				catch (Exception e) {
					
				}
			}
			else if (pricingMethod.getMethod().equals("Printing")){
				qty = job.getImpressionsPerRun() * job.getSheets();// * job.getSignatures(); // TODO: Double-check need to use signatures vs just sheets ordered here
			} else {
				qty = (job.getNumCopies() * (job.getSheets() / job.getNumOn()));
				if (job.getPaperCal().getRunout() > 0)
					qty = qty / job.getPaperCal().getRunout();
			}
			double markup = 0.0;
			double stockCost = 0.0;
			if (qty > 0) {
				if (qty <= stockDefinition.getQtybreak1()) {
					markup = stockDefinition.getMarkup1();
					stockCost = stockDefinition.getCost1().doubleValue();
				} else if (qty <= stockDefinition.getQtybreak2()) {
					markup = stockDefinition.getMarkup2();
					stockCost = stockDefinition.getCost2().doubleValue();
				} else if (qty <= stockDefinition.getQtybreak3()) {
					markup = stockDefinition.getMarkup3();
					stockCost = stockDefinition.getCost3().doubleValue();
				} else if (qty <= stockDefinition.getQtybreak4()) {
					markup = stockDefinition.getMarkup4();
					stockCost = stockDefinition.getCost4().doubleValue();
				} else if (qty <= stockDefinition.getQtybreak5()) {
					markup = stockDefinition.getMarkup5();
					stockCost = stockDefinition.getCost5().doubleValue();
				} else if (qty <= stockDefinition.getQtybreak6()) {
					markup = stockDefinition.getMarkup6();
					stockCost = stockDefinition.getCost6().doubleValue();
				} else if (stockDefinition.getCost6().doubleValue() == 0) {
					markup = stockDefinition.getMarkup1();
					stockCost = stockDefinition.getCost1().doubleValue();
				}
				else{
					markup = stockDefinition.getMarkup6();
					stockCost = stockDefinition.getCost6().doubleValue();
				}
				if (copierDefinition.getUseCopierStockMarkup()) {
					markup = copierDefinition.getStockMarkup();
				}
				
				if (job.getCostUnitsOverride() == false)
					job.setCostUnits(stockDefinition.getCostunits());
				if (job.getParentStockCostOverride())
					stockCost = job.getParentStockCost().doubleValue();
				if (job.getOrStockMarkup())
					markup = job.getPricingRecord().getStockMarkup().doubleValue();
				
				double temp = qty / job.getCostUnits().doubleValue();
				retVal = (stockCost * temp * markup) / qty;
			}
			//retVal = stockCost/stockDefinition.getCostunits() * markup;
			priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockCost + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + markup);
		}
		return retVal;
	}
}