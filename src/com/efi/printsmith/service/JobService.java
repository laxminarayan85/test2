package com.efi.printsmith.service;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.pricing.charge.ChargeUtilities;

public class JobService {
	protected static Logger log = Logger.getLogger(JobService.class);

	public JobService() {
		
	}
	
	public Job assignStockToJob(Job job, StockDefinition stock) {
		if (stock == null || job == null) {
			log.error("Stock or Job null value passed to assignStockToJob");
			return job;
		}
		
		job.setStock(stock);
		
		for (int i=0; i < stock.getCharges().size(); i++) {
			job.addCharges(ChargeUtilities.createChargeFromChargeDefinition(stock.getCharges().get(i)));
		}
		
		return job;
	}
	
	public Job assignPricingCopierToJob(Job job, CopierDefinition copier) {
		if (copier == null || job == null) {
			log.error("Copier or Job null value passed to assignPricingCopierToJob");
			return job;
		}
		
		job.setPricingCopier(copier);
		
		for (int i=0; i < copier.getCharges().size(); i++) {
			job.addCharges(ChargeUtilities.createChargeFromChargeDefinition(copier.getCharges().get(i)));
		}
		
		return job;		
	}
}
