package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;

public class CostPlusPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CostPlusPricingMethod.class);
	@Override
	public Job priceCopierJob(Job job) throws Exception {
		super.priceCopierJob(job);

		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (job.getPricingRecord() == null) {
			log.error ("Job pricing record was null. Creating new pricing record");
			job.setPricingRecord(new PricingRecord());
		}
		
		PricingRecord pricingRecord = job.getPricingRecord();
		
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */

		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		
		if (copierDefinition == null) return job; /* No copierDefinition - not much to do from here*/
		
		double machineCost = copierDefinition.getMachineCostPerCopy().doubleValue();
		double pricePerCopy = machineCost*copierDefinition.getCopyMarkup();
		double pricePerSecondSide = 0.0;
		int runout = 1;
		if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier1InStockDefinition.name()) == false && copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier2InStockDefinition.name()) == false && copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier3InStockDefinition.name()) == false)
			runout = job.getPaperCal().getRunout();
		if (job.getDoubleSided()) {
			pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
			if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
				pricePerSecondSide = pricePerCopy;
				//pricingRecord.setUnitPrice(pricePerSecondSide / 2);
				if (!pricingRecord.getTotalPriceOverride()) {
					pricingRecord.setTotalPrice((pricePerSecondSide * (job.getTotalCopies() / 2))+ ((stockPrice*job.getTotalCopies()/runout) / 2));
					pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
				}
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
				pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*(job.getTotalCopies()/runout / 2));
				pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
			} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
				pricePerSecondSide = (pricePerCopy*copierDefinition.getSideTwoFactor()) / 2;
				//pricingRecord.setUnitPrice(pricePerSecondSide + stockPrice);
				pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ (stockPrice*copierDefinition.getSideTwoFactor()*((job.getTotalCopies()/2)/runout)));					
				pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
			} else {
				pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + ((stockPrice*job.getTotalCopies()/runout)));
				pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
			}
		} else {
			//pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
			
			if (!pricingRecord.getTotalPriceOverride()) {
				pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*(job.getTotalCopies() / runout));
				pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
			}
		}
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		return job;
	}

}
