package com.efi.printsmith.pricing.list;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ListPricingMethod {
	public Job priceListJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		double price = 0.0;
		
		if (job.getFrontColors() > 0)
			//price += PriceListUtilities.lookupPaperPrice(job.getStock().getDefaultPriceList(), job.getQtyOrdered(), job.getFrontColors(), 1);
		if (job.getBackColors() > 0)
			//price += PriceListUtilities.lookupPaperPrice(job.getStock().getDefaultPriceList(), job.getQtyOrdered(), job.getFrontColors(), 2);
		job.getPricingRecord().setTotalPrice(price);
		job.getPricingRecord().setLaborTotalPrice(price);
		if (job.getPricingRecord().getTotalPrice().doubleValue() > 0)
			job.getPricingRecord().setUnitPrice(price / job.getTotalImpressions());
		else
			job.getPricingRecord().setUnitPrice(0.0);
		return job;
	}
}