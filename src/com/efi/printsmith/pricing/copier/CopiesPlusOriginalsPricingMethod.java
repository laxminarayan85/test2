package com.efi.printsmith.pricing.copier;

import java.util.Date;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;
import com.efi.printsmith.service.PricingService;

public class CopiesPlusOriginalsPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPlusOriginalsPricingMethod.class);

	public Job priceCopierJob(Job job) {
		log.info("Start priceCopierJob for job " + job.getId());

		super.priceCopierJob(job);
		PricingRecord pricingRecord = job.getPricingRecord();
		CopierDefinition pricingCopier = job.getPricingCopier();
		if (pricingCopier != null) {
			Matrix pricingMatrix = pricingCopier.getCopierMatrix();
			String side2PricingMethod = pricingCopier.getPriceTwoSide();
			long calcQty = job.getSheets(); 
			PriceStockEngine priceStockEngine = new PriceStockEngine();
			double stockPrice = priceStockEngine.priceStock(job);
			if (pricingMatrix != null) {
				int i;
				for (i = 0; i < pricingMatrix.getElements().size(); i++) {
					if (pricingMatrix.getElements().get(i).getQty() >= job.getNumCopies()) break;
				}
				//if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
				if (i >= pricingMatrix.getElements().size())
					i = i - 1;
				int j = 0;
//				for (j = 0; j < pricingMatrix.getHeaderValues().length; j++) {
//					if (pricingMatrix.getHeaderValues()[j] > job.getSheets()) break;
//				}
//				if (j > 0) j--;
				
				if (pricingMatrix.getHeader1() >= job.getSheets()) j = 0;
				else if (pricingMatrix.getHeader2() >= job.getSheets()) j = 1;
				else if (pricingMatrix.getHeader3() >= job.getSheets()) j = 2;
				else if (pricingMatrix.getHeader4() >= job.getSheets()) j = 3;
				else if (pricingMatrix.getHeader5() >= job.getSheets()) j = 4;
				else if (pricingMatrix.getHeader6() >= job.getSheets()) j = 5;
				else if (pricingMatrix.getHeader7() >= job.getSheets()) j = 6;
				else if (pricingMatrix.getHeader8() >= job.getSheets()) j = 7;
				else if (pricingMatrix.getHeader9() >= job.getSheets()) j = 8;
				else if (pricingMatrix.getHeader10() >= job.getSheets()) j = 9;

				double unitPrice = 0.0;
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
						unitPrice *= pricingCopier.getSideTwoFactor();
					}
				}
				double pricePerCopy = unitPrice;
				double pricePerSecondSide = unitPrice;
				double wastePrice = 0.0;
				if (!pricingRecord.getTotalPriceOverride()) {
					if (pricingCopier.getMatrixType().equals("CopyCost")) {
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
						wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies() + wastePrice);					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
								pricePerSecondSide = unitPrice;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
								pricePerSecondSide = (pricePerCopy*pricingCopier.getSideTwoFactor()) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + (pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
								pricingRecord.setTotalPrice(((pricePerCopy * job.getTotalCopies()) + (pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice) * 2);					
							} else {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
							}
						} else {
							pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies() + wastePrice);				
						}
					} else if (pricingCopier.getMatrixType().equals("DiscountTable")) {
						double discountPct = unitPrice;
						
						pricePerCopy = pricingCopier.getBaseRate().doubleValue() * discountPct;
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
								pricePerSecondSide = unitPrice;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);						
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
								pricePerSecondSide = (pricePerCopy*pricingCopier.getSideTwoFactor()) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + (pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
							} else {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
							}
						} else {
							pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
						}
					} else if (pricingCopier.getMatrixType().equals("StepTable")) {
						
						pricingRecord.setUnitPrice(unitPrice + stockPrice);
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
								pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
								pricePerSecondSide = unitPrice;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);						
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
								pricePerSecondSide = (pricePerCopy*pricingCopier.getSideTwoFactor()) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + (pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
							} else {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
							}
						} else {
							pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
						}
					} else if (pricingCopier.getMatrixType().equals("MarkupTable")) {
						double markup = unitPrice;
						
						pricePerCopy = pricingCopier.getMachineCostPerCopy().doubleValue() * markup;
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								pricePerSecondSide = (pricePerCopy + stockPrice) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingFirstSideRate.name())) {
								pricingRecord.setTotalPrice((pricePerCopy * calcQty) + stockPrice*job.getTotalCopies());					
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSecondSideRate.name())) {
								pricePerSecondSide = unitPrice;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);						
							} else if (pricingCopier.getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
								pricePerSecondSide = (pricePerCopy*pricingCopier.getSideTwoFactor()) / 2;
								pricingRecord.setUnitPrice(pricePerSecondSide);
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + (pricePerSecondSide * job.getTotalCopies())+ stockPrice*job.getTotalCopies() + wastePrice);					
							} else {
								pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());
							}
						} else {
							pricingRecord.setTotalPrice((pricePerCopy * job.getTotalCopies()) + stockPrice*job.getTotalCopies());				
						}
					}
				}
			}
			
		}
		
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		return job;
	}
}
