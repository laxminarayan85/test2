package com.efi.printsmith.pricing.copier;

import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.comparator.MatrixElementComparator;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;

import edu.emory.mathcs.backport.java.util.Collections;

public class CopiesPlusOriginalsPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPlusOriginalsPricingMethod.class);

	@Override
	public Job priceCopierJob(Job job) throws Exception {
		log.info("Start priceCopierJob for job " + job.getId());

		super.priceCopierJob(job);
		PricingRecord pricingRecord = job.getPricingRecord();
		CopierDefinition pricingCopier = job.getPricingCopier();
		double stockTotalPrice = 0.0;
		double laborTotalPrice = 0.0;
		if (pricingCopier != null) {
			Matrix pricingMatrix = pricingCopier.getCopierMatrix();
			Collections.sort(pricingMatrix.getElements(), new MatrixElementComparator());
			String side2PricingMethod = pricingCopier.getPriceTwoSide();
			long calcQty = job.getSheets(); 
			PriceStockEngine priceStockEngine = new PriceStockEngine();
			double stockPrice = priceStockEngine.priceStock(job);
			if (pricingMatrix != null) {
				int i;
				for (i = 0; i < pricingMatrix.getElements().size(); i++) {
					if (pricingMatrix.getElements().get(i).getLastLine() == false && pricingMatrix.getElements().get(i).getQty() >= job.getNumCopies()) break;
				}
				//if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
				if (i >= pricingMatrix.getElements().size())
					i = i - 1;
				int j = 0;
//				for (j = 0; j < pricingMatrix.getHeaderValues().length; j++) {
//					if (pricingMatrix.getHeaderValues()[j] > job.getSheets()) break;
//				}
//				if (j > 0) j--;
				long originals = 0;
				if (job.getDoubleSided() && pricingCopier.getPriceTwoSide().equals(Price2Side.CountingAsMoreOriginals.name())) {
					originals = job.getSignatures() * 2;
				} else {
					originals = job.getSignatures();
				}
				if (pricingMatrix.getHeader1() >= originals) j = 0;
				else if (pricingMatrix.getHeader2() >= originals) j = 1;
				else if (pricingMatrix.getHeader3() >= originals) j = 2;
				else if (pricingMatrix.getHeader4() >= originals) j = 3;
				else if (pricingMatrix.getHeader5() >= originals) j = 4;
				else if (pricingMatrix.getHeader6() >= originals) j = 5;
				else if (pricingMatrix.getHeader7() >= originals) j = 6;
				else if (pricingMatrix.getHeader8() >= originals) j = 7;
				else if (pricingMatrix.getHeader9() >= originals) j = 8;
				else if (pricingMatrix.getHeader10() >= originals) j = 9;
				else j = 9;

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
					if (side2PricingMethod.equals(Price2Side.NotChangingPrice.name())) {
						/* Do nothing - the price is the same */
					} else if (side2PricingMethod.equals(Price2Side.UsingFirstSideRate.name())) {
						//unitPrice *= 2;
					} else if (side2PricingMethod.equals(Price2Side.UsingSecondSideRate.name())) {
						switch (j) {
						case (0):
							unitPrice = pricingMatrix.getElements().get(i).getPrice11().doubleValue();
							break;
						case (1):
							unitPrice = pricingMatrix.getElements().get(i).getPrice12().doubleValue();
							break;
						case (2):
							unitPrice = pricingMatrix.getElements().get(i).getPrice13().doubleValue();
							break;
						case (3):
							unitPrice = pricingMatrix.getElements().get(i).getPrice14().doubleValue();
							break;
						case (4):
							unitPrice = pricingMatrix.getElements().get(i).getPrice15().doubleValue();
							break;
						case (5):
							unitPrice = pricingMatrix.getElements().get(i).getPrice16().doubleValue();
							break;
						case (6):
							unitPrice = pricingMatrix.getElements().get(i).getPrice17().doubleValue();
							break;
						case (7):
							unitPrice = pricingMatrix.getElements().get(i).getPrice18().doubleValue();
							break;
						case (8):
							unitPrice = pricingMatrix.getElements().get(i).getPrice19().doubleValue();
							break;
						case (9):
							unitPrice = pricingMatrix.getElements().get(i).getPrice20().doubleValue();
							break;
						}
					} else if (side2PricingMethod.equals(Price2Side.CountingAsMoreOriginals.name())) {
						/* Note that we are completely overriding the unitPrice here instead of adding to it */
						/*for (; i < pricingMatrix.getElements().size(); i++) {
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
						}*/
					} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor.name())) {
						unitPrice = (unitPrice * pricingCopier.getSideTwoFactor()) / 2;
					}
				}
				double pricePerCopy = unitPrice;
				double wastePrice = 0.0;

				int runout = 1;
				if (pricingCopier.getStockPriceMethod().equals(StockPriceMethod.FromCopier1InStockDefinition.name()) == false && pricingCopier.getStockPriceMethod().equals(StockPriceMethod.FromCopier2InStockDefinition.name()) == false && pricingCopier.getStockPriceMethod().equals(StockPriceMethod.FromCopier3InStockDefinition.name()) == false && job.getPaperCal().getRunout() > 0)
					runout = job.getPaperCal().getRunout();
				if (job.getDoubleSided() && job.getPricingCopier().getPriceTwoSide().equals(Price2Side.UsingSideFactor.name())) {
					stockPrice = stockPrice * job.getPricingCopier().getSideTwoFactor();
				}
				if (!pricingRecord.getTotalPriceOverride()) {
					if (pricingCopier.getMatrixType().equals("CopyCost")) {
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
						wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
							} else
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * job.getTotalCopies());
						} else {
							stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
							laborTotalPrice = (pricePerCopy * job.getTotalCopies());			
						}
					} else if (pricingCopier.getMatrixType().equals("DiscountTable")) {
						double discountPct = unitPrice;
						
						pricePerCopy = pricingCopier.getBaseRate().doubleValue() * discountPct;
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
						stockPrice *= discountPct;
						wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
							} else {
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * job.getTotalCopies());
							}	
						} else {
							stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
							laborTotalPrice = (pricePerCopy * job.getTotalCopies());			
						}
					} else if (pricingCopier.getMatrixType().equals("StepTable")) {
						List<MatrixElement> elements = pricingMatrix.getElements();
						Collections.sort(elements, new MatrixElementComparator());
						double runningTotal = 0.0;
						long prevQty = 0;
						for (i = 0; i < elements.size(); i++) {
							MatrixElement element = elements.get(i);
							if (element.getLastLine() == false) {
								switch (j) {
								case (0):
									unitPrice = element.getPrice1().doubleValue();
									break;
								case (1):
									unitPrice = element.getPrice2().doubleValue();
									break;
								case (2):
									unitPrice = element.getPrice3().doubleValue();
									break;
								case (3):
									unitPrice = element.getPrice4().doubleValue();
									break;
								case (4):
									unitPrice = element.getPrice5().doubleValue();
									break;
								case (5):
									unitPrice = element.getPrice6().doubleValue();
									break;
								case (6):
									unitPrice = element.getPrice7().doubleValue();
									break;
								case (7):
									unitPrice = element.getPrice8().doubleValue();
									break;
								case (8):
									unitPrice = element.getPrice9().doubleValue();
									break;
								case (9):
									unitPrice = element.getPrice10().doubleValue();
									break;
								}
								if (element.getQty() < job.getNumCopies()) {
									runningTotal += (element.getQty()-prevQty) * unitPrice;
									prevQty = element.getQty();
								} else {
									runningTotal += (job.getNumCopies()-prevQty) * unitPrice;
									break;
								}
							}
						}
						pricePerCopy = (runningTotal/job.getNumCopies());
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
						if (job.getDoubleSided()) {
							for (i = 0; i < elements.size(); i++) {
								MatrixElement element = elements.get(i);
								if (element.getLastLine() == false) {
									switch (j) {
									case (0):
										unitPrice = element.getPrice11().doubleValue();
										break;
									case (1):
										unitPrice = element.getPrice12().doubleValue();
										break;
									case (2):
										unitPrice = element.getPrice13().doubleValue();
										break;
									case (3):
										unitPrice = element.getPrice14().doubleValue();
										break;
									case (4):
										unitPrice = element.getPrice15().doubleValue();
										break;
									case (5):
										unitPrice = element.getPrice16().doubleValue();
										break;
									case (6):
										unitPrice = element.getPrice17().doubleValue();
										break;
									case (7):
										unitPrice = element.getPrice18().doubleValue();
										break;
									case (8):
										unitPrice = element.getPrice19().doubleValue();
										break;
									case (9):
										unitPrice = element.getPrice20().doubleValue();
										break;
									}
									if (element.getQty() < job.getNumCopies()) {
										runningTotal += (element.getQty()-prevQty) * unitPrice;
										prevQty = element.getQty();
									} else {
										runningTotal += (job.getNumCopies()-prevQty) * unitPrice;
										break;
									}
								}
							}
							pricePerCopy = (runningTotal/job.getNumCopies());
							pricePerCopy *= pricingCopier.getCopyMarkup2();
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
							} else{
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * job.getTotalCopies());
							}
						} else {
							stockTotalPrice = ((stockPrice*job.getTotalCopies()/runout));
							laborTotalPrice = (pricePerCopy * job.getTotalCopies());				
						}
					} else if (pricingCopier.getMatrixType().equals("MarkupTable")) {
						double markup = unitPrice;
						
						pricePerCopy = pricingCopier.getMachineCostPerCopy().doubleValue() * markup;
						pricePerCopy *= pricingCopier.getCopyMarkup2();
						
						wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job.getSheets()) * pricePerCopy;
						if (job.getDoubleSided()) {
							if (pricingCopier.getPriceTwoSide().equals(Price2Side.NotChangingPrice.name())) {
								stockTotalPrice = (stockPrice*((job.getTotalCopies()/2)/runout));
								laborTotalPrice = (pricePerCopy * (job.getTotalCopies() / 2));
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
			}
			
		}
		pricingRecord.setTotalPrice(laborTotalPrice + stockTotalPrice);
		pricingRecord.setStockTotalPrice(stockTotalPrice);
		pricingRecord.setLaborTotalPrice(laborTotalPrice);
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		else
			pricingRecord.setUnitPrice(pricingRecord.getTotalPrice().doubleValue() / job.getTotalCopies());
		return job;
	}
}
