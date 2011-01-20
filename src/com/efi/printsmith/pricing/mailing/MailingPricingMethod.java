package com.efi.printsmith.pricing.mailing;

import java.util.List;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.PreferencesMarkups;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.PreferencesPricingMethod;

public class MailingPricingMethod {
	public Job priceMailingJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		//if (job.getQtyOrdered() > 0) {
			job.setTotalCost(job.getQtyOrdered() * job.getUnitCost().doubleValue());
			double markup = getMarkup(job.getTotalCost().doubleValue(), job.getPricingMethod());
			job.setMarkup(markup);
			pricingRecord.setTotalPrice(job.getTotalCost().doubleValue() * markup);
			pricingRecord.setStockCost(job.getTotalCost());
			pricingRecord.setStockTotalPrice(job.getTotalCost());
		//}
		
		return job;
	}
	
	@SuppressWarnings("unchecked")
	private double getMarkup(double cost, PreferencesPricingMethod pricingMethod) throws Exception {
		double retVal = 1.0;
		DataService dataService = new DataService();
		List <PreferencesMarkups> markups = null;
		if (pricingMethod.getTitle().equals("Mailing") || pricingMethod.getTitle().equals("Outside Services")) {
			markups = (List<PreferencesMarkups>)dataService.getAll("OutsideService");
		} else {
			markups = (List<PreferencesMarkups>)dataService.getAll("Merchandise");
		}
		
		for (int i = 0; i < markups.size(); i ++) {
			if (markups.get(i).getAbove()) {
				retVal = markups.get(i).getMarkup();
				break;
			} else {
				if (cost <= markups.get(i).getTotalCost().doubleValue()) {
					retVal = markups.get(i).getMarkup();
					break;
				}
			}
		}
		
		return retVal;
	}
}