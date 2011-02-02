package com.efi.printsmith.pricing.print;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.stock.StockCostEngine;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.pricing.utilities.JobUtilities;
import java.math.BigDecimal;

public class PrintPricingMethod {
	public Job pricePrintJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		//calculatePressQty(job);
		JobUtilities.calculateSignatures(job);
		calculateImpressionsPerRun(job);
		calculateTotalImpressions(job);
		
		PressDefinition pressDefinition = job.getPricingPress();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		StockCostEngine stockCost = new StockCostEngine();
		double stockPrice = 0.0;
		if (job.getPricingMethod().getTitle().equals("Printing")) {
			job = stockCost.calculateStockCost(job);
			stockPrice = priceStockEngine.priceStock(job);
		}
		double pressPrice = 0.0;
		BigDecimal pressSpeed;
		if (job.getCopyMinutesOverride()) {
			pressSpeed = new BigDecimal(job.getCopyMinutes());
		} else {
			if (pressDefinition.getSpeedTable() != null) {
				pressSpeed = new BigDecimal(PriceListUtilities.getSpeedFromSpeedTable(pressDefinition.getSpeedTable(), job.getTotalImpressions()));
				job.getPricingPress().setAvgImpressPerHour(pressSpeed);
			}
			else
				pressSpeed = pressDefinition.getAvgImpressPerHour();
		}
		job.setCopyMinutes(pressSpeed.doubleValue());
		double runHours = 0.0;
		if (job.getOrRuntime())
			runHours = job.getRunTime();
		else {
			if (pressSpeed.doubleValue() > 0)
				runHours = job.getTotalImpressions() / pressSpeed.doubleValue();
			job.setRunTime(runHours);
		}
		Double setupHours = 0.0;
		if (job.getOrSetupTime())
			setupHours = job.getSetupTime();
		else {
			setupHours = (pressDefinition.getSetupMin().doubleValue() / 60) * job.getSheets();
			job.setSetupTime(setupHours);
		}
		Double washupHours = 0.0;
		if (job.getFrontWashes() + job.getBackWashes() > 0) {
			Double washupMinutes = (pressDefinition.getWashupMin() + pressDefinition.getWashupPerFountain().doubleValue()) * (job.getFrontWashes() + job.getBackWashes());
			washupHours = washupMinutes / 60;
			job.setWashupTime(washupMinutes);
		}
		float totalHours = (float) (runHours + setupHours + washupHours);
		float minimumHours = pressDefinition.getMinLabor().floatValue() / 60;
		if (totalHours < minimumHours)
			totalHours = minimumHours;
		if (job.getDoubleSided() == true)
			totalHours = totalHours * 2;
		job = calculatePressCost(job);
		BigDecimal laborRate;
		double laborMarkup;
		if (pricingRecord.getLaborRateOverride())
			laborRate = pricingRecord.getLaborRate();
		else
			laborRate = pressDefinition.getLaborRate();
		if (pricingRecord.getLaborMarkupOverride())
			laborMarkup = pricingRecord.getLaborMarkup();
		else
			laborMarkup = pressDefinition.getLaborMarkup();
		pressPrice = totalHours * laborRate.doubleValue() * laborMarkup;
		stockPrice = (stockPrice * job.getImpressionsPerRun()) * job.getSheets();
		double price = pressPrice + stockPrice;
		pricingRecord.setLaborRate(laborRate);
		pricingRecord.setLaborMarkup(laborMarkup);
		pricingRecord.setTotalPrice(new Double(Math.round(price * 100)) / 100);
		pricingRecord.setStockTotalPrice(stockPrice);
		pricingRecord.setLaborTotalPrice(pressPrice);
		return job;
	}
	
	public Job calculatePressCost(Job job) {
		double totalHours = job.getSetupTime() + job.getRunTime() + job.getWashupTime();
		job.getPricingRecord().setLaborCost(totalHours * job.getPricingPress().getLaborRate().doubleValue());
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
		if (job.getEstWasteOverride())
			return;
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
