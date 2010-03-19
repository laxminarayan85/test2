package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;

public class ChargeShippingPricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		if (chargeDefinition == null) return charge;
		
		if (chargeDefinition.getCutsArePrePress()) {

		}
		return charge;
	}

}
