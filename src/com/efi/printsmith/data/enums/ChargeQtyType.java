package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

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
