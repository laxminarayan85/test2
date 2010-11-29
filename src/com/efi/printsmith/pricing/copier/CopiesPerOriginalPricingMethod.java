package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;

public class CopiesPerOriginalPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPerOriginalPricingMethod.class);
	
	@Override
	public Job priceCopierJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */

		super.priceCopierJob(job);
		CopierDefinition copierDefinition = job.getPricingCopier();

		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);

		MatrixElement matrixElement = null;
		long lookupQty = 0;
		long calcQty = 0;
		//if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
		//	lookupQty = (job.getQtyOrdered() * job.getInSetsOf())*2;
		//} else {
			lookupQty = job.getNumCopies();
		//}
		calcQty = lookupQty * job.getSheets();
		matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), lookupQty);
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double wastePrice = 0.0;
		double stockTotalPrice = 0.0;
		double laborTotalPrice = 0.0;
		int runout = 1;
		if (copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier1InStockDefinition.name()) == false && copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier2InStockDefinition.name()) == false && copierDefinition.getStockPriceMethod().equals(StockPriceMethod.FromCopier3InStockDefinition.name()) == false && job.getPaperCal().getRunout() > 0)
			runout = job.getPaperCal().getRunout();
		if (copierDefinition.getMatrixType().equals("MarkupTable") == false && job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
			stockPrice = stockPrice * job.getPricingCopier().getSideTwoFactor();
		}
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					pricePerCopy = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					pricePerCopy = matrixElement.getPrice1().doubleValue();
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerCopy = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerCopy = matrixElement.getPrice2().doubleValue() * copierDefinition.getCopyMarkup2();
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					}
				} else {
					stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
					laborTotalPrice = (pricePerCopy * job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					discountPct = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					discountPct = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				
				double discountedStockPrice = stockPrice * discountPct;
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (discountedStockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerCopy = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						stockTotalPrice = (discountedStockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						discountPct = matrixElement.getPrice2().doubleValue();
						pricePerCopy = copierDefinition.getBaseRate().doubleValue() * discountPct * copierDefinition.getCopyMarkup2();
						discountedStockPrice = stockPrice * discountPct;
						stockTotalPrice = (discountedStockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else {
						stockTotalPrice = (discountedStockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					}
				} else {
					stockTotalPrice = ((discountedStockPrice*job.getTotalCopies()/runout));
					laborTotalPrice = (pricePerCopy * job.getTotalCopies());			
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), lookupQty);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), lookupQty);
				}
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerCopy = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
							pricePerCopy = MatrixUtilities.calculateStepPriceSideTwo(copierDefinition.getCopierMatrix(), job.getPressQty()*2);
						} else {
							pricePerCopy = MatrixUtilities.calculateStepPriceSideTwo(copierDefinition.getCopierMatrix(), job.getPressQty());
						}
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					}
				} else {
					stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
					laborTotalPrice = (pricePerCopy * job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					markup = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					markup = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getMachineCostPerCopy().doubleValue() * markup;
				
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerCopy = new Double(Math.round(((pricePerCopy*copierDefinition.getSideTwoFactor()) / 2) * 10000)) / 10000;
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						markup = matrixElement.getPrice2().doubleValue();
						pricePerCopy = copierDefinition.getMachineCostPerCopy().doubleValue() * markup * copierDefinition.getCopyMarkup2();
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					} else {
						stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
						laborTotalPrice = (pricePerCopy * job.getTotalCopies());
					}
				} else {
					stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
					laborTotalPrice = (pricePerCopy * job.getTotalCopies());				
				}
			}
		}
		pricingRecord.setTotalPrice(stockTotalPrice + laborTotalPrice);
		pricingRecord.setStockTotalPrice(stockTotalPrice);
		pricingRecord.setLaborTotalPrice(laborTotalPrice);
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		else
			pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
		return job;
	}
}
