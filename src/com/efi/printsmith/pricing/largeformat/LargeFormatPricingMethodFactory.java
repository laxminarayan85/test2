package com.efi.printsmith.pricing.largeformat;

import org.apache.log4j.Logger;


public class LargeFormatPricingMethodFactory {
	protected static Logger log = Logger.getLogger(LargeFormatPricingMethodFactory.class);

	static public LargeFormatPricingMethod createLargeFormatPricingMethod(String method) {
		if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.SquareAreaPerCopy.name())) {
			log.info("Creating SquareAreaAndCopiesPricingMethod");
			return new SquareAreaPerCopyPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.SquareAreaAndCopies.name())) {
			log.info("SquareAreaAndCopiesPricingMethod");
			return new SquareAreaAndCopiesPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.SquareAreaOfOriginals.name())) {
			log.info("Creating SquareAreaAndOriginalsPricingMethod");
			return new SquareAreaAndOriginalsPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.TotalSquareArea.name())) {
			log.info("Creating TotalOfSquareAreaPricingMethod");
			return new TotalOfSquareAreaPricingMethod();
		} else {
			log.error("Unknown pricing method passed to createCopierPricingMethod");
			return null;
		}
	}
}
