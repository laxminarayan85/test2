package com.efi.printsmith.pricing.charge;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.service.CopierService;


public class ChargePricingMethodFactory {
	protected static Logger log = Logger.getLogger(ChargePricingMethodFactory.class);

	static public ChargePricingMethod createCopierPricingMethod(String method) {
		if (method.equals(ChargeMethod.Ask.name())) {
			log.info("Creating CopiesPlusOriginalsPricingMethod");
			return new ChargeAlwaysAskPricingMethod();
		} else if (method.equals(ChargeMethod.Cut.name())) {
			log.info("Creating CopiesPerOriginalPricingMethod");
			return new ChargeCutPricingMethod();
		} else if (method.equals(ChargeMethod.FlatRate.name())) {
			log.info("Creating CostPlusPricingMethod");
			return new ChargeFlatRatePricingMethod();
		} else if (method.equals(ChargeMethod.Fold.name())) {
			log.info("Creating FlatRatePricingMethod");
			return new ChargeFoldPricingMethod();
		} else if (method.equals(ChargeMethod.Ink.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeInkPricingMethod();
		}  else if (method.equals(ChargeMethod.JobAware.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeJobAwarePricingMethod();
		}  else if (method.equals(ChargeMethod.Linear.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeLinearPricingMethod();
		}  else if (method.equals(ChargeMethod.Markup.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeMarkupPricingMethod();
		}  else if (method.equals(ChargeMethod.PriceList.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargePriceListPricingMethod();
		}  else if (method.equals(ChargeMethod.RateList.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeRateListPricingMethod();
		}  else if (method.equals(ChargeMethod.Shipping.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeShippingPricingMethod();
		}  else if (method.equals(ChargeMethod.SquareArea.name())) {
			log.info("Creating TotalAllCopiesPricingMethod");
			return new ChargeSquareAreaPricingMethod();
		} else {
			log.error("Unknown pricing method passed to createCopierPricingMethod");
			return null;
		}
	}
}
