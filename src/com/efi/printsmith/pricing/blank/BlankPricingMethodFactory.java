package com.efi.printsmith.pricing.blank;

import org.apache.log4j.Logger;

public class BlankPricingMethodFactory {
	protected static Logger log = Logger.getLogger(BlankPricingMethodFactory.class);

	static public BlankPricingMethod createBlankPricingMethod() {
		return new BlankPricingMethod();
	}
}