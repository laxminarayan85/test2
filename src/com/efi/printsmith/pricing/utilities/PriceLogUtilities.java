package com.efi.printsmith.pricing.utilities;

import java.util.Date;

import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.service.DataService;

public class PriceLogUtilities {
	
	static public PriceLogEntry createPriceLogEntry(String method, String description) throws Exception {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setVersion(1);
		DataService dataService = new DataService();
		priceLogEntry = (PriceLogEntry)dataService.addUpdate(priceLogEntry);
		return priceLogEntry;
	}

	static public PriceLogEntry createPriceLogEntry(PriceLogEntry parent, String method, String description) throws Exception {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		DataService dataService = new DataService();
		priceLogEntry = (PriceLogEntry)dataService.addUpdate(priceLogEntry);
		priceLogEntry.setVersion(1);
		if (parent != null) parent.addChildren(priceLogEntry);
		return priceLogEntry;
	}

	static public PriceLogEntry createPriceLogEntry(String method, String description, double value) throws Exception {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setValue(value);
		priceLogEntry.setVersion(1);
		DataService dataService = new DataService();
		priceLogEntry = (PriceLogEntry)dataService.addUpdate(priceLogEntry);
		return priceLogEntry;
	}
	
	static public PriceLogEntry createPriceLogEntry(PriceLogEntry parent, String method, String description, double value) throws Exception {
		PriceLogEntry priceLogEntry = new PriceLogEntry();
		
		priceLogEntry.setDate(new Date());
		priceLogEntry.setMethod(method);
		priceLogEntry.setDescription(description);
		priceLogEntry.setValue(value);
		priceLogEntry.setVersion(1);
		DataService dataService = new DataService();
		priceLogEntry = (PriceLogEntry)dataService.addUpdate(priceLogEntry);
		if (parent != null) parent.addChildren(priceLogEntry);
		return priceLogEntry;
	}
}
