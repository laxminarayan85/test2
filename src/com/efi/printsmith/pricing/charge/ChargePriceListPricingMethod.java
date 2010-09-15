package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import com.efi.printsmith.data.Charge;

public class ChargePriceListPricingMethod extends ChargePricingMethod {
	@Override
	public Charge priceCharge(Charge charge) {
		if (charge.getOverridePrice()) return charge;
		BigDecimal price = calculatePriceListPrice(charge);
		charge.setPrice(price);
		return charge;
	}
}
