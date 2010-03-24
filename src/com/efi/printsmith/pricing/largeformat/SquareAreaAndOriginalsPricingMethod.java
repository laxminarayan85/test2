package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class SquareAreaAndOriginalsPricingMethod extends
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
				area = PriceListUtilities.getAreaFromSizeString(job.getRunSize());
		}
		catch (Exception e) {
			
		}
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), area * job.getQtyOrdered());
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
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getPressQty()) + stockPrice*job.getQtyOrdered());
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getPressQty()*2) + stockPrice*job.getQtyOrdered());					
						unitPrice = pricingRecord.getTotalPrice() / (job.getQtyOrdered() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getQtyOrdered());					
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getQtyOrdered());					
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getQtyOrdered());				
					unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
					pricingRecord.setUnitPrice(unitPrice);
				}
			} else if (copierDefinition.getMatrixIsDiscountTable()) {
				
			} else if (copierDefinition.getMatrixIsStepTable()) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area * job.getQtyOrdered()*2);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area * job.getQtyOrdered());
				}
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / (job.getQtyOrdered() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getTotalCopies());				
					unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
					pricingRecord.setUnitPrice(unitPrice);
				}
			}
		}
		return job;
	}
}
