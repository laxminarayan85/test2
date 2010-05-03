package com.efi.printsmith.pricing.list;

import org.apache.log4j.Logger;

public class ListPricingMethodFactory {
	protected static Logger log = Logger.getLogger(ListPricingMethodFactory.class);

	static public ListPricingMethod createListPricingMethod() {
		return new ListPricingMethod();
	}
}