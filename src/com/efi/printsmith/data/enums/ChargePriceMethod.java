package com.efi.printsmith.data.enums;

/**
 */
public enum ChargePriceMethod {
	 PiecePrice,
	 CostPlus;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
