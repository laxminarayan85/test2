package com.efi.printsmith.pricing.charge;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.service.CopierService;


public class ChargePricingMethodFactory {
	protected static Logger log = Logger.getLogger(ChargePricingMethodFactory.class);

	static public ChargePricingMethod createCopierPricingMethod(ChargeMethod method) {
		if (method.equals(ChargeMethod.Ask)) {
			log.info("Creating CopiesPlusOriginalsPricingMethod");
			return new ChargeAlwaysAskPricingMethod();
		} else if (method.equals(ChargeMethod.Cut)) {
			log.info("Creating CopiesPerOriginalPricingMethod");
			return new ChargeCutPricingMethod();
		} else if (method.equals(ChargeMethod.FlatRate)) {
			log.info("Creating CostPlusPricingMethod");
			return new ChargeFlatRatePricingMethod();
		} else if (method.equals(ChargeMethod.Fold)) {
			log.info("Creating FlatRatePricingMethod");
			return new ChargeFoldPricingMethod();
		} else if (method.equals(ChargeMethod.Ink)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeInkPricingMethod();
		}  else if (method.equals(ChargeMethod.JobAware)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeJobAwarePricingMethod();
		}  else if (method.equals(ChargeMethod.Linear)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeLinearPricingMethod();
		}  else if (method.equals(ChargeMethod.Markup)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeMarkupPricingMethod();
		}  else if (method.equals(ChargeMethod.PriceList)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargePriceListPricingMethod();
		}  else if (method.equals(ChargeMethod.RateList)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeRateListPricingMethod();
		}  else if (method.equals(ChargeMethod.Shipping)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeShippingPricingMethod();
		}  else if (method.equals(ChargeMethod.SquareArea)) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeSquareAreaPricingMethod();
		} else {
			log.error("Unknown pricing method passed to createCopierPricingMethod");
			return null;
		}
	}
}
