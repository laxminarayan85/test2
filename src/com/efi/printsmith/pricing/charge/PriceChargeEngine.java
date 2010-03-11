package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;

public interface PriceChargeEngine {
	public Charge priceCharge(Charge charge);
}
