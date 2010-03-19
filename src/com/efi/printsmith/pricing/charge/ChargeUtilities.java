package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeMethod;

public class ChargeUtilities {
	static public Charge calculateChargeCost(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		if (chargeDefinition == null) return charge;
		
		return charge;
	}

	static public Charge createChargeFromChargeDefinition(ChargeDefinition chargeDefinition) {
		Charge charge;
		if (chargeDefinition.getMethod().equals(ChargeMethod.SquareArea.name())) {
			charge = new SquareAreaCharge();
			((SquareAreaCharge)charge).setOverrideArea(false);
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Cut.name())) {
			charge = new CuttingCharge();
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Ink.name())) {
			charge = new InkCharge();
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.Shipping.name())) {
			charge = new ShippingCharge();
		} else {
			charge=new Charge();
		}
		charge.setChargeDefinition(chargeDefinition);
		if (chargeDefinition.getDescriptionDefault() != null &&
				chargeDefinition.getDescriptionDefault().length() > 0) {
			charge.setDescription(chargeDefinition.getDescriptionDefault());
		} else {
			charge.setDescription(chargeDefinition.getName());
		}
		
		if (chargeDefinition.getNotesDefault() != null &&
				chargeDefinition.getNotesDefault().length() > 0) {
			charge.setNotes(chargeDefinition.getNotesDefault());
		}
		
		charge.setShowNotes(chargeDefinition.getShowNotes());
		charge.setFinished(chargeDefinition.getFinished());
		charge.setTaxable(chargeDefinition.getTaxable());
		charge.setBrokered(chargeDefinition.getBrokered());
		charge.setDisplayQty(chargeDefinition.getDisplayQty());
		charge.setHidden(chargeDefinition.getHideChargeInPrintouts());
		charge.setHidePrice(chargeDefinition.getHidePrice());
		charge.setPrice(0.0);
		charge.setSets(chargeDefinition.getRateSetCount());
		charge.setMaterialSets(chargeDefinition.getMaterialSetCount());
		charge.setOverridePrice(false);
		charge.setOverrideQuantity(false);
		charge.setOverrideMaterialQuantity(false);
		charge.setRate(chargeDefinition.getRate());
		charge.setOverrideRate(false);
		charge.setOverrideUp(false);
		charge.setMinimumCharge(chargeDefinition.getMinimum());
		return charge;
	}

}
