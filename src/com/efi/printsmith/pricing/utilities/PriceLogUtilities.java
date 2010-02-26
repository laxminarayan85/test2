package com.efi.printsmith.pricing.utilities;

import java.util.Date;

import com.efi.printsmith.data.PriceLogEntry;

public class PriceLogUtilities {
	
	static public PriceLogEntry createPriceLogEntry(String method, String description) {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setVersion(1);
		
		return priceLogEntry;
	}

	static public PriceLogEntry createPriceLogEntry(PriceLogEntry parent, String method, String description) {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setVersion(1);
		if (parent != null) parent.addChildren(priceLogEntry);
		return priceLogEntry;
	}

	static public PriceLogEntry createPriceLogEntry(String method, String description, double value) {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setValue(value);
		priceLogEntry.setVersion(1);
		
		return priceLogEntry;
	}
	
	static public PriceLogEntry createPriceLogEntry(PriceLogEntry parent, String method, String description, double value) {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setValue(value);
		priceLogEntry.setVersion(1);
		if (parent != null) parent.addChildren(priceLogEntry);
		return priceLogEntry;
	}
}
