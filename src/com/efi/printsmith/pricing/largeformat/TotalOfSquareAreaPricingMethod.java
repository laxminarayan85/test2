package com.efi.printsmith.pricing.largeformat;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.enums.Price2Side;
import com.efi.printsmith.data.enums.StockPriceMethod;
import com.efi.printsmith.pricing.stock.PriceStockEngine;
import com.efi.printsmith.pricing.utilities.MatrixUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class TotalOfSquareAreaPricingMethod extends LargeFormatPricingMethod {
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
		try {
			if (copierDefinition.getSquareAreaType().equals("AreaFinishSize"))
				area = PriceListUtilities.getAreaFromSizeString(job
						.getFinishSize());
			else
				area = new Double(job.getRollWidth() * job.getCutOff())
						.longValue();
		} catch (Exception e) {

		}
		area = area * job.getTotalCopies();
		MatrixElement matrixElement = MatrixUtilities.lookupMatrixElement(job
				.getPricingCopier().getCopierMatrix(), area);
		double pricePerCopy = 0.0;
		double pricePerSecondSide = 0.0;
		double unitPrice = 0.0;
		double stockTotalPrice = 0.0;
		double laborTotalPrice = 0.0;
		int runout = 1;
		if (copierDefinition.getStockPriceMethod().equals(
				StockPriceMethod.FromCopier1InStockDefinition.name()) == false
				&& copierDefinition.getStockPriceMethod().equals(
						StockPriceMethod.FromCopier2InStockDefinition.name()) == false
				&& copierDefinition.getStockPriceMethod().equals(
						StockPriceMethod.FromCopier3InStockDefinition.name()) == false
				&& job.getPaperCal().getRunout() > 0)
			runout = job.getPaperCal().getRunout();
		if (copierDefinition.getMatrixType().equals("MarkupTable") == false
				&& job.getDoubleSided()
				&& job.getPricingCopier().getPriceTwoSide().equals(
						Price2Side.UsingSideFactor.name())) {
			stockPrice = stockPrice * job.getPricingCopier().getSideTwoFactor();
			if (!pricingRecord.getTotalPriceOverride()) {
				if (copierDefinition.getMatrixType().equals("CopyCost")) {
					if (copierDefinition.getInterpolateMatrix() == true)
						pricePerCopy = MatrixUtilities.calculateInterpolation(
								job.getPricingCopier().getCopierMatrix(), area);
					else
						pricePerCopy = matrixElement.getPrice1().doubleValue();
					pricePerCopy *= copierDefinition.getCopyMarkup2();
					pricingRecord.setUnitPrice(pricePerCopy);
					if (job.getDoubleSided()) {
						if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.NotChangingPrice.name())) {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * (area / 2));
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSideFactor.name())) {
							pricePerCopy = new Double(Math
									.round(((pricePerCopy * copierDefinition
											.getSideTwoFactor()) / 2) * 10000)) / 10000;
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSecondSideRate.name())) {
							pricePerCopy = matrixElement.getPrice2()
									.doubleValue()
									* copierDefinition.getCopyMarkup2();
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						}
					} else {
						stockTotalPrice = ((stockPrice * area / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else if (copierDefinition.getMatrixType().equals(
						"DiscountTable")) {
					double discountPct = 0.0;
					if (copierDefinition.getInterpolateMatrix() == true)
						discountPct = MatrixUtilities.calculateInterpolation(
								job.getPricingCopier().getCopierMatrix(), area);
					else
						discountPct = matrixElement.getPrice1().doubleValue();
					pricePerCopy = copierDefinition.getBaseRate().doubleValue()
							* discountPct;
					pricePerCopy *= copierDefinition.getCopyMarkup2();
					pricingRecord.setUnitPrice(pricePerCopy);
					double discountedStockPrice = stockPrice * discountPct;

					if (job.getDoubleSided()) {
						if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.NotChangingPrice.name())) {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * (area / 2));
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSideFactor.name())) {
							pricePerCopy = new Double(Math
									.round(((pricePerCopy * copierDefinition
											.getSideTwoFactor()) / 2) * 10000)) / 10000;
							stockTotalPrice = (discountedStockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSecondSideRate.name())) {
							discountPct = matrixElement.getPrice2()
									.doubleValue();
							pricePerCopy = copierDefinition.getBaseRate()
									.doubleValue()
									* discountPct
									* copierDefinition.getCopyMarkup2();
							discountedStockPrice = stockPrice * discountPct;
							stockTotalPrice = (discountedStockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else {
							stockTotalPrice = (discountedStockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						}
					} else {
						stockTotalPrice = ((discountedStockPrice * area / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else if (copierDefinition.getMatrixType().equals("StepTable")) {
					if (job.getDoubleSided()
							&& copierDefinition.getPriceTwoSide().equals(
									Price2Side.CountingAsMoreOriginals.name())) {
						pricePerCopy = MatrixUtilities
								.calculateStepPriceSideOne(copierDefinition
										.getCopierMatrix(), area * 2);
					} else {
						pricePerCopy = MatrixUtilities
								.calculateStepPriceSideOne(copierDefinition
										.getCopierMatrix(), area);
					}
					if (job.getDoubleSided()) {
						if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.NotChangingPrice.name())) {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * (area / 2));
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSideFactor.name())) {
							pricePerCopy = new Double(Math
									.round(((pricePerCopy * copierDefinition
											.getSideTwoFactor()) / 2) * 10000)) / 10000;
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSecondSideRate.name())) {
							if (job.getDoubleSided()
									&& copierDefinition
											.getPriceTwoSide()
											.equals(
													Price2Side.CountingAsMoreOriginals
															.name())) {
								pricePerCopy = MatrixUtilities
										.calculateStepPriceSideTwo(
												copierDefinition
														.getCopierMatrix(), job
														.getPressQty() * 2);
							} else {
								pricePerCopy = MatrixUtilities
										.calculateStepPriceSideTwo(
												copierDefinition
														.getCopierMatrix(), job
														.getPressQty());
							}
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						}
					} else {
						stockTotalPrice = ((stockPrice * area / runout));
						laborTotalPrice = (pricePerCopy * area);
					}
				} else if (copierDefinition.getMatrixType().equals(
						"MarkupTable")) {
					double markup = 0.0;
					if (copierDefinition.getInterpolateMatrix() == true)
						markup = MatrixUtilities.calculateInterpolation(job
								.getPricingCopier().getCopierMatrix(), area);
					else
						markup = matrixElement.getPrice1().doubleValue();
					pricePerCopy = copierDefinition.getBaseRate().doubleValue()
							* markup;

					if (job.getDoubleSided()) {
						if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.NotChangingPrice.name())) {
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * (area / 2));
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSideFactor.name())) {
							pricePerCopy = new Double(Math
									.round(((pricePerCopy * copierDefinition
											.getSideTwoFactor()) / 2) * 10000)) / 10000;
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
						} else if (copierDefinition.getPriceTwoSide().equals(
								Price2Side.UsingSecondSideRate.name())) {
							markup = matrixElement.getPrice2().doubleValue();
							pricePerCopy = copierDefinition
									.getMachineCostPerCopy().doubleValue()
									* markup
									* copierDefinition.getCopyMarkup2();
							stockTotalPrice = (stockPrice * ((area / 2) / runout));
							laborTotalPrice = (pricePerCopy * area);
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
