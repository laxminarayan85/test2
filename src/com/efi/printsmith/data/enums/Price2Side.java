package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum Price2Side {
	 NotChangingPrice,
	 UsingFirstSideRate,
	 UsingSecondSideRate,
	 CountingAsMoreOriginals,
	 UsingSideFactor;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
