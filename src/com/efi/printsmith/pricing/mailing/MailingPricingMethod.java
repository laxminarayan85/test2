package com.efi.printsmith.pricing.mailing;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;

public class MailingPricingMethod {
	public Job priceMailingJob(Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		if (job.getQtyOrdered() > 0) {
			job.setTotalCost(job.getQtyOrdered() * job.getUnitCost().doubleValue());
			pricingRecord.setTotalPrice(job.getTotalCost().doubleValue() * job.getMarkup());
		}
		
		return job;
	}
}