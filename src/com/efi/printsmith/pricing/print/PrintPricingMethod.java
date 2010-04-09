package com.efi.printsmith.pricing.print;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.pricing.stock.PriceStockEngine;

public class PrintPricingMethod {
	public Job pricePrintJob(Job job) {
		calculatePressQty(job);
		calculateImpositionsPerRun(job);
		calculateTotalImpositions(job);
		
		PressDefinition pressDefinition = job.getPricingPress();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		
		
		
		return job;
	}
	
	private void calculatePressQty(Job job) {
		long pressQty = job.getQtyOrdered() * job.getInSetsOf();
		job.setPressQty(pressQty);
	}
	
	private void calculateImpositionsPerRun(Job job) {
		long impositionsPerRun = job.getPressQty() + job.getBinderyWaste() + job.getEstWaste();
	}
	
	private void calculateTotalImpositions(Job job) {
		long totalImpositions = (job.getFrontPasses() + job.getBackPasses());
	}
}
