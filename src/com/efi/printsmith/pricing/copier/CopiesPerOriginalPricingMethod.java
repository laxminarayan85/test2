package com.efi.printsmith.pricing.copier;

import java.util.Date;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;
import com.efi.printsmith.service.PricingService;

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
	
	public Job priceCopierJob(Job job) {
		PricingRecord pricingRecord = job.getPricingRecord();
		
		if (pricingRecord.getTotalPriceOverride()) return job; /* User overrode price - leave it alone */

		super.priceCopierJob(job);
		CopierDefinition copierDefinition = job.getPricingCopier();

		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);

		MatrixElement matrixElement = null;
		
		if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
			MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), job.getSheets()*job.getInSetsOf()*2);
		} else {
			MatrixUtilities.lookupMatrixElement(job.getPricingCopier().getCopierMatrix(), job.getSheets()*job.getInSetsOf());			
		}

		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType() == "CopyCost") {
				pricePerCopy = matrixElement.getPrice1();
				pricePerCopy *= copierDefinition.getCopyMarkup();
			} else if (copierDefinition.getMatrixType() == "DiscountTable") {
				
			} else if (copierDefinition.getMatrixType() == "StepTable") {
				if (job.getDoubleSided() && copierDefinition.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), job.getSheets()*job.getInSetsOf()*2);
				} else {
					pricePerCopy = MatrixUtilities.calculateStepPriceSideOne(copierDefinition.getCopierMatrix(), job.getSheets()*job.getInSetsOf());
				}
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getSheets()*job.getInSetsOf()) + stockPrice*job.getTotalCopies());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * job.getSheets()*job.getInSetsOf()*2) + stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricePerSecondSide = matrixElement.getPrice2();
						pricingRecord.setTotalPrice((pricePerCopy * job.getSheets()*job.getInSetsOf()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * job.getSheets()*job.getInSetsOf()) + (pricePerSecondSide * job.getSheets()*job.getInSetsOf())+ stockPrice*job.getTotalCopies());					
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * job.getSheets()*job.getInSetsOf()) + stockPrice*job.getTotalCopies());				
				}
			}
		}
		return job;
	}
}
