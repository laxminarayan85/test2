package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;

public class PriceChargeEngine {
	static public Charge priceCharge(Charge charge) {
		ChargePricingMethod chargePricingMethod = ChargePricingMethodFactory.createChargePricingMethod(charge.getChargeDefinition().getMethod());
		chargePricingMethod.priceCharge(charge);
		return charge;
	}
}
