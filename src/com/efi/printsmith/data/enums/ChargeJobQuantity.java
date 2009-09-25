package com.efi.printsmith.data.enums;

/**
 */
public enum ChargeJobQuantity {
	 None,
	 Press,
	 Finish,
	 Parent;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
