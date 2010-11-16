package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;

public class FlatRatePricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(FlatRatePricingMethod.class);

	@Override
	public Job priceCopierJob(Job job) throws Exception {
		log.info("Start priceCopierJob for job " + job.getId());
		super.priceCopierJob(job);

		double price = 0.0;
		PricingRecord pricingRecord = job.getPricingRecord();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		if (pricingRecord == null) {
			pricingRecord = new PricingRecord();
			pricingRecord.setUnitPriceOverride(false);
			pricingRecord.setTotalPriceOverride(false);
		}
		PriceLogEntry priceLogEntry = PriceLogUtilities.createPriceLogEntry("FlatRatePricingMethod", "Price Flat Rate Copier Job");
		pricingRecord.setPriceLogEntry(priceLogEntry);

		calculateUnitPrice(job);
		double stockPrice = 0.0;
		if (job.getStock() != null)
			stockPrice = priceStockEngine.priceStock(job);
		double wastePrice = ((job.getBinderyWaste().doubleValue() + job.getEstWaste().doubleValue()) * pricingRecord.getUnitPrice().doubleValue()) * job.getSheets();
		int runout = job.getPaperCal().getRunout();
		if (runout == 0)
			runout = 1;
		if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
			stockPrice = stockPrice * job.getPricingCopier().getSideTwoFactor();
		}
		if (job.getDoubleSided())
			price = (pricingRecord.getUnitPrice().doubleValue() * job.getTotalCopies()) + (stockPrice * ((job.getTotalCopies()/2) / runout)) + wastePrice;
		else
			price = (pricingRecord.getUnitPrice().doubleValue() * job.getTotalCopies()) + (stockPrice * (job.getTotalCopies() / runout)) + wastePrice;
		pricingRecord.setTotalPrice(price);
		if (price == 0)
			pricingRecord.setUnitPrice(0);
		else
			pricingRecord.setUnitPrice(price / job.getTotalCopies());
		priceLogEntry.setValue(price);
		return job;
	}
	
	private void calculateUnitPrice(Job job) throws Exception {
		//PriceStockEngine priceStockEngine = new PriceStockEngine();
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
				if (job.getStock() != null) {
					//double stockPrice = priceStockEngine.priceStock(job);
					
					//price += stockPrice;
				}
				if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					price = (price * job.getPricingCopier().getSideTwoFactor()) / 2;
				}
				if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
					price = price / 2;
				}
				PriceLogUtilities.createPriceLogEntry(parentLogEntry, "FlatRatePricingMethod", "Side One Unit Price (Rate*Qty Ordered): " + ratePerCopy + "*" + job.getSheets(), price);

				//if (job.getDoubleSided()) {
				//	double secondSidePrice = ratePerCopy*(pricingCopier.getSideTwoFactor()-1)*job.getSheets();
				//	price += secondSidePrice;
				//	
				//	PriceLogUtilities.createPriceLogEntry(parentLogEntry, "FlatRatePricingMethod", 
				//			"Side Two Unit Price (Rate*Side Two Factor*Sheets): " + ratePerCopy + "*" + (pricingCopier.getSideTwoFactor()-1) + "*" + job.getSheets(), secondSidePrice);
				//}
				
				pricingRecord.setUnitPrice(price);
				
				job.setPricingRecord(pricingRecord);
			} else {
				log.error("No pricing copier found for job");
			}			
		}
	}
}
