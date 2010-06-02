package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.pricing.copier.CopierPricingMethod;
import com.efi.printsmith.pricing.copier.CopierPricingMethodFactory;

public class PriceChargeEngine {
	static public Charge priceCharge(Charge charge) {
		ChargePricingMethod chargePricingMethod = ChargePricingMethodFactory.createChargePricingMethod(charge.getChargeDefinition().getMethod());
		chargePricingMethod.priceCharge(charge);
		return charge;
	}
}
