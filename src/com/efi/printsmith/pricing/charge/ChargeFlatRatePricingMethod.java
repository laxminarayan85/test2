package com.efi.printsmith.pricing.charge;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.service.ChargeService;

public class ChargeFlatRatePricingMethod extends ChargePricingMethod {
	protected static Logger log = Logger.getLogger(ChargeFlatRatePricingMethod.class);

	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		if (chargeDefinition == null) {
			log.error("Null ChargeDefinition in Charge.");
			return charge;
		}
		
		this.calculateCost(charge);
		if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus.name())) {
			ChargeService chargeService = new ChargeService();
			try {
				ChargeCostingPrices prices = chargeService.calculateChargeCostingRate(chargeDefinition, charge);
				charge.setPrice(prices.materialSetupPrice + prices.materialUnitPrice + prices.unitPrice + prices.setupPrice);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (!chargeDefinition.getNoOverrides() && chargeDefinition.getAdjustableRate()
					&& charge.getOverridePrice())
				return charge;
		
			charge.setPrice(charge.getRate());
		}
		return charge;
	}
}
