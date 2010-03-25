package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.JobBase;

public class ChargeCutPricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		CuttingCharge localCharge = (CuttingCharge) charge;
		ChargeDefinition chargeDefinition = localCharge.getChargeDefinition();
		JobBase job = localCharge.getParentJob();
		int jobQty = 1;
		double price = 0.0;
		
		if (chargeDefinition == null) return localCharge;
		// TODO: Handle multi-part jobs per PS
		
		ChargeJobAwarePricingMethod jobAwareMethod = new ChargeJobAwarePricingMethod();
		
		// TODO: Handle cuts are pre-press
		charge = jobAwareMethod.priceCharge(charge);
		
		return charge;
	}

}
