package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeJobAwarePricingMethod extends ChargePricingMethod {
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		double rate = 0;
		double lookupQty = 0;
		double price = 0;
		double materialPrice = 0;
		double setupPrice = 0;
		long runs = 0;
		long originals = 0;
		long ups = 0;
		double setCount = 0;
		double materialQty = 0.0;
		double rateQty = 0.0;
		double ratePrice = 0.0;
		
		JobBase job = charge.getParentJob();
		
		if (chargeDefinition == null || job == null) {
			return charge;
		}
		
		if (chargeDefinition.getUseColors()) {
			runs = job.getBackColors() + job.getFrontColors();
		} else if (chargeDefinition.getUseSides()) {
			if (job.getDoubleSided()) {
				runs = 2;
			} else {
				runs = 1;
			}
		} else {
			runs = 1;
		}
		
		if (chargeDefinition.getUseOriginals()) {
			originals = job.getSheets();
		} else if (chargeDefinition.getUseSignatures()) {
			originals = job.getSignatures();
		} else {
			originals = 1;
		}
		
		if (chargeDefinition.getUseMultiplyUpCount()) {
			if (chargeDefinition.getAdjustUps()) {
				ups = charge.getUp();
			} else {
				ups = job.getNumUp();
			}
		}
			
		if (!charge.getOverrideQuantity()) {
			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None)) {
				charge.setQuantity(1.0);
			} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Quantity)) {
				charge.setQuantity(job.getPressQty().doubleValue());
				// TODO handle run direction per PrintSmith Source
			} else {
				charge.setQuantity(job.getQtyOrdered().doubleValue());
			}
			
//			if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() ||
//				chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures() && )
			if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) {
				if (chargeDefinition.getUseMultiplyUpCount()) {
					charge.setQuantity(charge.getQuantity()*ups);
				} else if (chargeDefinition.getUseDivideByUpCount()) {
					charge.setQuantity(charge.getQuantity()/ups);
				}
			}
			
			// TODO account for booklets per PrintSmith Source

			if (!charge.getOverrideMaterialQuantity()) {
				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None)) {
					charge.setMaterialQty(1.0);
				} else {
					charge.setMaterialQty(job.getQtyOrdered().doubleValue());
				} // TODO Additional cases to account for sets
			}
			
//			if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() ||
//			chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures() && )
			
			if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) {
				if (chargeDefinition.getUseMultiplyUpCount()) {
					charge.setMaterialQty(charge.getMaterialQty()*ups);
				} else if (chargeDefinition.getUseDivideByUpCount()) {
					charge.setMaterialQty(charge.getMaterialQty()/ups);
				}
			}
			// TODO account for booklets per PrintSmith Source
			
			if (chargeDefinition.getUseSetup()) {
				setupPrice = chargeDefinition.getSetupPrice();
				
				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
					// TODO account for booklets here
				}
			}
			else if (chargeDefinition.getUseMaterial()) {
				if (chargeDefinition.getUseMerchandiseSets()) {
					setCount = chargeDefinition.getMaterialSetCount();
				} else {
					setCount = 1.0;
				}
				if (charge.getOverrideMaterialQuantity()) {
					materialQty = charge.getMaterialQty();
				} else {
					materialQty = calculateChargeSets(charge.getMaterialQty(), runs, originals, setCount);
				}
				lookupQty = materialQty;
				charge.setMaterialQty(materialQty);
				materialPrice = materialQty * chargeDefinition.getMaterial();
			}
			
			if (chargeDefinition.getUseRate() || true) { // TODO: remove the || true when cost plus is entered!!!
				if (chargeDefinition.getUseRateSets()) {
					setCount = chargeDefinition.getRateSetCount();
				} else {
					setCount = 1.0;
				}
				if (charge.getOverrideQuantity()) {
					rateQty = charge.getQuantity();
				} else {
					rateQty = calculateChargeSets(charge.getQuantity(), runs, originals, setCount);
				}
				lookupQty = rateQty;
				charge.setQuantity(rateQty);
				ratePrice = rateQty * charge.getRate();
//				TODO: additional booklet stuff here
//				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets) ||
//						chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets)) {
//					ratePrice = ratePrice
//				}
			} else if (!chargeDefinition.getUseMaterial() && chargeDefinition.getPriceList() != null) {
				// TODO: Additional booklet code here
				lookupQty = charge.getQuantity();
				ratePrice = PriceListUtilities.lookupPrice(chargeDefinition.getPriceList(), (long)lookupQty);
			}
			// TODO Cost Plus code here
			
			price = setupPrice + materialPrice + ratePrice;

			price += PriceListUtilities.calculatePriceListPrice((long)lookupQty, chargeDefinition.getPriceList(), price, (Job)job);
			
			charge.setPrice(price);
			
		}
		return charge;
	}

}
