package com.efi.printsmith.pricing.stock;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;

public class StockCostEngine {
	public Job calculateStockCost(Job job) {
		if (job != null) {
			PreferencesPricingMethod pricingMethod = job.getPricingMethod();
			long qty = 0;
			if (pricingMethod.getTitle().equals("Printing")) {
				
			} else { if (pricingMethod.getTitle().equals("Blank")) {
				
			} else
				if (job.getPaperCal().getRunout() == 0)
					qty = job.getTotalCopies();
				else
					qty = job.getTotalCopies() / job.getPaperCal().getRunout();
			}
			
			StockDefinition stockDefinition = job.getStock();
			if (stockDefinition != null) {
				double markup = 0.0;
				double stockCost = 0.0;
				if (qty > 0) {
					if (qty <= stockDefinition.getQtybreak1()) {
						markup = stockDefinition.getMarkup1();
						stockCost = stockDefinition.getCost1().doubleValue();
					} else if (qty <= stockDefinition.getQtybreak2()) {
						markup = stockDefinition.getMarkup2();
						stockCost = stockDefinition.getCost2().doubleValue();
					} else if (qty <= stockDefinition.getQtybreak3()) {
						markup = stockDefinition.getMarkup3();
						stockCost = stockDefinition.getCost3().doubleValue();
					} else if (qty <= stockDefinition.getQtybreak4()) {
						markup = stockDefinition.getMarkup4();
						stockCost = stockDefinition.getCost4().doubleValue();
					} else if (qty <= stockDefinition.getQtybreak5()) {
						markup = stockDefinition.getMarkup5();
						stockCost = stockDefinition.getCost5().doubleValue();
					} else if (qty <= stockDefinition.getQtybreak6()) {
						markup = stockDefinition.getMarkup6();
						stockCost = stockDefinition.getCost6().doubleValue();
					} else if (stockDefinition.getCost6().doubleValue() == 0) {
						markup = stockDefinition.getMarkup1();
						stockCost = stockDefinition.getCost1().doubleValue();
					}
					else{
						markup = stockDefinition.getMarkup6();
						stockCost = stockDefinition.getCost6().doubleValue();
					}
					if (job.getPricingCopier().getUseCopierStockMarkup()) {
						markup = job.getPricingCopier().getStockMarkup();
					}
				}
				if (job.getCostUnitsOverride() == false)
					job.setCostUnits(stockDefinition.getCostunits());
				if (job.getParentStockCostOverride() == false)
					job.setParentStockCost(stockCost);
				if (job.getOrStockMarkup() == false)
					job.getPricingRecord().setStockMarkup(markup);
				if (job.getCostUnits() > 0) {
					double costQty = qty / job.getCostUnits().doubleValue();
					job.getPricingRecord().setStockCost(costQty * job.getParentStockCost().doubleValue());
				}
			}
		}
		
		return job;
	}
}