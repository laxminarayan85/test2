package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum Estimator {
	 BlankStock,
	 ChargesOnly,
	 CopierDefinitions,
	 GeneralMerchandise,
	 LinesAndInches,
	 ListPrice,
	 MultipleParts,
	 OutsideServices,
	 PressDefinitions;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
