package com.efi.printsmith.pricing.print;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.WasteChart;
import java.math.BigDecimal;

public class PrintPricingMethod {
	public Job pricePrintJob(Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		calculatePressQty(job);
		calculateImpressionsPerRun(job);
		calculateTotalImpressions(job);
		
		PressDefinition pressDefinition = job.getPricingPress();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		double pressPrice = 0.0;
		BigDecimal pressSpeed;
		if (pressDefinition.getSpeedTable() != null) {
			pressSpeed = new BigDecimal(PriceListUtilities.getSpeedFromSpeedTable(pressDefinition.getSpeedTable(), job.getTotalImpressions()));
			job.getPricingPress().setAvgImpressPerHour(pressSpeed);
		}
		else
			pressSpeed = pressDefinition.getAvgImpressPerHour();
		
		double runHours = job.getTotalImpressions() / pressSpeed.doubleValue();
		float setupHours = pressDefinition.getSetupMin().floatValue() / 60;
		//float wasteHours = job.getEstWaste() / new Double(pressSpeed).floatValue();
		float totalHours = (float) (runHours + setupHours);
		float minimumHours = pressDefinition.getMinLabor().floatValue() / 60;
		if (totalHours < minimumHours)
			totalHours = minimumHours;
		if (job.getDoubleSided() == true)
			totalHours = totalHours * 2;
		pressPrice = totalHours * pressDefinition.getLaborRate().doubleValue() * pressDefinition.getLaborMarkup();
		stockPrice = (stockPrice * job.getImpressionsPerRun()) * job.getSheets();
		double price = pressPrice + stockPrice;
		pricingRecord.setTotalPrice(new Double(Math.round(price * 100)) / 100);
		
		return job;
	}
	
	private void calculatePressQty(Job job) {
		long pressQty = job.getQtyOrdered() * job.getInSetsOf();
		job.setPressQty(pressQty);
	}
	
	private void calculateImpressionsPerRun(Job job) {
		long ImpressionsPerRun = job.getPressQty();
 		job.setImpressionsPerRun(ImpressionsPerRun);
 		calculateEstWaste(job);
 		job.setImpressionsPerRun(job.getImpressionsPerRun() + job.getEstWaste());
	}
	
	private void calculateTotalImpressions(Job job) {
		long totalImpressions = job.getImpressionsPerRun() * (job.getFrontPasses() + job.getBackPasses()) * job.getSheets();
		job.setTotalImpressions(totalImpressions);
	}
	
	private void calculateEstWaste(Job job) {
		PressDefinition pressDefinition = job.getPricingPress();
		if (pressDefinition != null) {
			double estWaste = 0.0;
			double fixedWaste = pressDefinition.getFixedWaste().doubleValue() * (job.getFrontPasses() + job.getBackPasses());
			double setupMin = pressDefinition.getSetupMin().doubleValue();
			long setupAddlRun = pressDefinition.getSetupAddRun() * (job.getFrontPasses() + job.getBackPasses());
			WasteChart wasteChart = pressDefinition.getWasteChart();
			if (wasteChart != null) {
				double wastePct = PriceListUtilities.lookupPrice(wasteChart, job.getImpressionsPerRun());
				estWaste = (job.getImpressionsPerRun() * wastePct * (job.getFrontPasses() + job.getBackPasses()));
			}
			estWaste += fixedWaste;
			job.setEstWaste(new Double(estWaste).longValue());
		}
	}
}
