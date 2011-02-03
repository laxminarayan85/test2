package com.efi.printsmith.pricing.list;

import java.util.List;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.data.enums.PriceScheduleMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.stock.StockCostEngine;
import com.efi.printsmith.pricing.utilities.JobUtilities;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.service.DataService;

public class ListPricingMethod {
	@SuppressWarnings("unchecked")
	public Job priceListJob(Job job) throws Exception {
		DataService dataService = new DataService();
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		
		JobUtilities.calculateSignatures(job);
		calculateImpressionsPerRun(job);
		calculateTotalImpressions(job);
		
		double price = 0.0;
		if (job.getStock() != null) {
			PaperPrice paperPrice = job.getStock().getDefaultPriceList();
			if (paperPrice == null) {
				List <PaperPrice> paperPrices = (List<PaperPrice>) dataService.getAll("PaperPrice");
				if (paperPrices.size()>0)
					paperPrice = paperPrices.get(0);
				else
					return job;
			}
			PriceStockEngine priceStockEngine = new PriceStockEngine();
			StockCostEngine stockCost = new StockCostEngine();
			job = stockCost.calculateStockCost(job);
			double stockPrice = priceStockEngine.priceStock(job);
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
				stockPrice = (stockPrice * job.getImpressionsPerRun()) * job.getSheets();
				job.getPricingRecord().setTotalPrice(price + stockPrice);
				job.getPricingRecord().setLaborTotalPrice(price);
				job.getPricingRecord().setStockTotalPrice(stockPrice);
				if (job.getPricingRecord().getTotalPrice().doubleValue() > 0 && job.getTotalImpressions() > 0)
					job.getPricingRecord().setUnitPrice(price / job.getTotalImpressions());
				else
					job.getPricingRecord().setUnitPrice(0.0);
			}
		}
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