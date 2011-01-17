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
			if (pricingMethod.getTitle().equals("Printing") || pricingMethod.getTitle().equals("List")) {
				if (job.getPaperCal().getRunout() == 0)
					qty = job.getTotalImpressions();
				else
					qty = job.getTotalImpressions() / job.getPaperCal().getRunout();
			} else { if (pricingMethod.getTitle().equals("Blank")) {
				qty = job.getQtyOrdered();
			} else if (job.getPricingMethod().getMethod().equals("Large Format")) {
				try {
					if (job.getPricingCopier().getSquareAreaType() == "AreaFinishSize")
						qty = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
					else
						if (job.getStock() != null && job.getStock().getStockunit() == 4)
							qty = PriceListUtilities.getAreaFromSizeString(job.getRunSize());
						else
							qty = new Double(Double.parseDouble(job.getParentSize()
									.getName())
									* job.getCutOff()).longValue();
				}
				catch (Exception e) {
					
				}
				if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
					qty = qty * job.getTotalCopies();
				} else if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndOriginals.name())) {
					qty = qty * job.getQtyOrdered() * job.getSheets();
				} else if (job.getPricingCopier().getMethod().equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.TotalSquareArea.name())) {
					qty = qty * job.getQtyOrdered() * job.getSheets();
				}
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