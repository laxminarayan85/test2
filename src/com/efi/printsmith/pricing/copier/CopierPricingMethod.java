package com.efi.printsmith.pricing.copier;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;

public abstract class CopierPricingMethod {
	public Job priceCopierJob(Job job) {
		calculateTotalCopies(job);
		calculateStockQty(job);
		calculateSignatures(job);
		calculateCopierJobWeight(job);
		return job;
	}
	
	private void calculateTotalCopies(Job job) {
		long totalCopies = job.getQtyOrdered() * job.getInSetsOf() * job.getSheets();
		
		long wasteSheets = job.getBinderyWaste() + job.getEstWaste();
		wasteSheets *= job.getSheets();		
		
		job.setNumCopies(totalCopies);
		job.setTotalCopies(totalCopies+wasteSheets);
	}
	
	private void calculateStockQty(Job job) {
	}
	
	private void calculateSignatures(Job job) {
		long sheets = job.getSheets();  
		long up = job.getNumUp();
		long on = job.getNumOn();
		long runs = 0;
		long ordered = job.getQtyOrdered();
		if (up < 1) up = 1;
		if (sheets < 1) sheets = 1;
		if (on < 1) on = 1;
		if (on > up) on = up;
		
		if (sheets/on < 1) {
			runs = 1;
		} else {
			runs = sheets/on;
			
		}
		
		ordered *= job.getInSetsOf();
		
		long divisor = up/on;
		long press, tmpPress;
		long tmpRuns;

		if (sheets %on != 0) {
			long tmpSheets, tmpUp;
			
			tmpSheets = sheets - (runs*on);
			press = ordered / divisor;
			if ((press * divisor) < ordered)
				press++;
			tmpUp = up/tmpSheets;
			tmpPress = ordered/tmpUp;
			if ((tmpPress*tmpUp) < ordered)
				tmpPress++;
			if (press != 0) {
				tmpRuns = runs + (tmpPress/press); 
			} else {
				tmpRuns = runs;
			}
			runs++;
		} else {
			press = ordered/divisor;
			if (press *divisor < ordered) press++;
			tmpRuns = runs;
		}
		
		job.setSignatures(tmpRuns);
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
