package com.efi.printsmith.pricing.stock;

import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;

public class PriceStockEngine {
	public double priceStock(StockDefinition stockDefinition, long qty, PricingRecord pricingRecord) {
		double retVal = 0.0;
		if (stockDefinition != null) {
			if (stockDefinition.getCostunits() > 0) {
				PriceLogEntry parentEntry = pricingRecord.getPriceLogEntry();
				PriceLogEntry priceLogEntry = new PriceLogEntry();
				
				priceLogEntry.setDate(priceLogEntry.getDate());
				priceLogEntry.setMethod("PriceStock");
				if (qty <= stockDefinition.getQtybreak1()) {
					retVal = stockDefinition.getCost1()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup1();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost1() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				} else if (qty <= stockDefinition.getQtybreak2()) {
					retVal = stockDefinition.getCost2()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup2();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost2() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				} else if (qty <= stockDefinition.getQtybreak3()) {
					retVal = stockDefinition.getCost3()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup3();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost3() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				} else if (qty <= stockDefinition.getQtybreak4()) {
					retVal = stockDefinition.getCost4()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup4();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost4() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				} else if (qty <= stockDefinition.getQtybreak5()) {
					retVal = stockDefinition.getCost5()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup5();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost5() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				} else if (qty <= stockDefinition.getQtybreak6()) {
					retVal = stockDefinition.getCost6()/stockDefinition.getCostunits() * qty  * stockDefinition.getMarkup6();
					priceLogEntry.setDescription("Stock Price: Cost/CostUnits * Qty: " + stockDefinition.getCost6() + "/" +stockDefinition.getCostunits() + "*" + qty + "*" + stockDefinition.getMarkup6());
				}
				priceLogEntry.setValue(retVal);
				parentEntry.addChildren(priceLogEntry);
			}
		}
		return retVal;
	}
}
