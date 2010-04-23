package com.efi.printsmith.pricing.linesandinches;

import org.apache.log4j.Logger;

public class LinesAndInchesPricingMethodFactory {
	protected static Logger log = Logger.getLogger(LinesAndInchesPricingMethodFactory.class);

	static public LinesAndInchesPricingMethod createLinesAndInchesPricingMethod() {
		return new LinesAndInchesPricingMethod();
	}
}