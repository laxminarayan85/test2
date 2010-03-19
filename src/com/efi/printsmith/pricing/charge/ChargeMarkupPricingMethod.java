package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.enums.ChargeMarkupType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeMarkupPricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		double rate = 0;
		double lookupQty = 0;
		double price = 0;
		JobBase job = charge.getParentJob();
		
		if (chargeDefinition == null || job == null) {
			return charge;
		}
		
		if (chargeDefinition.getUseRate()) {
			rate = chargeDefinition.getRate();
		} else {
			rate = 0;
		}
		
//		if (chargeDefinition.getMarkupType().equals(ChargeMarkupType.OnlyJob)) {
			lookupQty = job.getPricingRecord().getTotalPrice();
			price = lookupQty * rate;
//		} else if (chargeDefinition.getMarkupType().equals(ChargeMarkupType.EntireJob)) {
//			// TODO
//		} else if (chargeDefinition.getMarkupType().equals(ChargeMarkupType.Charges)) {
//			// TODO
//		} else if (chargeDefinition.getMarkupType().equals(ChargeMarkupType.Invoice)) {
//			// TODO
//		}
		
		PriceList priceList = chargeDefinition.getPriceList();
		if (priceList != null) {
			rate = PriceListUtilities.lookupPrice(priceList, (long)lookupQty);
			
			if (priceList.getIsRate()) {
				price += rate;
			} else {
				price += lookupQty * rate;
			}
		}
		charge.setPrice(price);
		return charge;
	}

}
