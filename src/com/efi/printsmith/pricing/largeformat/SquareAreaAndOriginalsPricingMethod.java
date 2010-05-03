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
			if (copierDefinition.getSquareAreaType() == "AreaFinishSize")
				area = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
			else
				area = new Double(Double.parseDouble(job.getParentSize()) * job.getCutOff()).longValue();
		}
		catch (Exception e) {
			
		}
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), area);
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double unitPrice = 0.0;
		
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					pricePerCopy = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				else
					pricePerCopy = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getQtyOrdered());
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()*2) + stockPrice*job.getQtyOrdered());					
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
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					discountPct = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				else
					discountPct = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				pricePerCopy = copierDefinition.getBaseRate() * discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getQtyOrdered());
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()*2) + stockPrice*job.getQtyOrdered());					
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
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
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
			}else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					markup = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				else
					markup = MatrixUtilities.getCost(job.getPricingCopier().getCopierMatrix(), area, job.getQtyOrdered());
				pricePerCopy = copierDefinition.getBaseRate() * markup;
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()) + stockPrice*job.getQtyOrdered());
						unitPrice = pricingRecord.getTotalPrice() / job.getQtyOrdered();
						pricingRecord.setUnitPrice(unitPrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area * job.getQtyOrdered()*2) + stockPrice*job.getQtyOrdered());					
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
			}
		}
		return job;
	}
}
