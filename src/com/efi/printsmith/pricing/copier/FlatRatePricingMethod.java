package com.efi.printsmith.pricing.copier;

import java.util.Date;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.service.PricingService;

public class FlatRatePricingMethod implements CopierPricingMethod {
	protected static Logger log = Logger.getLogger(FlatRatePricingMethod.class);

	public Job priceCopierJob(Job job) {
		log.info("Start priceJob for job " + job.getId());
		double price = 0.0;
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		
		CopierDefinition pricingCopier = job.getPricingCopier();
		if (pricingCopier != null) {
			double ratePerCopy = pricingCopier.getFlatRate();
			PricingRecord pricingRecord = job.getPricingRecord();
			if (pricingRecord == null) {
				pricingRecord = new PricingRecord();
				pricingRecord.setUnitPriceOverride(false);
				pricingRecord.setTotalPriceOverride(false);
			}
			PriceLogEntry priceLogEntry = new PriceLogEntry();
			pricingRecord.setPriceLogEntry(priceLogEntry);
			PriceLogEntry detailLogEntry = new PriceLogEntry();
			priceLogEntry.setDate(new Date());
			priceLogEntry.setDescription("Price Flat Rate Copier Job");
			priceLogEntry.setMethod("FlatRatePricingMethod");
			priceLogEntry.setValue(price);
			
			price = ratePerCopy*job.getQtyOrdered()*job.getSheets();
			detailLogEntry.setDate(priceLogEntry.getDate());
			detailLogEntry.setDescription("Side One Price (Rate*Qty Ordered): " + ratePerCopy + "*" + job.getQtyOrdered() + "*" + job.getSheets());
			detailLogEntry.setMethod("FlatRatePricingMethod");
			detailLogEntry.setValue(price);
			priceLogEntry.addChildren(detailLogEntry);
			if (job.getDoubleSided()) {
				double secondSidePrice = ratePerCopy*(pricingCopier.getSideTwoFactor()-1)*job.getQtyOrdered()*job.getSheets();
				price += secondSidePrice;
				
				detailLogEntry = new PriceLogEntry();
				detailLogEntry.setDate(priceLogEntry.getDate());
				detailLogEntry.setDescription("Side Two Price (Rate*Side Two Factor*Qty Ordered*Sheets): " + ratePerCopy + "*" + (pricingCopier.getSideTwoFactor()-1) + "*" + job.getQtyOrdered() + "*" + job.getSheets());
				detailLogEntry.setMethod("FlatRatePricingMethod");
				detailLogEntry.setValue(secondSidePrice);
				priceLogEntry.addChildren(detailLogEntry);
			}
			
			if (job.getStock() != null) {
				double stockPrice = priceStockEngine.priceStock(job);
				
				price += stockPrice;
			}
			pricingRecord.setTotalPrice(price);
			
			priceLogEntry.setValue(price);
			job.setPricingRecord(pricingRecord);
		} else {
			log.error("No pricing copier found for job");
		}
		
		return job;
	}
	
	private void calculateUnitPrice(Job job) {
		if (job.getPricingRecord().getUnitPriceOverride()) {
			return;
		} else {
			
		}
	}
}
