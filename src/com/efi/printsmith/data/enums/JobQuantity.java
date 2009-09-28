package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum JobQuantity {
	 EnumerationLiteral1;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
