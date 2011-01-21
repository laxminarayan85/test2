package com.efi.printsmith.pricing.linesandinches;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.StampSchedule;

public class LinesAndInchesPricingMethod {
	public Job priceLinesAndInchesJob(Job job) throws Exception{
		PricingRecord pricingRecord = job.getPricingRecord();
		DataService dataService = new DataService();
		double cost = MatrixUtilities.getStampScheduleCost((StampSchedule)dataService.getStampSchedule(), job.getNumberOfInches(), job.getNumberOfLines());
		if (job.getOrStockCost() == false) {
			job.setTotalCost(cost);
		} else
			cost = job.getTotalCost().doubleValue();
		double price = cost * job.getQtyOrdered();
		if (job.getPricingRecord().getTotalPriceOverride() == false) {
			job.getPricingRecord().setTotalPrice(price);
		}
		job.getPricingRecord().setStockCost(job.getPricingRecord().getTotalPrice());
		job.getPricingRecord().setStockTotalPrice(job.getPricingRecord().getTotalPrice());
		return job;
	}
}