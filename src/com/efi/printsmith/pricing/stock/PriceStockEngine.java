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
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;

public class PriceStockEngine {
	public double priceStock(Job job) {
		if (job == null) return 0.0;
		
		/* TODO: URGENT - assumes copier job here. Needs to be based on pricing method and chosen estimator */
		return priceCopierStock(job);
	}
	
	private double priceCopierStock(Job job) {
		double retVal = 0.0;
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
		return retVal;		
	}
	
	private double getSheetPrice(Job job, PriceLogEntry priceLogEntry) {
		double retVal = 0.0;
		long qty = 0;
		
		if (job == null) return 0.0;
		
		StockDefinition stockDefinition = job.getStock();
		if (stockDefinition == null) return 0.0;

		if (stockDefinition.getCostunits() > 0) {
			qty = (job.getQtyOrdered() + job.getBinderyWaste() + job.getEstWaste());// * job.getSignatures(); // TODO: Double-check need to use signatures vs just sheets ordered here
			
			if (qty <= stockDefinition.getQtybreak1()) {
				retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup1();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost1() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup1());
			} else if (qty <= stockDefinition.getQtybreak2()) {
				retVal = stockDefinition.getCost2()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup2();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost2() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup2());
			} else if (qty <= stockDefinition.getQtybreak3()) {
				retVal = stockDefinition.getCost3()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup3();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost3() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup3());
			} else if (qty <= stockDefinition.getQtybreak4()) {
				retVal = stockDefinition.getCost4()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup4();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost4() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup4());
			} else if (qty <= stockDefinition.getQtybreak5()) {
				retVal = stockDefinition.getCost5()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup5();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost5() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup5());
			} else if (qty <= stockDefinition.getQtybreak6()) {
				retVal = stockDefinition.getCost6()/stockDefinition.getCostunits() * qty * stockDefinition.getMarkup6();
				priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost6() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
			}
		}
		return retVal;
	}
}
