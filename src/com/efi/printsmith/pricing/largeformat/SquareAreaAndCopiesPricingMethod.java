package com.efi.printsmith.pricing.largeformat;

import java.util.List;

import com.efi.printsmith.comparator.MatrixElementComparator;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

import edu.emory.mathcs.backport.java.util.Collections;

public class SquareAreaAndCopiesPricingMethod extends LargeFormatPricingMethod {
	@Override
	public Job priceLargeFormatJob(Job job) throws Exception {
		PricingRecord pricingRecord = job.getPricingRecord();
		if (pricingRecord.getTotalPriceOverride())
			return job; /* User overrode price - leave it alone */
		super.priceLargeFormatJob(job);
		CopierDefinition copierDefinition = job.getPricingCopier();
		PriceStockEngine priceStockEngine = new PriceStockEngine();
		double stockPrice = priceStockEngine.priceStock(job);
		long area = 0;
		double stockTotalPrice = 0.0;
		double laborTotalPrice = 0.0;
		try {
			if (copierDefinition.getSquareAreaType().equals("AreaFinishSize"))
				area = PriceListUtilities.getAreaFromSizeString(job
						.getFinishSize());
			else
				area = new Double(Double.parseDouble(job.getParentSize()
						.getName())
						* job.getCutOff()).longValue();
		} catch (Exception e) {

		}
		Matrix pricingMatrix = copierDefinition.getCopierMatrix();
		Collections.sort(pricingMatrix.getElements(), new MatrixElementComparator());
		String side2PricingMethod = copierDefinition.getPriceTwoSide();
		double unitPrice = 0.0;
		int i = 0;
		int lastLineIndex = -1;
		long lastQty = 0;
		double lastPrice = 0;
		int j = 0;
		if (pricingMatrix != null) {
			long originals = job.getNumCopies();

			if (pricingMatrix.getHeader1() >= originals)
				j = 0;
			else if (pricingMatrix.getHeader2() >= originals)
				j = 1;
			else if (pricingMatrix.getHeader3() >= originals)
				j = 2;
			else if (pricingMatrix.getHeader4() >= originals)
				j = 3;
			else if (pricingMatrix.getHeader5() >= originals)
				j = 4;
			else if (pricingMatrix.getHeader6() >= originals)
				j = 5;
			else if (pricingMatrix.getHeader7() >= originals)
				j = 6;
			else if (pricingMatrix.getHeader8() >= originals)
				j = 7;
			else if (pricingMatrix.getHeader9() >= originals)
				j = 8;
			else if (pricingMatrix.getHeader10() >= originals)
				j = 9;
			else
				j = 9;

			for (i = 0; i < pricingMatrix.getElements().size(); i++) {
				if (pricingMatrix.getElements().get(i).getLastLine())
					lastLineIndex = i;
				if (i > 0) {
					lastQty = pricingMatrix.getElements().get(i - 1).getQty();
					if (job.getDoubleSided()
							&& side2PricingMethod
									.equals(Price2Side.UsingSecondSideRate
											.name())) {
						switch (j) {
						case (0):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice11().doubleValue();
							break;
						case (1):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice12().doubleValue();
							break;
						case (2):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice13().doubleValue();
							break;
						case (3):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice14().doubleValue();
							break;
						case (4):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice15().doubleValue();
							break;
						case (5):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice16().doubleValue();
							break;
						case (6):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice17().doubleValue();
							break;
						case (7):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice18().doubleValue();
							break;
						case (8):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice19().doubleValue();
							break;
						case (9):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice20().doubleValue();
							break;
						}
					} else {
						switch (j) {
						case (0):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice1().doubleValue();
							break;
						case (1):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice2().doubleValue();
							break;
						case (2):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice3().doubleValue();
							break;
						case (3):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice4().doubleValue();
							break;
						case (4):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice5().doubleValue();
							break;
						case (5):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice6().doubleValue();
							break;
						case (6):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice7().doubleValue();
							break;
						case (7):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice8().doubleValue();
							break;
						case (8):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice9().doubleValue();
							break;
						case (9):
							lastPrice = pricingMatrix.getElements().get(i)
									.getPrice10().doubleValue();
							break;
						}
					}
				} else {
					lastQty = 0;
					lastPrice = 0.0;
				}
				if (pricingMatrix.getElements().get(i).getLastLine() == false
						&& pricingMatrix.getElements().get(i).getQty() >= area)
					break;
			}
			if (i >= pricingMatrix.getElements().size())
				i = lastLineIndex;

			unitPrice = 0.0;
			switch (j) {
			case (0):
				unitPrice = pricingMatrix.getElements().get(i).getPrice1()
						.doubleValue();
				break;
			case (1):
				unitPrice = pricingMatrix.getElements().get(i).getPrice2()
						.doubleValue();
				break;
			case (2):
				unitPrice = pricingMatrix.getElements().get(i).getPrice3()
						.doubleValue();
				break;
			case (3):
				unitPrice = pricingMatrix.getElements().get(i).getPrice4()
						.doubleValue();
				break;
			case (4):
				unitPrice = pricingMatrix.getElements().get(i).getPrice5()
						.doubleValue();
				break;
			case (5):
				unitPrice = pricingMatrix.getElements().get(i).getPrice6()
						.doubleValue();
				break;
			case (6):
				unitPrice = pricingMatrix.getElements().get(i).getPrice7()
						.doubleValue();
				break;
			case (7):
				unitPrice = pricingMatrix.getElements().get(i).getPrice8()
						.doubleValue();
				break;
			case (8):
				unitPrice = pricingMatrix.getElements().get(i).getPrice9()
						.doubleValue();
				break;
			case (9):
				unitPrice = pricingMatrix.getElements().get(i).getPrice10()
						.doubleValue();
				break;
			}

			if (job.getDoubleSided()) {
				if (side2PricingMethod.equals(Price2Side.NotChangingPrice)) {
					/* Do nothing - the price is the same */
				} else if (side2PricingMethod
						.equals(Price2Side.UsingFirstSideRate)) {
					// unitPrice *= 2;
				} else if (side2PricingMethod
						.equals(Price2Side.UsingSecondSideRate)) {
					switch (j) {
					case (0):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice11().doubleValue();
						break;
					case (1):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice12().doubleValue();
						break;
					case (2):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice13().doubleValue();
						break;
					case (3):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice14().doubleValue();
						break;
					case (4):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice15().doubleValue();
						break;
					case (5):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice16().doubleValue();
						break;
					case (6):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice17().doubleValue();
						break;
					case (7):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice18().doubleValue();
						break;
					case (8):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice19().doubleValue();
						break;
					case (9):
						unitPrice += pricingMatrix.getElements().get(i)
								.getPrice20().doubleValue();
						break;
					}
				} else if (side2PricingMethod
						.equals(Price2Side.CountingAsMoreOriginals)) {
					/*
					 * Note that we are completely overriding the unitPrice here
					 * instead of adding to it
					 */
					/*
					 * for (; i < pricingMatrix.getElements().size(); i++) { if
					 * (pricingMatrix.getElements().get(i).getQty() >=
					 * job.getQtyOrdered()) break; } if (i >0) i--; switch (j) {
					 * case (0): unitPrice =
					 * pricingMatrix.getElements().get(i).getPrice1
					 * ().doubleValue(); break; case (1): unitPrice =
					 * pricingMatrix
					 * .getElements().get(i).getPrice2().doubleValue(); break;
					 * case (2): unitPrice =
					 * pricingMatrix.getElements().get(i).getPrice3
					 * ().doubleValue(); break; case (3): unitPrice =
					 * pricingMatrix
					 * .getElements().get(i).getPrice4().doubleValue(); break;
					 * case (4): unitPrice =
					 * pricingMatrix.getElements().get(i).getPrice5
					 * ().doubleValue(); break; case (5): unitPrice =
					 * pricingMatrix
					 * .getElements().get(i).getPrice6().doubleValue(); break;
					 * case (6): unitPrice =
					 * pricingMatrix.getElements().get(i).getPrice7
					 * ().doubleValue(); break; case (7): unitPrice =
					 * pricingMatrix
					 * .getElements().get(i).getPrice8().doubleValue(); break;
					 * case (8): unitPrice =
					 * pricingMatrix.getElements().get(i).getPrice9
					 * ().doubleValue(); break; case (9): unitPrice =
					 * pricingMatrix
					 * .getElements().get(i).getPrice10().doubleValue(); break;
					 * }
					 */
				} else if (side2PricingMethod
						.equals(Price2Side.UsingSideFactor)) {
					unitPrice *= copierDefinition.getSideTwoFactor();
				}
			}
		}
		double pricePerCopy = unitPrice;
		double pricePerSecondSide = unitPrice;
		double wastePrice = 0.0;
		if (copierDefinition.getInterpolateMatrix()) {
			if (i >= pricingMatrix.getElements().size())
				i = i - 1;
			if (lastQty > 0
					&& i > 0
					&& pricingMatrix.getElements().get(i).getLastLine() != null
					&& pricingMatrix.getElements().get(i).getLastLine() == false) {
				long qtyRange = pricingMatrix.getElements().get(i).getQty()
						- lastQty;
				long lookupRange = job.getNumCopies() - lastQty;
				double priceRange = (pricingMatrix.getElements().get(i)
						.getPrice1().doubleValue() - lastPrice);
				if (qtyRange > 0)
					pricePerCopy = ((lookupRange * priceRange) / qtyRange) + lastPrice;
				else
					pricePerCopy = 0.0;
			}
		}

		int runout = 1;
		if (copierDefinition.getStockPriceMethod().equals(
				StockPriceMethod.FromCopier1InStockDefinition.name()) == false
				&& copierDefinition.getStockPriceMethod().equals(
						StockPriceMethod.FromCopier2InStockDefinition.name()) == false
				&& copierDefinition.getStockPriceMethod().equals(
						StockPriceMethod.FromCopier3InStockDefinition.name()) == false
				&& job.getPaperCal().getRunout() > 0)
			runout = job.getPaperCal().getRunout();
		if (job.getDoubleSided()
				&& copierDefinition.getMatrixType().equals("DiscountTable") == false
				&& job.getPricingCopier().getPriceTwoSide().equals(
						Price2Side.UsingSideFactor.name())) {
			stockPrice = stockPrice * job.getPricingCopier().getSideTwoFactor();
		}
		if (job.getDoubleSided()
				&& copierDefinition.getPriceTwoSide().equals(
						Price2Side.NotChangingPrice.name()))
			area = area * job.getNumCopies();
		else
			area = area * job.getTotalCopies();
		if (!pricingRecord.getTotalPriceOverride()) {
			if (copierDefinition.getMatrixType().equals("CopyCost")) {
				pricePerCopy *= copierDefinition.getCopyMarkup2();

				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job
						.getSheets())
						* pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(
							Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * (area / 2));
					} else {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else {
					stockTotalPrice = ((stockPrice * area / runout));
					laborTotalPrice = (pricePerCopy * area);
				}
			} else if (copierDefinition.getMatrixType().equals("DiscountTable")) {
				double discountPct = unitPrice;

				pricePerCopy = copierDefinition.getBaseRate().doubleValue()
						* discountPct;
				pricePerCopy *= copierDefinition.getCopyMarkup2();

				pricingRecord.setUnitPrice(pricePerCopy + stockPrice);
				stockPrice *= discountPct;
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job
						.getSheets())
						* pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(
							Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * (area / 2));
					} else if (side2PricingMethod
							.equals(Price2Side.UsingSideFactor.name())) {
						stockTotalPrice = (stockPrice * ((area) / runout));
						laborTotalPrice = (pricePerCopy * area);
					} else {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else {
					stockTotalPrice = ((stockPrice * area / runout));
					laborTotalPrice = (pricePerCopy * area);
				}
			} else if (copierDefinition.getMatrixType().equals("StepTable")) {
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
							runningTotal += (element.getQty() - prevQty)
									* unitPrice;
							prevQty = element.getQty();
						} else {
							runningTotal += (job.getNumCopies() - prevQty)
									* unitPrice;
							break;
						}
					}
				}
				if (job.getNumCopies() > 0)
					pricePerCopy = (runningTotal/job.getNumCopies());
				else
					pricePerCopy = 0.0;
				pricePerCopy *= copierDefinition.getCopyMarkup2();
				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job
						.getSheets())
						* pricePerCopy;
				prevQty = 0;
				runningTotal = 0;
				if (job.getDoubleSided()) {
					if (side2PricingMethod
							.equals(Price2Side.UsingSecondSideRate.name())) {
						for (i = 0; i < elements.size(); i++) {
							MatrixElement element = elements.get(i);
							if (element.getLastLine() == false) {
								switch (j) {
								case (0):
									unitPrice = element.getPrice11()
											.doubleValue();
									break;
								case (1):
									unitPrice = element.getPrice12()
											.doubleValue();
									break;
								case (2):
									unitPrice = element.getPrice13()
											.doubleValue();
									break;
								case (3):
									unitPrice = element.getPrice14()
											.doubleValue();
									break;
								case (4):
									unitPrice = element.getPrice15()
											.doubleValue();
									break;
								case (5):
									unitPrice = element.getPrice16()
											.doubleValue();
									break;
								case (6):
									unitPrice = element.getPrice17()
											.doubleValue();
									break;
								case (7):
									unitPrice = element.getPrice18()
											.doubleValue();
									break;
								case (8):
									unitPrice = element.getPrice19()
											.doubleValue();
									break;
								case (9):
									unitPrice = element.getPrice20()
											.doubleValue();
									break;
								}
								if (element.getQty() < job.getNumCopies()) {
									runningTotal += (element.getQty() - prevQty)
											* unitPrice;
									prevQty = element.getQty();
								} else {
									runningTotal += (job.getNumCopies() - prevQty)
											* unitPrice;
									break;
								}
							}
						}
						if (job.getNumCopies() > 0)
							pricePerCopy = (runningTotal/job.getNumCopies());
						else
							pricePerCopy = 0.0;
						pricePerCopy *= copierDefinition.getCopyMarkup2();
					}
					if (side2PricingMethod.equals(Price2Side.UsingSideFactor
							.name())) {
						pricePerCopy = (pricePerCopy * copierDefinition
								.getSideTwoFactor()) / 2;
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * (area));
					} else if (copierDefinition.getPriceTwoSide().equals(
							Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * (area / 2));
					} else {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else {
					stockTotalPrice = ((stockPrice * area / runout));
					laborTotalPrice = (pricePerCopy * area);
				}
			} else if (copierDefinition.getMatrixType().equals("MarkupTable")) {
				double markup = unitPrice;

				pricePerCopy = copierDefinition.getMachineCostPerCopy()
						.doubleValue()
						* markup;
				pricePerCopy *= copierDefinition.getCopyMarkup2();

				wastePrice = ((job.getBinderyWaste() + job.getEstWaste()) * job
						.getSheets())
						* pricePerCopy;
				if (job.getDoubleSided()) {
					if (copierDefinition.getPriceTwoSide().equals(
							Price2Side.NotChangingPrice.name())) {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * (area / 2));
					} else {
						stockTotalPrice = (stockPrice * ((area / 2) / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else {
					stockTotalPrice = ((stockPrice * area / runout));
					laborTotalPrice = (pricePerCopy * area);
				}
			}
		}
		pricingRecord.setTotalPrice(laborTotalPrice + stockTotalPrice);
		pricingRecord.setStockTotalPrice(stockTotalPrice);
		pricingRecord.setLaborTotalPrice(laborTotalPrice);
		if (pricingRecord.getTotalPrice().doubleValue() == 0)
			pricingRecord.setUnitPrice(0.0);
		else
			pricingRecord.setUnitPrice(pricingRecord.getTotalPrice()
					.doubleValue()
					/ job.getTotalCopies());
		return job;
	}
}
