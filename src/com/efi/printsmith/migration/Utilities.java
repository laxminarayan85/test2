package com.efi.printsmith.migration;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ComLink;

public class Utilities {
	protected static Logger log = Logger.getLogger(Utilities.class);

	static public boolean tokenToBooleanValue(String token) {
		if ("1".equals(token) || "TRUE".equals(token.toUpperCase()) || "YES".equals(token.toUpperCase())) {
			return true;
		}
		return false;
	}
	
	static public ComLink tokenToComLink(String token, String type) {
		ComLink comLink = new ComLink();
		comLink.setType(type);
		comLink.setValue(token);
		return comLink;
	}
	
	static public long tokenToLong(String token) throws NumberFormatException {
		long retVal = -1;
		retVal = Long.parseLong(token);
		return retVal;
	}
	
	static public int tokenToInt(String token) throws NumberFormatException {
		int retVal = -1;
		retVal = Integer.parseInt(token);
		return retVal;
	}
	
	static public float tokenToFloat(String token) throws NumberFormatException {
		float retVal = -1;
		retVal = Float.parseFloat(token);
		return retVal;
	}
	
	static public double tokenToDouble(String token) throws NumberFormatException {
		double retVal = -1;
		retVal = Double.parseDouble(token);
		return retVal;
	}
}
