package com.efi.printsmith.pricing.print;

import org.apache.log4j.Logger;

import com.efi.printsmith.service.CopierService;


public class PrintPricingMethodFactory {
	protected static Logger log = Logger.getLogger(PrintPricingMethodFactory.class);

	static public PrintPricingMethod createPrintPricingMethod() {
		log.info("Creating PrintPricingMethod");
		return new PrintPricingMethod();
	}
}
