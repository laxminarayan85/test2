package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeMethod;

public class ChargeUtilities {

	static public Charge createChargeFromChargeDefinition(ChargeDefinition chargeDefinition) {
		Charge charge;
		if (chargeDefinition.getMethod().equals(ChargeMethod.SquareArea.name())) {
			charge = new SquareAreaCharge();
			((SquareAreaCharge)charge).setOverrideArea(false);
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Cut.name())) {
			charge = new CuttingCharge();
			((CuttingCharge)charge).setCuts(chargeDefinition.getPresetCuts());
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Ink.name())) {
			charge = new InkCharge();
			((InkCharge)charge).setCoverage((double)chargeDefinition.getPresetCoverage());
			((InkCharge)charge).setInkWeight(0.0);
			((InkCharge)charge).setCoverPerPound((double)chargeDefinition.getPresetCoverPerPound());
			((InkCharge)charge).setPricePerPound(chargeDefinition.getPresetPricePerPound());
			((InkCharge)charge).setPoundsOfInk(chargeDefinition.getPresetPoundsofInk());
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Shipping.name())) {
			charge = new ShippingCharge();
			((ShippingCharge)charge).setTotalWeight(0.0);
			((ShippingCharge)charge).setOverrideTotalWeight(false);			
		} else {
			charge=new Charge();
		}
		charge.setChargeDefinition(chargeDefinition);
		if (chargeDefinition.getPresetDescription() != null &&
				chargeDefinition.getPresetDescription().length() > 0) {
			charge.setDescription(chargeDefinition.getPresetDescription());
		} else {
			charge.setDescription(chargeDefinition.getName());
		}
		
		if (chargeDefinition.getPresetNotes() != null &&
				chargeDefinition.getPresetNotes().length() > 0) {
			charge.setNotes(chargeDefinition.getPresetNotes());
		}
		
		if (chargeDefinition.getPriceMethod() == "CostPlus") {
			
		} else {
			
		}
		charge.setShowNotes(chargeDefinition.getPresetShowNotes());
		charge.setFinished(chargeDefinition.getPresetFinished());
		charge.setTaxable(chargeDefinition.getPresetTaxable());
		charge.setBrokered(chargeDefinition.getPresetBrokered());
		charge.setDisplayQty(chargeDefinition.getPresetDisplayQuantity());
		charge.setHidden(chargeDefinition.getHideChargeInPrintouts());
		charge.setHidePrice(chargeDefinition.getHidePrice());
		
		if (chargeDefinition.getOverridePrice()) {
			charge.setPrice(chargeDefinition.getPresetPrice());
		} else {
			charge.setPrice(0.0);
		}
		charge.setOverridePrice(chargeDefinition.getOverridePrice());

		charge.setMaterialQty(chargeDefinition.getPresetMaterialQuantity());
		charge.setOverrideMaterialQuantity(chargeDefinition.getOverrideMaterialQty());
		
		charge.setQuantity(chargeDefinition.getPresetQuantity());
		charge.setOverrideQuantity(chargeDefinition.getOverrideRateQuantity());

		charge.setRate(chargeDefinition.getRate());
		charge.setOverrideRate(chargeDefinition.getOverrideRate());

		charge.setSets(chargeDefinition.getRateSetCount());
		charge.setMaterialSets(chargeDefinition.getMaterialSetCount());
		charge.setRate(chargeDefinition.getRate());
		charge.setOverrideRate(chargeDefinition.getOverrideRate());
		charge.setOverrideUp(false);
		charge.setMinimumCharge(chargeDefinition.getMinimum());
		charge.setQuantity(chargeDefinition.getPresetQuantity());
		charge.setQtyPerSet(chargeDefinition.getPresetQuantityPerSet());
		charge.setStartHours(chargeDefinition.getPresetTimeStartHour());
		charge.setStartMinutes(chargeDefinition.getPresetTimeStartMinute());
		charge.setEndHours(chargeDefinition.getPresetTimeStopHour());
		charge.setEndMinutes(chargeDefinition.getPresetTimeStopMinute());
		charge.setLinearX1(chargeDefinition.getLinearX1());
		charge.setLinearX2(chargeDefinition.getLinearX2());
		charge.setLinearY1(chargeDefinition.getLinearY1());
		charge.setLinearX2(chargeDefinition.getLinearX2());
		return charge;
	}

}
