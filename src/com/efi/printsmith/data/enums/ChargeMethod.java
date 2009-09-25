package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum ChargeMethod {
	 None,
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
	 Literal,
	 SquareArea;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
