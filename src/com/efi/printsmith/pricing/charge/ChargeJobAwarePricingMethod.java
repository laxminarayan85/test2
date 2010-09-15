package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.service.ChargeService;

public class ChargeJobAwarePricingMethod extends ChargePricingMethod{
	@Override
	public Charge priceCharge(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		BigDecimal rate = new BigDecimal(0);
		double lookupQty = 0;
		BigDecimal price = new BigDecimal(0);
		BigDecimal materialPrice = new BigDecimal(0);
		BigDecimal setupPrice = new BigDecimal(0);
		long runs = 0;
		long originals = 0;
		long ups = 0;
		double setCount = 0;
		double materialQty = 0.0;
		double rateQty = 0.0;
		BigDecimal ratePrice = new BigDecimal(0);
		
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
			} else if (charge instanceof CuttingCharge && chargeDefinition.getCutsArePrePress()) {
				charge.setQuantity((double)job.getSheets());
				originals = 1;
				runs = 1;
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
		}
		// TODO account for booklets per PrintSmith Source
		if (chargeDefinition.getPriceMethod().equals("CostPlus")) { 
			ChargeService chargeService = new ChargeService(); //TODO: This needs to be outside of the service.
			
			try {
				ChargeCostingPrices prices = chargeService.calculateChargeCostingRate(chargeDefinition, charge);
				
				if (!charge.getOverrideRate()) {
					charge.setRate(prices.unitPrice);
				}
				
				price = prices.setupPrice.add((charge.getRate().multiply(new BigDecimal(charge.getQuantity()))));
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			
			if (chargeDefinition.getUseSetup()) {
				setupPrice = chargeDefinition.getSetupPrice();
				
				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
					// TODO account for booklets here
				}
			}
			else if (chargeDefinition.getUseMaterial()) {
				if (!charge.getOverrideMaterialQuantity()) {
					if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None.name())) {
						charge.setMaterialQty(1.0);
					}
				}
				
				
				
				if (chargeDefinition.getUseMaterialSets()) {
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
				materialPrice = chargeDefinition.getMaterial().multiply(new BigDecimal(materialQty));
			}
			
			if (chargeDefinition.getUseRate()) {
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
				ratePrice = charge.getRate().multiply(new BigDecimal(rateQty));
//				TODO: additional booklet stuff here
//				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets) ||
//						chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets)) {
//					ratePrice = ratePrice
//				}
			} else if (!chargeDefinition.getUseMaterial() && chargeDefinition.getPriceList() != null) {
				// TODO: Additional booklet code here
				lookupQty = charge.getQuantity();
				ratePrice = new BigDecimal(PriceListUtilities.lookupPrice(chargeDefinition.getPriceList(), (long)lookupQty));
			}
			price = setupPrice.add(materialPrice).add(ratePrice);

			price = price.add(new BigDecimal(PriceListUtilities.calculatePriceListPrice((long)lookupQty, chargeDefinition.getPriceList(), price.doubleValue(), (Job)job)));
		}
		if (chargeDefinition.getUseMinimumCharge() && chargeDefinition.getMinimum().doubleValue() > price.doubleValue()) {
			price = chargeDefinition.getMinimum();
		}
		charge.setPrice(price);
		return charge;
	}

}
