package com.efi.printsmith.service;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeCostMethod;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.pricing.charge.ChargeCostingPrices;
import com.efi.printsmith.pricing.charge.ChargeUtilities;

public class ChargeService extends SnowmassHibernateService{
	protected static Logger log = Logger.getLogger(ChargeService.class);

	public Charge createChargeFromChargeDefinition(ChargeDefinition chargeDefinition) {
		return ChargeUtilities.createChargeFromChargeDefinition(chargeDefinition);
	}
	
	public ChargeCostingPrices calculateChargeCostingRate(ChargeDefinition chargeDefinition, Charge charge) throws Exception {
		ChargeCostingPrices prices = new ChargeCostingPrices();
		prices.setupPrice = new BigDecimal(0.0);
		prices.unitPrice = new BigDecimal(0.0);
		
		if (chargeDefinition == null) {
			throw new Exception("null chargeDefinition passed to calculateChargeCostingRate");
		}
		ChargeCost chargeCost = chargeDefinition.getChargeCost();
		
		if (chargeCost != null && chargeCost.getCostingMethod() != null) {
			if (chargeCost.getCostingMethod().equals(ChargeCostMethod.HundredPercent.name())) {
				prices.setSetupPrice(0.0);
				prices.setUnitPrice(0.0);			
			} else if (chargeCost.getCostingMethod().equals(ChargeCostMethod.NoCost.name())) {
				prices.setSetupPrice(0.0);
				prices.setUnitPrice(0.0);			
			} else if (chargeCost.getCostingMethod().equals(ChargeCostMethod.TimeAndMaterial.name())) {
				double setupCost = chargeCost.getLaborRate().doubleValue()/60*chargeCost.getSetupMinutes();
				//setupCost += chargeCost.getFixedMaterials();
				
				double minutesPerPiece = 0.0;
				if (chargeCost.getPiecesPerHour() != 0) {
					minutesPerPiece = 60/chargeCost.getPiecesPerHour();
				}
				double unitCost = minutesPerPiece * (chargeCost.getLaborRate().doubleValue()/60);
				//unitCost += chargeCost.getUnitMaterials();
				
				double markup = chargeDefinition.getMarkup();
				prices.setSetupPrice(setupCost * markup);
				prices.setUnitPrice(unitCost * markup);
				prices.setMaterialSetupPrice(chargeCost.getFixedMaterials().doubleValue());
				prices.setMaterialUnitPrice(chargeCost.getUnitMaterials().doubleValue());
			} else if (chargeCost.getCostingMethod().equals(ChargeCostMethod.UnitCost.name())) {
				double unitCost = chargeCost.getUnitCost().doubleValue();
				double setupCost = chargeCost.getSetupCost().doubleValue();
				double markup = chargeDefinition.getMarkup();
				
				prices.setSetupPrice(setupCost * markup);
				prices.setUnitPrice(unitCost * markup);
				prices.setMaterialSetupPrice(0.0);
				prices.setMaterialUnitPrice(0.0);			
			}
		}
		return prices;
	}
}
