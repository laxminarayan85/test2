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
import com.efi.printsmith.pricing.utilities.PriceLogUtilities;
import com.efi.printsmith.service.PricingService;

public class CopiesPlusOriginalsPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPlusOriginalsPricingMethod.class);

	public Job priceCopierJob(Job job) {
		log.info("Start priceCopierJob for job " + job.getId());

		super.priceCopierJob(job);

		CopierDefinition pricingCopier = job.getPricingCopier();
		if (pricingCopier != null) {
			Matrix pricingMatrix = pricingCopier.getCopierMatrix();
			String side2PricingMethod = pricingCopier.getPriceTwoSide();
			if (pricingMatrix != null) {
				int i;
				for (i = 0; i < pricingMatrix.getElements().size(); i++) {
					if (pricingMatrix.getElements().get(i).getQty() > job.getQtyOrdered()) break;
				}
				if (i > 0) i--; /* Use the price in the matrix prior to qty > qtyordered */
				
				int j;
				for (j = 0; j < pricingMatrix.getHeaderValues().size(); j++) {
					if (pricingMatrix.getHeaderValues().get(j) > job.getSheets()) break;
				}
				if (j > 0) j--;
				
				double unitPrice = 0.0;
				switch (j) {
				case (0):
					unitPrice = pricingMatrix.getElements().get(i).getPrice1();
					break;
				case (1):
					unitPrice = pricingMatrix.getElements().get(i).getPrice2();
					break;
				case (2):
					unitPrice = pricingMatrix.getElements().get(i).getPrice3();
					break;
				case (3):
					unitPrice = pricingMatrix.getElements().get(i).getPrice4();
					break;
				case (4):
					unitPrice = pricingMatrix.getElements().get(i).getPrice5();
					break;
				case (5):
					unitPrice = pricingMatrix.getElements().get(i).getPrice6();
					break;
				case (6):
					unitPrice = pricingMatrix.getElements().get(i).getPrice7();
					break;
				case (7):
					unitPrice = pricingMatrix.getElements().get(i).getPrice8();
					break;
				case (8):
					unitPrice = pricingMatrix.getElements().get(i).getPrice9();
					break;
				case (9):
					unitPrice = pricingMatrix.getElements().get(i).getPrice10();
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
							unitPrice += pricingMatrix.getElements().get(i).getPrice11();
							break;
						case (1):
							unitPrice += pricingMatrix.getElements().get(i).getPrice12();
							break;
						case (2):
							unitPrice += pricingMatrix.getElements().get(i).getPrice13();
							break;
						case (3):
							unitPrice += pricingMatrix.getElements().get(i).getPrice14();
							break;
						case (4):
							unitPrice += pricingMatrix.getElements().get(i).getPrice15();
							break;
						case (5):
							unitPrice += pricingMatrix.getElements().get(i).getPrice16();
							break;
						case (6):
							unitPrice += pricingMatrix.getElements().get(i).getPrice17();
							break;
						case (7):
							unitPrice += pricingMatrix.getElements().get(i).getPrice18();
							break;
						case (8):
							unitPrice += pricingMatrix.getElements().get(i).getPrice19();
							break;
						case (9):
							unitPrice += pricingMatrix.getElements().get(i).getPrice20();
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
							unitPrice = pricingMatrix.getElements().get(i).getPrice1();
							break;
						case (1):
							unitPrice = pricingMatrix.getElements().get(i).getPrice2();
							break;
						case (2):
							unitPrice = pricingMatrix.getElements().get(i).getPrice3();
							break;
						case (3):
							unitPrice = pricingMatrix.getElements().get(i).getPrice4();
							break;
						case (4):
							unitPrice = pricingMatrix.getElements().get(i).getPrice5();
							break;
						case (5):
							unitPrice = pricingMatrix.getElements().get(i).getPrice6();
							break;
						case (6):
							unitPrice = pricingMatrix.getElements().get(i).getPrice7();
							break;
						case (7):
							unitPrice = pricingMatrix.getElements().get(i).getPrice8();
							break;
						case (8):
							unitPrice = pricingMatrix.getElements().get(i).getPrice9();
							break;
						case (9):
							unitPrice = pricingMatrix.getElements().get(i).getPrice10();
							break;
						}
					} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor)) {
						unitPrice *= pricingCopier.getSideTwoFactor();
					}
				}
			}
		}
		
		return job;
	}
}
