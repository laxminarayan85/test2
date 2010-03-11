package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;

public class ChargeFlatRatePricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		if (charge.getChargeDefinition().getAdjustableRate() && charge.getOverridePrice()) return charge;
		
		charge.setPrice(charge.getChargeDefinition().getPrice());
		
		return charge;
	}

}
