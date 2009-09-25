package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum ChargeInkCoverage {
	 UnknownArea,
	 RunArea,
	 FinishedArea;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
