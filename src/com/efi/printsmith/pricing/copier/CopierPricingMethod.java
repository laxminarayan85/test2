package com.efi.printsmith.pricing.copier;

import com.efi.printsmith.data.Job;

public interface CopierPricingMethod {
	abstract public Job priceCopierJob(Job job);
}
