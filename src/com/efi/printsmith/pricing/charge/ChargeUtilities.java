package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;

public class ChargeUtilities {
	static public Charge calculateChargeCost(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		if (chargeDefinition == null) return charge;
		
		return charge;
	}
}
