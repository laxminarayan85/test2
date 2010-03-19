package com.efi.printsmith.pricing.largeformat;

import org.apache.log4j.Logger;

import com.efi.printsmith.service.CopierService;


public class LargeFormatPricingMethodFactory {
	protected static Logger log = Logger.getLogger(LargeFormatPricingMethodFactory.class);

	static public LargeFormatPricingMethod createLargeFormatPricingMethod(String method) {
		if (method.equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
			log.info("Creating SquareAreaAndCopiesPricingMethod");
			return new SquareAreaAndCopiesPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndCopies.name())) {
			log.info("SquareAreaAndCopiesPricingMethod");
			return new SquareAreaAndCopiesPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.SquareAreaAndOriginals.name())) {
			log.info("Creating SquareAreaAndOriginalsPricingMethod");
			return new SquareAreaAndOriginalsPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.LargeFormatPriceMethod.TotalSquareArea.name())) {
			log.info("Creating TotalOfSquareAreaPricingMethod");
			return new TotalOfSquareAreaPricingMethod();
		} else {
			log.error("Unknown pricing method passed to createCopierPricingMethod");
			return null;
		}
	}
}
