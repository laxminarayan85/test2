package com.efi.printsmith.pricing.linesandinches;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.StampSchedule;

public class LinesAndInchesPricingMethod {
	public Job priceLinesAndInchesJob(Job job) throws Exception{
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		DataService dataService = new DataService();
		double cost = MatrixUtilities.getStampScheduleCost((StampSchedule)dataService.getStampSchedule(), job.getNumberOfInches(), job.getNumberOfLines());
		double price = cost * job.getQtyOrdered();
		job.setTotalCost(cost);
		job.getPricingRecord().setTotalPrice(price);
		return job;
	}
}