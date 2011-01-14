package com.efi.printsmith.pricing.list;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.data.enums.PriceScheduleMethod;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;

public class ListPricingMethod {
	public Job priceListJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		double price = 0.0;
		PaperPrice paperPrice = job.getStock().getDefaultPriceList();
		
		if (paperPrice != null) {
			long qty = 0;
			if (paperPrice.getMethod().equals(PriceScheduleMethod.UseOrderedQuantity.name()))
				qty = job.getQtyOrdered();
			else if (paperPrice.getMethod().equals(PriceScheduleMethod.UseOrderedQuantityPerSheet.name()))
				qty = job.getSignatures();
			else if (paperPrice.getMethod().equals(PriceScheduleMethod.UsePressSheets.name()))
				qty = job.getPressQty();
			else if (paperPrice.getMethod().equals(PriceScheduleMethod.UseSheetsAndBinderyWaste.name()))
				qty = job.getPressQty() + job.getBinderyWaste();
			if (paperPrice.getType() == 1) {
				if (job.getFrontColors() > 0)
					price += MatrixUtilities.getPaperPrice((Matrix)job.getStock().getDefaultPriceList(), job.getFrontColors(), qty, true);
				if (job.getBackColors() > 0)
					price += MatrixUtilities.getPaperPrice((Matrix)job.getStock().getDefaultPriceList(), job.getBackColors(), qty, false);
			} else {
				price += MatrixUtilities.getPassPrice((Matrix)paperPrice, job.getFrontColors() + job.getBackColors(), qty);
			}
			job.getPricingRecord().setTotalPrice(price);
			job.getPricingRecord().setLaborTotalPrice(price);
			if (job.getPricingRecord().getTotalPrice().doubleValue() > 0)
				job.getPricingRecord().setUnitPrice(price / job.getTotalImpressions());
			else
				job.getPricingRecord().setUnitPrice(0.0);
		}
		return job;
	}
}