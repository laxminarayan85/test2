package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;

public class CopiesPerOriginalPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPerOriginalPricingMethod.class);

//	public Job priceCopierJob(Job job) {
//		log.info("Start priceCopierJob for job " + job.getId());
//
//		super.priceCopierJob(job);
//		
//		CopierDefinition pricingCopier = job.getPricingCopier();
//		
//		if (pricingCopier != null) {
//			Matrix pricingMatrix = pricingCopier.getCopierMatrix();
//			String side2PricingMethod = pricingCopier.getPriceTwoSide();
//			if (pricingMatrix != null) {
//				int i;
//				for (i = 0; i < pricingMatrix.getElements().size(); i++) {
//					if (pricingMatrix.getElements().get(i).getQty() > job.getQtyOrdered()) break;
//				}
//				if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
//				double unitPrice = pricingMatrix.getElements().get(i).getPrice1();
//				
//				if (job.getDoubleSided()) {
//					if (side2PricingMethod.equals(Price2Side.NotChangingPrice)) {
//						/* Do nothing - the price is the same */
//					} else if (side2PricingMethod.equals(Price2Side.UsingFirstSideRate)) {
//						unitPrice *= 2;
//					} else if (side2PricingMethod.equals(Price2Side.UsingSecondSideRate)) {
//						unitPrice += pricingMatrix.getElements().get(i).getPrice2();
//					} else if (side2PricingMethod.equals(Price2Side.CountingAsMoreOriginals)) {
//						/* Note that we are completely overriding the unitPrice here instead of adding to it */
//						for (; i < pricingMatrix.getElements().size(); i++) {
//							if (pricingMatrix.getElements().get(i).getQty() >= job.getQtyOrdered()) break;
//						}
//						if (i >0) i--;
//						unitPrice = pricingMatrix.getElements().get(i).getPrice1();
//					} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor)) {
//						unitPrice *= pricingCopier.getSideTwoFactor();
//					}
//				}
//			}
//		}
//		
//		return job;
//	}
	
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
			lookupQty = (job.getQtyOrdered() * job.getInSetsOf());
		//}
		calcQty = lookupQty * job.getSheets();
		matrixElement = MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), lookupQty);
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double wastePrice = 0.0;
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				if (copierDefinition.getInterpolateMatrix() == true)
					pricePerCopy = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					pricePerCopy = matrixElement.getPrice1().doubleValue();
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerCopy * calcQty) + ((stockPrice*job.getTotalCopies()) / 2) + wastePrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice(((pricePerCopy * 2) * calcQty) + (stockPrice * 2) *(job.getTotalCopies() / 2));										
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue() * copierDefinition.getCopyMarkup2();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setUnitPrice(pricePerSecondSide + stockPrice);
						pricingRecord.setTotalPrice((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice);					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
						pricingRecord.setTotalPrice(((pricePerCopy * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice));					
					} else {
						pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies() + wastePrice);				
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
						pricingRecord.setTotalPrice((pricePerCopy * calcQty) + ((stockPrice*job.getTotalCopies()) / 2) + wastePrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice(((pricePerCopy * 2) * calcQty) + (stockPrice * 2) *job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue() * copierDefinition.getCopyMarkup2();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);
					}  else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setUnitPrice(pricePerSecondSide + stockPrice);
						pricingRecord.setTotalPrice((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice);					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
						pricingRecord.setTotalPrice(((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice));
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), lookupQty);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), lookupQty);
				}
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerCopy * calcQty) + ((stockPrice*job.getTotalCopies()) / 2) + wastePrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice(((pricePerCopy * 2) * calcQty) + (stockPrice * 2) *job.getTotalCopies());										
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
					}  else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setUnitPrice(pricePerSecondSide + stockPrice);
						pricingRecord.setTotalPrice((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice);					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
						pricingRecord.setTotalPrice(((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice));
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());				
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = 0.0;
				if (copierDefinition.getInterpolateMatrix() == true)
					markup = MatrixUtilities.calculateInterpolation(job.getPricingCopier().getCopierMatrix(), lookupQty);
				else
					markup = matrixElement.getPrice1().doubleValue();
				pricePerCopy = copierDefinition.getMachineCostPerCopy().doubleValue() * markup;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				
				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerCopy * calcQty) + ((stockPrice*job.getTotalCopies()) / 2) + wastePrice);
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice(((pricePerCopy * 2) * calcQty) + (stockPrice * 2) *job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2().doubleValue();
						pricingRecord.setUnitPrice(pricePerSecondSide);
						pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);				
					}  else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setUnitPrice(pricePerSecondSide + stockPrice);
						pricingRecord.setTotalPrice((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice);					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
						pricingRecord.setTotalPrice(((pricePerSecondSide * calcQty)+ stockPrice*job.getTotalCopies() + wastePrice));
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());				
				}
			}
		}
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		return job;
	}
}
