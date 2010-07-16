package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum ChargeMethod {
	 JobAware,
	 Markup,
	 FlatRate,
	 Ask,
	 PriceList,
	 RateList,
	 Cut,
	 Ink,
	 Shipping,
	 Fold,
	 Linear,
	 SquareArea;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
