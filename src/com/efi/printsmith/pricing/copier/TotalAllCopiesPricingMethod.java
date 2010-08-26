package com.efi.printsmith.pricing.copier;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;

public class TotalAllCopiesPricingMethod extends CopierPricingMethod {

	public Job priceCopierJob(Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */

		super.priceCopierJob(job);
		CopierDefinition copierDefinition = job.getPricingCopier();

		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);

		MatrixElement matrixElement = null;
		long lookupQty = 0;
		if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
			lookupQty = job.getPressQty()*2;
		} else {
			lookupQty = job.getPressQty();
		}
		matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), lookupQty);

		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					pricePerCopy = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					pricePerCopy = matrixElement.getPrice1().doubleValue();
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());					
					} else {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					discountPct = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					discountPct = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());
					} else {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), job.getPressQty()*2);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), job.getPressQty());
				}
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());
					} else {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					markup = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					markup = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;
				
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies());
					} else {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
				}
			}
		}
		return job;
	}
}
