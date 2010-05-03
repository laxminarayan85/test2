package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;

public class CostPlusPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CostPlusPricingMethod.class);
	public Job priceCopierJob(Job job) {
		super.priceCopierJob(job);

		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (job.getPricingRecord() == null) {
			log.error ("Job pricing record was null. Creating new pricing record");
			job.setPricingRecord(new PricingRecord());
		}
		
		PricingRecord pricingRecord = job.getPricingRecord();
		
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */

		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		
		if (copierDefinition == null) return job; /* No copierDefinition - not much to do from here*/
		
		double machineCost = copierDefinition.getMachineCostPerCopy();
		double pricePerCopy = machineCost*copierDefinition.getCopyMarkup();
		pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
		
		if (!pricingRecord.getTotalPriceOverride()) {
			pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
		}
		return job;
	}

}
