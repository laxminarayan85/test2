package com.efi.printsmith.data.enums;

/**
 */
public enum ChargeMarkupType {
	 OnlyJob,
	 Charges,
	 EntireJob,
	 Invoice;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
