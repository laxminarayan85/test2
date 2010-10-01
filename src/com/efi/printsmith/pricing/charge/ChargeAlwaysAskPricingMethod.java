package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.service.ChargeService;

public class ChargeAlwaysAskPricingMethod extends ChargePricingMethod {
	
	protected static Logger log = Logger.getLogger(ChargeAlwaysAskPricingMethod.class);

	private double materialQuantity = 0.0;
	private double rateQuantity = 0.0;

	@Override
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		BigDecimal price = new BigDecimal(0.0);
		
		if (chargeDefinition == null) {
			log.error("Null ChargeDefinition in Charge.");
			return charge;
		}
		
		this.calculateCost(charge);
				
		if (!chargeDefinition.getNoOverrides() && chargeDefinition.getAdjustableRate()
				&& charge.getOverridePrice())
			return charge;
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None.name()) ||
			chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets.name()) ||
			chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
			materialQuantity = 1;
			rateQuantity = 1;
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Time.name())) {
			rateQuantity = this.calculateChargeTimeQuantity(charge)/60;
			materialQuantity = rateQuantity;
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Quantity.name())) {
			rateQuantity = charge.getQuantity();
			materialQuantity = charge.getMaterialQty();
		} else {
			log.error("Invalid ChargeQtyType in Charge: " + chargeDefinition.getQuantityType());
		}
				
		if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.PiecePrice.name())) {
			BigDecimal setupPrice = this.calculateSetupPrice(charge);
			
			BigDecimal materialPrice = this.calculateMaterialPrice(charge);

			BigDecimal ratePrice = this.calculateRatePrice(charge);
			
			price = setupPrice.add(materialPrice).add(ratePrice);			
		} else if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus.name())) {
			ChargeService chargeService = new ChargeService(); //TODO: This needs to be outside of the service.
			
			try {
				ChargeCostingPrices prices = chargeService.calculateChargeCostingRate(chargeDefinition, charge);
				
				if (!charge.getOverrideRate()) {
					charge.setRate(prices.unitPrice);
				}
				price = prices.setupPrice.add(prices.materialSetupPrice);
				
				price = price.add(charge.getRate().multiply(new BigDecimal(rateQuantity)));

				if (!chargeDefinition.getQuantityType().equals(ChargeQtyType.Time.name())) {
					price.add(prices.materialUnitPrice.multiply(new BigDecimal(materialQuantity)));
				}
			} catch (Exception e) {
				log.error(e);
			}			
		} else {
			log.error("Invalid ChargePriceMethod in Charge: " + chargeDefinition.getPriceMethod());
		}
		
		if (chargeDefinition.getUseMinimumCharge() && chargeDefinition.getMinimum().doubleValue() > price.doubleValue()) {
			price = chargeDefinition.getMinimum();
		}
		
		if (charge.getChargeDefinition().getPriceList() != null) {
			price = this.calculatePriceListPrice(charge).add(price);
		}
		if (!charge.getOverridePrice())
			charge.setPrice(price);
		return charge;
	}

	private BigDecimal calculateSetupPrice(Charge charge) {
		BigDecimal retVal = new BigDecimal(0.0);
		
		if (charge.getChargeDefinition().getUseSetup()) {
			retVal = charge.getChargeDefinition().getSetupPrice();
		
			if (charge.getChargeDefinition().getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
				retVal = new BigDecimal(retVal.doubleValue() * charge.getSets());
			}
		}
		return retVal;
	}
	
	private BigDecimal calculateMaterialPrice(Charge charge) {
		BigDecimal retVal = new BigDecimal(0.0);
		
		if (charge.getChargeDefinition().getUseMaterial()) {
			if (charge.getChargeDefinition().getUseMaterialSets()) {
				materialQuantity = this.calculateChargeSets(materialQuantity, 1, 1, charge.getChargeDefinition().getMaterialSetCount());
			}
			retVal = new BigDecimal(materialQuantity * charge.getChargeDefinition().getMaterial().doubleValue());
		}		
		return retVal;
	}
	
	private BigDecimal calculateRatePrice(Charge charge) {
		BigDecimal retVal = new BigDecimal(0.0);
		double tmpQty = 0.0;
		
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();

		if (!chargeDefinition.getUseRate()) return new BigDecimal(0.0);
		
		tmpQty = rateQuantity;
		if (chargeDefinition.getUseRateSets()) {
			tmpQty = this.calculateChargeSets(tmpQty, 1, 1, chargeDefinition.getRateSetCount());
		}
		
		retVal = new BigDecimal(tmpQty * charge.getRate().doubleValue());

		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets.name()) ||
				chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
			retVal = new BigDecimal(retVal.doubleValue() * charge.getQtyPerSet());
		}
		return retVal;
	}
	
	private double calculateChargeTimeQuantity(Charge charge) {
		double retVal = 0.0;
		
		if (charge.getStartHours() == 0 && charge.getStartMinutes() == 0) {
			retVal = charge.getEndHours() * 60;
			retVal += charge.getEndMinutes();
		} else if (charge.getEndHours() == 0 && charge.getEndMinutes() == 0) {
			retVal = charge.getStartHours() * 60;
			retVal += charge.getStartMinutes();			
		} else {
			int startMinutes = 0;
			int endMinutes = 0;
			
			startMinutes = charge.getStartHours() * 60;
			startMinutes += charge.getStartMinutes();
			
			endMinutes = charge.getEndHours() * 60;
			endMinutes += charge.getEndMinutes();
			
			retVal = endMinutes - startMinutes;
		}
		
		if (charge.getChargeDefinition().getUseMinimumTime()) {
			if (charge.getChargeDefinition().getMinimumTime() > retVal) {
				int difference = charge.getChargeDefinition().getMinimumTime().intValue() - (int)retVal;
				
				if (difference > 60) {
					int hours = difference/60;
					charge.setEndHours(charge.getEndHours()+hours);
					difference -= hours;
				}
				
				charge.setEndMinutes(charge.getEndMinutes() + difference);
				
				retVal = charge.getChargeDefinition().getMinimumTime();
			}
		}
		
		return retVal;
	}
}
