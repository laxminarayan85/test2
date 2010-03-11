package com.efi.printsmith.pricing.copier;

import org.apache.log4j.Logger;

import com.efi.printsmith.service.CopierService;


public class CopierPricingMethodFactory {
	protected static Logger log = Logger.getLogger(CopierPricingMethodFactory.class);

	static public CopierPricingMethod createCopierPricingMethod(String method) {
		if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesAndOriginals.name())) {
			log.info("Creating CopiesPlusOriginalsPricingMethod");
			return new CopiesPlusOriginalsPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.CopiesPerOriginals.name())) {
			log.info("Creating CopiesPerOriginalPricingMethod");
			return new CopiesPerOriginalPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.CostPlus.name())) {
			log.info("Creating CostPlusPricingMethod");
			return new CostPlusPricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.FlatRate.name())) {
			log.info("Creating FlatRatePricingMethod");
			return new FlatRatePricingMethod();
		} else if (method.equals(com.efi.printsmith.data.enums.CopierPricingMethod.TotalOfAllCopies.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new TotalAllCopiesPricingMethod();
		} else {
			log.error("Unknown pricing method passed to createCopierPricingMethod");
			return null;
		}
	}
}
