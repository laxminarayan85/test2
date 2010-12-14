package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum CopierPricingMethod {
	 CostPlus,
	 FlatRate,
	 CopiesAndOriginals,
	 CopiesPerOriginals,
	 TotalOfAllCopies,
	 SquareAreaOfOriginals,
	 TotalSquareArea,
	 SquareAreaAndCopies,
	 SquareAreaPerCopy;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
