package com.efi.printsmith.data.enums;

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
