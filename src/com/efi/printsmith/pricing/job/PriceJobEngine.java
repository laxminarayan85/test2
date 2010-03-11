package com.efi.printsmith.pricing.job;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.pricing.copier.CopierPricingMethod;
import com.efi.printsmith.pricing.copier.CopierPricingMethodFactory;

public class PriceJobEngine {
	static public Job priceJob(Job job) {
		PreferencesPricingMethod pricingMethod = job.getPricingMethod();
		
		/* TODO: Estimator types should be hard-coded in the system, not a table - come back and fix this once that is done so that we can compare them to constants instead of string literals */
		if (pricingMethod.getEstimator().getName().equals("Copier Definitions")) {
			CopierPricingMethod copierPricingMethod = CopierPricingMethodFactory.createCopierPricingMethod(job.getPricingMethod().getTitle());
			copierPricingMethod.priceCopierJob(job);
		} else if (pricingMethod.getEstimator().getName().equals("Press Definitions")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("Charges Only")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("Blank Stock")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("General Merchandise")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("Lines and Inches")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("List Price")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("Multiple Parts")) {
			
		} else if (pricingMethod.getEstimator().getName().equals("Outside Services")) {
			
		}
		return job;
	}
}
