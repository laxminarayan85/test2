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

public class CopiesPerOriginalPricingMethod extends CopierPricingMethod {
	protected static Logger log = Logger.getLogger(CopiesPerOriginalPricingMethod.class);

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
				double unitPrice = pricingMatrix.getElements().get(i).getPrice1();
				
				if (job.getDoubleSided()) {
					if (side2PricingMethod.equals(Price2Side.NotChangingPrice)) {
						/* Do nothing - the price is the same */
					} else if (side2PricingMethod.equals(Price2Side.UsingFirstSideRate)) {
						unitPrice *= 2;
					} else if (side2PricingMethod.equals(Price2Side.UsingSecondSideRate)) {
						unitPrice += pricingMatrix.getElements().get(i).getPrice2();
					} else if (side2PricingMethod.equals(Price2Side.CountingAsMoreOriginals)) {
						/* Note that we are completely overriding the unitPrice here instead of adding to it */
						for (; i < pricingMatrix.getElements().size(); i++) {
							if (pricingMatrix.getElements().get(i).getQty() >= job.getQtyOrdered()) break;
						}
						if (i >0) i--;
						unitPrice = pricingMatrix.getElements().get(i).getPrice1();
					} else if (side2PricingMethod.equals(Price2Side.UsingSideFactor)) {
						unitPrice *= pricingCopier.getSideTwoFactor();
					}
				}
			}
		}
		
		return job;
	}
}
