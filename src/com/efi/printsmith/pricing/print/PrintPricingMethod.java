package com.efi.printsmith.pricing.print;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.WasteChart;
import java.math.BigDecimal;

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
		BigDecimal pressSpeed;
		if (pressDefinition.getSpeedTable() != null) {
			pressSpeed = new BigDecimal(PriceListUtilities.getSpeedFromSpeedTable(pressDefinition.getSpeedTable(), job.getTotalImpositions()));
		}
		else
			pressSpeed = pressDefinition.getAvgImpressPerHour();
		
		float runHours = job.getTotalImpositions() / pressSpeed.longValue();
		float setupHours = pressDefinition.getSetupMin().floatValue() / 60;
		//float wasteHours = job.getEstWaste() / new Double(pressSpeed).floatValue();
		float totalHours = runHours + setupHours;
		float minimumHours = pressDefinition.getMinLabor().floatValue() / 60;
		if (totalHours < minimumHours)
			totalHours = minimumHours;
		if (job.getDoubleSided() == true)
			totalHours = totalHours * 2;
		pressPrice = totalHours * pressDefinition.getLaborRate().doubleValue() * pressDefinition.getLaborMarkup();
		stockPrice = (stockPrice * job.getImpositionsPerRun()) * job.getSheets();
		double price = pressPrice + stockPrice;
		pricingRecord.setTotalPrice(new Double(Math.round(price * 100)) / 100);
		
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
		long totalImpositions = job.getImpositionsPerRun() * (job.getFrontPasses() + job.getBackPasses()) * job.getSheets();
		job.setTotalImpositions(totalImpositions);
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
				double wastePct = PriceListUtilities.lookupPrice(wasteChart, job.getImpositionsPerRun());
				estWaste = (job.getImpositionsPerRun() * wastePct * (job.getFrontPasses() + job.getBackPasses()));
			}
			estWaste += fixedWaste;
			job.setEstWaste(new Double(estWaste).longValue());
		}
	}
}
