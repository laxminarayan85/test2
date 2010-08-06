package com.efi.printsmith.pricing.copier;

import java.util.Date;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;
import com.efi.printsmith.service.PricingService;

public class FlatRatePricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(FlatRatePricingMethod.class);

	public Job priceCopierJob(Job job) {
		log.info("Start priceCopierJob for job " + job.getId());
		super.priceCopierJob(job);

		double price = 0.0;
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord == null) {
			pricingRecord = new PricingRecord();
			pricingRecord.setUnitPriceOverride(false);
			pricingRecord.setTotalPriceOverride(false);
		}
		PriceLogEntry priceLogEntry = PriceLogUtilities.createPriceLogEntry("FlatRatePricingMethod", "Price Flat Rate Copier Job");
		pricingRecord.setPriceLogEntry(priceLogEntry);

		calculateUnitPrice(job);
		double wastePrice = ((job.getBinderyWaste().doubleValue() + job.getEstWaste().doubleValue()) * pricingRecord.getUnitPrice().doubleValue()) * job.getSheets();
		price = (pricingRecord.getUnitPrice().doubleValue() * (job.getQtyOrdered() * job.getSheets() * job.getInSetsOf())) + wastePrice;
		if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
			price *= 2;
		}
		
		pricingRecord.setTotalPrice(price);
		priceLogEntry.setValue(price);
		return job;
	}
	
	private void calculateUnitPrice(Job job) {
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		PricingRecord pricingRecord = job.getPricingRecord();
		
		double price = 0.0;
		
		if (job.getPricingRecord().getUnitPriceOverride()) {
			return;
		} else {
			CopierDefinition pricingCopier = job.getPricingCopier();
			if (pricingCopier != null) {
				double ratePerCopy = pricingCopier.getFlatRate().doubleValue();
				PriceLogEntry parentLogEntry = job.getPricingRecord().getPriceLogEntry();
				
				price = ratePerCopy;
				if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					price = (price * job.getPricingCopier().getSideTwoFactor()) / 2;
				}
				PriceLogUtilities.createPriceLogEntry(parentLogEntry, "FlatRatePricingMethod", "Side One Unit Price (Rate*Qty Ordered): " + ratePerCopy + "*" + job.getSheets(), price);

				//if (job.getDoubleSided()) {
				//	double secondSidePrice = ratePerCopy*(pricingCopier.getSideTwoFactor()-1)*job.getSheets();
				//	price += secondSidePrice;
				//	
				//	PriceLogUtilities.createPriceLogEntry(parentLogEntry, "FlatRatePricingMethod", 
				//			"Side Two Unit Price (Rate*Side Two Factor*Sheets): " + ratePerCopy + "*" + (pricingCopier.getSideTwoFactor()-1) + "*" + job.getSheets(), secondSidePrice);
				//}
				
				if (job.getStock() != null) {
					double stockPrice = priceStockEngine.priceStock(job);
					
					price += stockPrice;
				}
				pricingRecord.setUnitPrice(price);
				
				job.setPricingRecord(pricingRecord);
			} else {
				log.error("No pricing copier found for job");
			}			
		}
	}
}
