package com.efi.printsmith.migration;

import com.efi.printsmith.data.ComLink;

public class Utilities {
	static public boolean tokenToBooleanValue(String token) {
		if ("1".equals(token)) {
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
}
