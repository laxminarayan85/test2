package com.efi.printsmith.pricing.blank;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.stock.StockCostEngine;

public class BlankPricingMethod {
	public Job priceBlankJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		if (job.getQtyOrdered() > 0) {
			PriceStockEngine priceStockEnging = new PriceStockEngine();
			StockCostEngine stockCost = new StockCostEngine();
			job = stockCost.calculateStockCost(job);
			double unitPrice = priceStockEnging.priceStock(job);
			double price = unitPrice * job.getQtyOrdered();
			job.getPricingRecord().setUnitPrice(unitPrice);
			job.getPricingRecord().setStockTotalPrice(price);
			job.getPricingRecord().setTotalPrice(price);
		}
		
		return job;
	}
}