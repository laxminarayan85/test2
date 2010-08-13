package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Matrix;
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
			if (copierDefinition.getSquareAreaType() == "AreaFinishSize")
				area = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
			else
				area = new Double(Double.parseDouble(job.getParentSize().getName()) * job.getCutOff()).longValue();
		}
		catch (Exception e) {
			
		}
		Matrix pricingMatrix = copierDefinition.getCopierMatrix();
		String side2PricingMethod = copierDefinition.getPriceTwoSide();
		double unitPrice = 0.0;
		if (pricingMatrix != null) {
			int i;
			for (i = 0; i < pricingMatrix.getElements().size(); i++) {
				if (pricingMatrix.getElements().get(i).getQty() > area) break;
			}
			if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
			
			int j = 0;
//			for (j = 0; j < pricingMatrix.getHeaderValues().length; j++) {
//				if (pricingMatrix.getHeaderValues()[j] > job.getSheets()) break;
//			}
//			if (j > 0) j--;
			
			if (pricingMatrix.getHeader1() >= job.getTotalCopies()) j = 0;
			else if (pricingMatrix.getHeader2() >= job.getTotalCopies()) j = 1;
			else if (pricingMatrix.getHeader3() >= job.getTotalCopies()) j = 2;
			else if (pricingMatrix.getHeader4() >= job.getTotalCopies()) j = 3;
			else if (pricingMatrix.getHeader5() >= job.getTotalCopies()) j = 4;
			else if (pricingMatrix.getHeader6() >= job.getTotalCopies()) j = 5;
			else if (pricingMatrix.getHeader7() >= job.getTotalCopies()) j = 6;
			else if (pricingMatrix.getHeader8() >= job.getTotalCopies()) j = 7;
			else if (pricingMatrix.getHeader9() >= job.getTotalCopies()) j = 8;
			else if (pricingMatrix.getHeader10() >= job.getTotalCopies()) j = 9;

			unitPrice = 0.0;
			switch (j) {
			case (0):
				unitPrice = pricingMatrix.getElements().get(i).getPrice1().doubleValue();
				break;
			case (1):
				unitPrice = pricingMatrix.getElements().get(i).getPrice2().doubleValue();
				break;
			case (2):
				unitPrice = pricingMatrix.getElements().get(i).getPrice3().doubleValue();
				break;
			case (3):
				unitPrice = pricingMatrix.getElements().get(i).getPrice4().doubleValue();
				break;
			case (4):
				unitPrice = pricingMatrix.getElements().get(i).getPrice5().doubleValue();
				break;
			case (5):
				unitPrice = pricingMatrix.getElements().get(i).getPrice6().doubleValue();
				break;
			case (6):
				unitPrice = pricingMatrix.getElements().get(i).getPrice7().doubleValue();
				break;
			case (7):
				unitPrice = pricingMatrix.getElements().get(i).getPrice8().doubleValue();
				break;
			case (8):
				unitPrice = pricingMatrix.getElements().get(i).getPrice9().doubleValue();
				break;
			case (9):
				unitPrice = pricingMatrix.getElements().get(i).getPrice10().doubleValue();
				break;
			}
			
			if (job.getDoubleSided()) {
				if (side2PricingMethod.equals(Price2Side.NotChangingPrice)) {
					/* Do nothing - the price is the same */
				} else if (side2PricingMethod.equals(Price2Side.UsingFirstSideRate)) {
					unitPrice *= 2;
				} else if (side2PricingMethod.equals(Price2Side.UsingSecondSideRate)) {
					switch (j) {
					case (0):
						unitPrice += pricingMatrix.getElements().get(i).getPrice11().doubleValue();
						break;
					case (1):
						unitPrice += pricingMatrix.getElements().get(i).getPrice12().doubleValue();
						break;
					case (2):
						unitPrice += pricingMatrix.getElements().get(i).getPrice13().doubleValue();
						break;
					case (3):
						unitPrice += pricingMatrix.getElements().get(i).getPrice14().doubleValue();
						break;
					case (4):
						unitPrice += pricingMatrix.getElements().get(i).getPrice15().doubleValue();
						break;
					case (5):
						unitPrice += pricingMatrix.getElements().get(i).getPrice16().doubleValue();
						break;
					case (6):
						unitPrice += pricingMatrix.getElements().get(i).getPrice17().doubleValue();
						break;
					case (7):
						unitPrice += pricingMatrix.getElements().get(i).getPrice18().doubleValue();
						break;
					case (8):
						unitPrice += pricingMatrix.getElements().get(i).getPrice19().doubleValue();
						break;
					case (9):
						unitPrice += pricingMatrix.getElements().get(i).getPrice20().doubleValue();
						break;
					}
				} else if (side2PricingMethod.equals(Price2Side.CountingAsMoreOriginals)) {
					/* Note that we are completely overriding the unitPrice here instead of adding to it */
					for (; i < pricingMatrix.getElements().size(); i++) {
						if (pricingMatrix.getElements().get(i).getQty() >= job.getQtyOrdered()) break;
					}
					if (i >0) i--;
					switch (j) {
					case (0):
						unitPrice = pricingMatrix.getElements().get(i).getPrice1().doubleValue();
						break;
					case (1):
						unitPrice = pricingMatrix.getElements().get(i).getPrice2().doubleValue();
						break;
					case (2):
						unitPrice = pricingMatrix.getElements().get(i).getPrice3().doubleValue();
						break;
					case (3):
						unitPrice = pricingMatrix.getElements().get(i).getPrice4().doubleValue();
						break;
					case (4):
						unitPrice = pricingMatrix.getElements().get(i).getPrice5().doubleValue();
						break;
					case (5):
						unitPrice = pricingMatrix.getElements().get(i).getPrice6().doubleValue();
						break;
					case (6):
						unitPrice = pricingMatrix.getElements().get(i).getPrice7().doubleValue();
						break;
					case (7):
						unitPrice = pricingMatrix.getElements().get(i).getPrice8().doubleValue();
						break;
					case (8):
						unitPrice = pricingMatrix.getElements().get(i).getPrice9().doubleValue();
						break;
					case (9):
						unitPrice = pricingMatrix.getElements().get(i).getPrice10().doubleValue();
						break;
					}
				} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor)) {
					unitPrice *= copierDefinition.getSideTwoFactor();
				}
			}
		}
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		area = area * job.getTotalCopies();
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						// Leave
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());				
				}
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * pricePerCopy;
				pricePerCopy *= copierDefinition.getCopyMarkup();
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						// Leave
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());				
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						// Leave
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());				
				}
			}else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				pricePerCopy = copierDefinition.getBaseRate().doubleValue() * pricePerCopy;
				pricingRecord.setUnitPrice(pricePerCopy);
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
						// Leave
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());					
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					} else if (copierDefinition.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
						pricePerSecondSide = pricePerCopy*copierDefinition.getSideTwoFactor();
						pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());
					}
				} else {
					pricingRecord.setTotalPrice((pricePerCopy * area) + stockPrice*job.getQtyOrdered());				
				}
			}
		}
		return job;
	}
}
