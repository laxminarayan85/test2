package com.efi.printsmith.pricing.stock;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.CopierPricingMethod;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.copier.CopiesPerOriginalPricingMethod;
import com.efi.printsmith.pricing.copier.CopiesPlusOriginalsPricingMethod;
import com.efi.printsmith.pricing.copier.CostPlusPricingMethod;
import com.efi.printsmith.pricing.copier.FlatRatePricingMethod;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;
import com.efi.printsmith.data.PaperPrice;

public class PriceStockEngine {
	public double priceStock(Job job) {
		if (job == null) return 0.0;
		double retVal = 0.0;
		PreferencesPricingMethod pricingMethod = job.getPricingMethod();
		if (pricingMethod.getTitle().equals("Printing")) {
			retVal =pricePrintStock(job);
		} else { if (pricingMethod.getTitle().equals("Blank")) {
			retVal = priceBlankStock(job);
		} else
			retVal = priceCopierStock(job);
		}
		return retVal;
	}
	
	private double priceBlankStock(Job job) {
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
		
		for (int i = 1; i <= 6; i++) {
			if (i == 1) {
				if (qty >= stockDefinition.getBlankSheetqty1() && qty < stockDefinition.getBlankSheetqty2())
					retVal = stockDefinition.getBlankSheetPrice1();
					retVal = retVal / stockDefinition.getBlankSheetqty1();
					break;
			}else if (i == 2) {
				if (qty >= stockDefinition.getBlankSheetqty2() && qty < stockDefinition.getBlankSheetqty3())
					retVal = stockDefinition.getBlankSheetPrice2();
					retVal = retVal / stockDefinition.getBlankSheetqty2();
					break;
			}else if (i == 3) {
				if (qty >= stockDefinition.getBlankSheetqty3() && qty < stockDefinition.getBlankSheetqty4())
					retVal = stockDefinition.getBlankSheetPrice3();
					retVal = retVal / stockDefinition.getBlankSheetqty3();
					break;
			}else if (i == 4) {
				if (qty >= stockDefinition.getBlankSheetqty4() && qty < stockDefinition.getBlankSheetqty5())
					retVal = stockDefinition.getBlankSheetPrice4();
					retVal = retVal / stockDefinition.getBlankSheetqty4();
					break;
			}else if (i == 5) {
				if (qty >= stockDefinition.getBlankSheetqty5() && qty < stockDefinition.getBlankSheetqty6())
					retVal = stockDefinition.getBlankSheetPrice5();
					retVal = retVal / stockDefinition.getBlankSheetqty5();
					break;
			}else if (i == 6) {
				if (qty >= stockDefinition.getBlankSheetqty6())
					retVal = stockDefinition.getBlankSheetPrice6();
					retVal = retVal / stockDefinition.getBlankSheetqty6();
					break;
			}
		}
		return retVal;
	}
	
	private double pricePrintStock(Job job) {
		double retVal = 0.0;
		
		PricingRecord pricingRecord = null;
		PriceLogEntry parentEntry= null;
		PriceLogEntry priceLogEntry = null;
		
		
		if (job == null) return 0.0;
		
		pricingRecord = job.getPricingRecord();
		parentEntry = pricingRecord.getPriceLogEntry();
		
		StockDefinition stockDefinition = job.getStock();
		
		if (stockDefinition == null) return 0.0;
		
		priceLogEntry = PriceLogUtilities.createPriceLogEntry(parentEntry, "pricePrintStock", "");
		
		PaperPrice paperPrice = stockDefinition.getDefaultPriceList();
		if (paperPrice != null)
			retVal = PriceListUtilities.lookupPrice(paperPrice, job.getQtyOrdered());
		priceLogEntry.setDescription("Stock Price is Print");
		priceLogEntry.setValue(retVal);
		return retVal;
	}
	
	private double priceCopierStock(Job job) {
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
			sheetPrice = stockDefinition.getCopier1PricePerSheet();
			priceLogEntry.setDescription("Stock price is copier 1 price per sheet");
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier2InStockDefinition.name())) {
			sheetPrice = stockDefinition.getCopier2PricePerSheet();
			priceLogEntry.setDescription("Stock price is copier 2 price per sheet");
		} else if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier3InStockDefinition.name())) {
			sheetPrice = stockDefinition.getCopier3PricePerSheet();
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
			if (pricingMethod.getTitle().equals("Large Format")) {
				try {
					if (copierDefinition.getSquareAreaType() == "AreaFinishSize")
						qty = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
					else
						qty = new Double(Double.parseDouble(job.getParentSize()) * job.getCutOff()).longValue();
				}
				catch (Exception e) {
					
				}
				if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
					qty = qty * job.getTotalCopies();
				} else if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndOriginals.name())) {
					qty = qty * job.getQtyOrdered();
				} else if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.TotalSquareArea.name())) {
					qty = qty * job.getQtyOrdered();
				}
			}
			else {
				qty = (job.getQtyOrdered() + job.getBinderyWaste() + job.getEstWaste());// * job.getSignatures(); // TODO: Double-check need to use signatures vs just sheets ordered here
			}
			double markup = 0.0;
			double stockCost = 0.0;
			
			if (qty <= stockDefinition.getQtybreak1()) {
				markup = stockDefinition.getMarkup1();
				stockCost = stockDefinition.getCost1();
			} else if (qty <= stockDefinition.getQtybreak2()) {
				markup = stockDefinition.getMarkup2();
				stockCost = stockDefinition.getCost2();
			} else if (qty <= stockDefinition.getQtybreak3()) {
				markup = stockDefinition.getMarkup3();
				stockCost = stockDefinition.getCost3();
			} else if (qty <= stockDefinition.getQtybreak4()) {
				markup = stockDefinition.getMarkup4();
				stockCost = stockDefinition.getCost4();
			} else if (qty <= stockDefinition.getQtybreak5()) {
				markup = stockDefinition.getMarkup5();
				stockCost = stockDefinition.getCost5();
			} else if (qty <= stockDefinition.getQtybreak6()) {
				markup = stockDefinition.getMarkup6();
				stockCost = stockDefinition.getCost6();
			} else {
				markup = stockDefinition.getMarkup1();
				stockCost = stockDefinition.getCost1();
			}
			if (copierDefinition.getUseCopierStockMarkup()) {
				markup = copierDefinition.getStockMarkup();
			}
			retVal = stockCost/stockDefinition.getCostunits() * markup;
			priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockCost + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + markup);
		}
		return retVal;
	}
}