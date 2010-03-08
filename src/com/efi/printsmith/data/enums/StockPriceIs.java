package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum StockPriceIs {
	 IncludeInRate,
	 MarkedUpStockCost,
	 FromCopier1InStockDefinition,
	 FromCopier2InStockDefinition,
	 FromCopier3InStockDefinition;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
