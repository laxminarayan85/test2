package com.efi.printsmith.data.enums;

/**
 */
public enum ChargeQtyType {
	 Sets,
	 Quantity,
	 Time,
	 None,
	 SetupSets;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
