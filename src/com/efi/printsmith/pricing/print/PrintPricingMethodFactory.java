package com.efi.printsmith.pricing.print;

import org.apache.log4j.Logger;

public class PrintPricingMethodFactory {
	protected static Logger log = Logger.getLogger(PrintPricingMethodFactory.class);

	static public PrintPricingMethod createPrintPricingMethod() {
		log.info("Creating PrintPricingMethod");
		return new PrintPricingMethod();
	}
}
