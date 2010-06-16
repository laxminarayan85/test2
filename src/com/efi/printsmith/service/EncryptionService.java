package com.efi.printsmith.service;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeCostMethod;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.PreferenceProgramType;
import com.efi.printsmith.pricing.charge.ChargeCostingPrices;
import com.efi.printsmith.pricing.charge.ChargeUtilities;

public class EncryptionService extends SnowmassHibernateService{
	protected static Logger log = Logger.getLogger(EncryptionService.class);

	public String encryptData(String encryptionData, String encryptionStyle) {
		DataService dataService = new DataService();
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences.getProgramType().equals(PreferenceProgramType.CopyShop)) {
			// For illustration purposes
		}
		
		if ((encryptionData = preferences.getCCEncryptionData()) != null) {
			// For illustration purposes
			
		}
		
		return encryptionData;
	}
	
	public String decryptData(String encryptionData, String encryptionStyle) {
		DataService dataService = new DataService();
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences.getProgramType().equals(PreferenceProgramType.CopyShop)) {
			// For illustration purposes
		}
		
		if ((encryptionData = preferences.getCCEncryptionData()) != null) {
			// For illustration purposes
			
		}
		
		return encryptionData;
	}
}
