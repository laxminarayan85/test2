package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.service.DataService;

public class TotalOfSquareAreaPricingMethod extends
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
			if (copierDefinition.getSquareAreaType() == "AreaFinishSize")
				area = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
			else
				area = new Double(Double.parseDouble(job.getParentSize().getName()) * job.getCutOff()).longValue();
		}
		catch (Exception e) {
			
		}
		area = area * job.getQtyOrdered();
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), area);
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double unitPrice = 0.0;
		
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					pricePerCopy = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), area);
				else
					pricePerCopy = matrixElement.getPrice1().doubleValue();
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*area);
					if (job.getTotalCopies() > 0)
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
					else
						unitPrice = 0.0;
					pricingRecord.setUnitPrice(unitPrice);
				}
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					discountPct = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), area);
				else
					discountPct = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
					if (job.getTotalCopies() > 0)
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
					else
						unitPrice = 0.0;
					pricingRecord.setUnitPrice(unitPrice);
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area * 2);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), area);
				}
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area*2) + stockPrice*job.getTotalCopies());	
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
					if (job.getTotalCopies() > 0)
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
					else
						unitPrice = 0.0;
					pricingRecord.setUnitPrice(unitPrice);
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					markup = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), area);
				else
					markup = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * markup;

				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area*2) + stockPrice*job.getTotalCopies());					
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / (job.getTotalCopies() * 2);
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
						pricingRecord.setUnitPrice(unitPrice);
						pricingRecord.setTotalPrice((pricePerCopy * area) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getTotalCopies());
					if (job.getTotalCopies() > 0)
						unitPrice = pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies();
					else
						unitPrice = 0.0;
					pricingRecord.setUnitPrice(unitPrice);
				}
			}				
		}
		return job;
	}
}
