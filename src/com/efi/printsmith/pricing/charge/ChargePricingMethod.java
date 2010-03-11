package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;

public abstract class ChargePricingMethod {
	public abstract Charge priceCharge(Charge charge);
}
