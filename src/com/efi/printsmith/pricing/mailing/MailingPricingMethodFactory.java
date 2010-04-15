package com.efi.printsmith.pricing.mailing;

import org.apache.log4j.Logger;

public class MailingPricingMethodFactory {
	protected static Logger log = Logger.getLogger(MailingPricingMethodFactory.class);

	static public MailingPricingMethod createMailingPricingMethod() {
		return new MailingPricingMethod();
	}
}