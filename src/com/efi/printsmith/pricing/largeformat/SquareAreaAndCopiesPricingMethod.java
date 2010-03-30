package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class SquareAreaAndCopiesPricingMethod extends
		LargeFormatPricingMethod {
	public Job priceLargeFormatJob (Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */
		super.priceLargeFormatJob(job);
		CopierDefinition copierDefinition = job.getPricingCopier();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		long area = 0;
		try {
			if (copierDefinition.getSquareAreaFromFinish())
				area = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
			else
				area = new Double(Double.parseDouble(job.getParentSize()) * job.getCutOff()).longValue();
		}
		catch (Exception e) {
			
		}
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), area * job.getTotalCopies());
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double unitPrice = 0.0;
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixIsCopyCost()) {
				pricePerCopy = matrixElement.getPrice1();
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
					unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
					pricingRecord.setUnitPrice(unitPrice);
				}
			} else if (copierDefinition.getMatrixIsDiscountTable()) {
				
			} else if (copierDefinition.getMatrixIsStepTable()) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area * job.getPressQty()*2);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area * job.getPressQty());
				}
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
					unitPrice = pricingRecord.getTotalPrice() / job.getTotalCopies();
					pricingRecord.setUnitPrice(unitPrice);
				}
			}
		}
		return job;
	}
}
