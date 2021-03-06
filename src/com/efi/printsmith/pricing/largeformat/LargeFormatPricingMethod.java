package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.pricing.copier.CopierPricingMethod;

public abstract class LargeFormatPricingMethod extends CopierPricingMethod {
	public Job priceLargeFormatJob(Job job) throws Exception {
		job = super.priceCopierJob(job);
		
		return job;
	}
}
