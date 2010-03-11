package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;

public class ChargeJobAwarePricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		return charge;
	}

}
