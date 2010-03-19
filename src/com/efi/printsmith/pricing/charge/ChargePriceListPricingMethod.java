package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargePriceListPricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		if (chargeDefinition == null) return charge;

		PriceList priceList = chargeDefinition.getPriceList();
		if (priceList == null) return charge;
		
		double rate = PriceListUtilities.lookupPrice(priceList, charge.getQuantity().longValue());
		
		if (priceList.getIsDollar()) {
			charge.setPrice(rate);
		} else if (priceList.getIsRate() && priceList.getIsPercentage()) {
			// TODO: What does this mean as a pricing method?		
		} else if (priceList.getIsRate()) {
			charge.setPrice(rate*charge.getQuantity());
		} else if (priceList.getIsPercentage()) {
			// TODO: What does this mean as a pricing method?		
		} else if (priceList.getIsDiscount()) {
			// TODO: What does this mean as a pricing method?
		} else {
			charge.setPrice(rate);
		}
		return charge;
	}

}
