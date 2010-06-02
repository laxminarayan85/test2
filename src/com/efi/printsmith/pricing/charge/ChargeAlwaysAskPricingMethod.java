package com.efi.printsmith.pricing.charge;

import java.util.Date;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.copier.CopierPricingMethodFactory;
import com.efi.printsmith.service.ChargeService;

public class ChargeAlwaysAskPricingMethod extends ChargePricingMethod {
	
	protected static Logger log = Logger.getLogger(ChargeAlwaysAskPricingMethod.class);

	private double priceListLookupQuantity = 0.0;
	private double materialQuantity = 0.0;
	private double rateQuantity = 0.0;

	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		double price = 0.0;
		
		if (chargeDefinition == null) {
			log.error("Null ChargeDefinition in Charge.");
			return charge;
		}
		
		this.calculateCost(charge);
				
		if (!chargeDefinition.getNoOverrides() && chargeDefinition.getAdjustableRate()
				&& charge.getOverridePrice())
			return charge;
		
		priceListLookupQuantity = 0.0;

		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None.name()) ||
			chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets.name()) ||
			chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
			materialQuantity = 1;
			rateQuantity = 1;
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Time.name())) {
			rateQuantity = this.calculateChargeTimeQuantity(charge);
			materialQuantity = rateQuantity;
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Quantity.name())) {
			materialQuantity = charge.getQuantity();
		} else {
			log.error("Invalid ChargeQtyType in Charge: " + chargeDefinition.getQuantityType());
		}
				
		if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.PiecePrice.name())) {
			double setupPrice = this.calculateSetupPrice(charge);
			
			double materialPrice = this.calculateMaterialPrice(charge);

			double ratePrice = this.calculateRatePrice(charge);
			
			price = setupPrice + materialPrice + ratePrice;			
		} else if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus.name())) {
			ChargeService chargeService = new ChargeService(); //TODO: This needs to be outside of the service.
			
			try {
				ChargeCostingPrices prices = chargeService.calculateChargeCostingRate(chargeDefinition, charge);
				
				if (!charge.getOverrideRate()) {
					charge.setRate(prices.unitPrice);
				}
				price = prices.setupPrice;
				
				price += rateQuantity*charge.getRate();
				price += materialQuantity*charge.getRate();
			} catch (Exception e) {
				log.error(e);
			}			
		} else {
			log.error("Invalid ChargePriceMethod in Charge: " + chargeDefinition.getPriceMethod());
		}
		
		charge.setPrice(price);
		return charge;
	}

	private double calculateSetupPrice(Charge charge) {
		double retVal = 0.0;
		
		if (charge.getChargeDefinition().getUseSetup()) {
			retVal = charge.getChargeDefinition().getSetupPrice();
		}
		
		if (charge.getChargeDefinition().getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
			retVal *= charge.getSets();
		}
		
		return retVal;
	}
	
	private double calculateMaterialPrice(Charge charge) {
		double retVal = 0.0;
		
		if (charge.getChargeDefinition().getUseMaterial()) {
			if (charge.getChargeDefinition().getUseMerchandiseSets()) {
				materialQuantity = this.calculateChargeSets(materialQuantity, 1, 1, charge.getChargeDefinition().getMaterialSetCount());
			}
			retVal = materialQuantity * charge.getChargeDefinition().getMaterial();
		}
		priceListLookupQuantity = retVal; // Use material quantity if nothing later in the pricing process is found
		return retVal;
	}
	
	private double calculateRatePrice(Charge charge) {
		double retVal = 0.0;
		double tmpQty = 0.0;
		
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		tmpQty = rateQuantity;
		if (chargeDefinition.getUseRateSets()) {
			tmpQty = this.calculateChargeSets(tmpQty, 1, 1, chargeDefinition.getRateSetCount());
		}
		
		priceListLookupQuantity = tmpQty; // Use this quantity to lookup price list price if needed
		retVal = tmpQty * charge.getRate();

		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) ||
				chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
			retVal *= charge.getSets();
		}
		return retVal;
	}
	
	private double calculateChargeTimeQuantity(Charge charge) {
		Date tmpDate;
		double retVal = 0.0;
		
		if (charge.getStartTime() == null && charge.getEndTime() != null) {
			// Use End time as the quantity
			tmpDate = charge.getEndTime();
			retVal = tmpDate.getHours() * 60;
			retVal += tmpDate.getMinutes();
		} else if (charge.getStartTime() != null && charge.getEndTime() == null) {
			// Use Start time as the quantity
			tmpDate = charge.getStartTime();
			retVal = tmpDate.getHours() * 60;
			retVal += tmpDate.getMinutes();
		} else if (charge.getStartTime() != null && charge.getEndTime() != null){
			// Assumes Start Time < End Time (should be validated on UI side. Still works otherwise - just returns negative value.
			int startMinutes = 0;
			int endMinutes = 0;
			
			tmpDate = charge.getStartTime();
			startMinutes = tmpDate.getHours()*60;
			startMinutes += tmpDate.getMinutes();
			
			tmpDate = charge.getEndTime();
			endMinutes = tmpDate.getHours()*60;
			endMinutes += tmpDate.getMinutes();
			
			retVal = endMinutes - startMinutes;
		}
		
		if (charge.getChargeDefinition().getUseMinimumTime()) {
			if (charge.getChargeDefinition().getMinimumTime() > retVal) retVal = charge.getChargeDefinition().getMinimumTime();
		}
		
		return retVal;
	}
}
