package com.efi.printsmith.data.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
public enum Days {
	 Monday,
	 Tuesday,
	 Wednesday,
	 Thursday,
	 Friday,
	 Saturday,
	 Sunday;
	public String getLocalizedValue(java.util.Locale locale) {
		String retVal = toString();
		return retVal;
	}	
}
