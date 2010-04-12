package com.efi.printsmith.pricing.print;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.WasteChart;

public class PrintPricingMethod {
	public Job pricePrintJob(Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		calculatePressQty(job);
		calculateImpositionsPerRun(job);
		calculateTotalImpositions(job);
		
		PressDefinition pressDefinition = job.getPricingPress();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		double pressPrice = 0.0;
		if (!pricingRecord.getTotalPriceOverride()) {
			PriceList pressPriceList = pressDefinition.getPressPriceList();
			if (pressPriceList != null)
				pressPrice = PriceListUtilities.lookupPrice(pressPriceList, job.getTotalImpositions());
		}
		
		pricingRecord.setTotalPrice(pressPrice + stockPrice);
		
		return job;
	}
	
	private void calculatePressQty(Job job) {
		long pressQty = job.getQtyOrdered() * job.getInSetsOf();
		job.setPressQty(pressQty);
	}
	
	private void calculateImpositionsPerRun(Job job) {
		long impositionsPerRun = job.getPressQty();
 		job.setImpositionsPerRun(impositionsPerRun);
 		calculateEstWaste(job);
 		job.setImpositionsPerRun(job.getImpositionsPerRun() + job.getEstWaste());
	}
	
	private void calculateTotalImpositions(Job job) {
		long totalImpositions = job.getImpositionsPerRun() * (job.getFrontPasses() + job.getBackPasses());
		job.setTotalImpositions(totalImpositions);
	}
	
	private void calculateEstWaste(Job job) {
		PressDefinition pressDefinition = job.getPricingPress();
		if (pressDefinition != null) {
			double estWaste = 0.0;
			double fixedWaste = pressDefinition.getFixedWaste() * (job.getFrontPasses() + job.getBackPasses());
			double setupMin = pressDefinition.getSetupMin() * (job.getFrontPasses() + job.getBackPasses());
			long setupAddlRun = pressDefinition.getSetupAddRun() * (job.getFrontPasses() + job.getBackPasses());
			WasteChart wasteChart = pressDefinition.getWasteChart();
			if (wasteChart != null) {
				double wastePct = PriceListUtilities.lookupPrice(wasteChart, ((new Double(fixedWaste).longValue() + new Double(setupMin).longValue() + setupAddlRun) * (job.getFrontPasses() + job.getBackPasses())));
				estWaste = (job.getImpositionsPerRun() * wastePct * (job.getFrontPasses() + job.getBackPasses()));
			}
			estWaste += fixedWaste;
			job.setEstWaste(new Double(estWaste).longValue());
		}
	}
}
