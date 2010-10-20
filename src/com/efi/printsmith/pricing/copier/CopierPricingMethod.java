package com.efi.printsmith.pricing.copier;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.pricing.utilities.JobUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public abstract class CopierPricingMethod {
	public Job priceCopierJob(Job job) {
		calculateTotalCopies(job);
		calculateStockQty(job);
//		JobUtilities.calculateSignatures(job);
//		calculateCopierJobWeight(job);
		return job;
	}
	
	private void calculateTotalCopies(Job job) {
		long totalCopies = job.getQtyOrdered() * job.getInSetsOf() * job.getSheets();
		long sheets = job.getSheets();
		long numUp = job.getNumUp();
		long numOn = job.getNumOn();
		if (sheets == 0)
			sheets = 1;
		if (numUp == 0)
			numUp = 1;
		if (numOn == 0)
			numOn = 1;
		double temp = sheets / (numUp / numOn);
		long calcQty = 0;
		if (temp < 1)
			calcQty = 1;
		else
			calcQty = (long)temp;
		job.setNumCopies(totalCopies / calcQty);
		calculateEstWaste(job);
		long wasteSheets = job.getBinderyWaste() + job.getEstWaste();
		wasteSheets *= job.getSheets();	
		job.setTotalCopies(totalCopies / (numUp / numOn) + (wasteSheets * (numUp / numOn)));
		if (job.getDoubleSided()) {
			job.setTotalCopies(job.getTotalCopies() * 2);
		}
	}
	
	private void calculateEstWaste(Job job) {
		CopierDefinition copierDefinition = job.getPricingCopier();
		if (copierDefinition != null) {
			double estWaste = 0.0;
			WasteChart wasteChart = copierDefinition.getWasteChart();
			if (wasteChart != null) {
				double wastePct = PriceListUtilities.lookupPrice(wasteChart, job.getNumCopies());
				estWaste = (job.getNumCopies() * wastePct);
			}
			job.setEstWaste(new Double(estWaste).longValue());
		}
	}
	
	private void calculateStockQty(Job job) {
	}
		
	private void calculateCopierJobWeight(Job job) {
		StockDefinition stockDefinition = job.getStock();
		
		if (stockDefinition != null) {
			double weight = stockDefinition.getMweight();
			
			job.setWeight(job.getNumCopies()*weight/1000);
		}
	}
	
	private void calculateCopierRuntime(Job job) {
		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (copierDefinition == null) return;
		
		double runTime = 0.0;

		if (job.getDoubleSided()) {
			
		}
	}
	
}
