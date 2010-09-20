package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import com.efi.printsmith.Constants;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeJobQuantity;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.data.enums.RunMethod;
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
			if (job.getRunMethod().equals(Constants.JOB_RUN_METHOD_WORK_TUMBLE)) {
				if (job.getBackColors() > job.getFrontColors()) {
					runs = job.getBackColors();
				} else {
					runs = job.getFrontColors();
				}
			} else {
				runs = job.getBackColors() + job.getFrontColors();
			}
		} else if (chargeDefinition.getUseSides()) {
			if (job.getFrontColors() > 0) runs++;
			if (job.getBackColors() > 0) runs++;
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
			if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.None.name())) {
				charge.setQuantity(1.0);
			} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press.name())) {
				charge.setQuantity(job.getPressQty().doubleValue());
				
				if (!job.getRunMethod().equals(RunMethod.WorkAndTurn)) {
					if (job.getRunMethod().equals(RunMethod.WorkAndTumble) && !(charge instanceof CuttingCharge)) {
						charge.setQuantity(charge.getQuantity()*0.5);
					} else if (job.getRunMethod().equals(RunMethod.WorkAndTurn) && chargeDefinition.getCutsArePrePress() && !(charge instanceof InkCharge)) {
						if (originals > 1) {
							originals /= 2;
						} else {
							charge.setQuantity(charge.getQuantity()*0.5);
						}
					}
				}
			} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Parent.name())) {
				charge.setQuantity((double)job.getSheets());
				originals = 1;
				runs = 1;
			} else {
				charge.setQuantity(job.getQtyOrdered().doubleValue());
			}
		
			if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() ||
				chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getCutsArePrePress()) {
				charge.setQuantity(charge.getQuantity()*runs*originals);
			}
			
			if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) {
				if (chargeDefinition.getUseMultiplyUpCount()) {
					charge.setQuantity(charge.getQuantity()*ups);
				} else if (chargeDefinition.getUseDivideByUpCount()) {
					charge.setQuantity(charge.getQuantity()/ups);
				}
			}
			
			if ((chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press) &&
					job != null && job.getPricingMethod().getMethod().equals("Multi Part")) {
				chargeDefinition.setCutsArePrePress(true);
				charge.setQuantity(new Double(job.getBinderyWaste()+job.getEstWaste())*runs);
			}
		}
		if (!charge.getOverrideMaterialQuantity()) {
			if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.None.name())) {
				charge.setMaterialQty(1.0);
			} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press.name())) {
				charge.setMaterialQty(job.getPressQty().doubleValue());
				
				if (!job.getRunMethod().equals(RunMethod.WorkAndTurn)) {
					if (job.getRunMethod().equals(RunMethod.WorkAndTumble) && !(charge instanceof CuttingCharge)) {
						charge.setMaterialQty(charge.getMaterialQty()*0.5);
					} else if (job.getRunMethod().equals(RunMethod.WorkAndTurn) && chargeDefinition.getCutsArePrePress() && !(charge instanceof InkCharge)) {
						if (originals > 1) {
							originals /= 2;
						} else {
							charge.setMaterialQty(charge.getMaterialQty()*0.5);
						}
					}
				}
			} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Parent.name())) {
				charge.setMaterialQty((double)job.getSheets());
				originals = 1;
				runs = 1;
			} else {
				charge.setMaterialQty(job.getQtyOrdered().doubleValue());
			}
		
			if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() ||
				chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getCutsArePrePress()) {
				charge.setMaterialQty(charge.getMaterialQty()*runs*originals);
			}
			
			if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) {
				if (chargeDefinition.getUseMultiplyUpCount()) {
					charge.setMaterialQty(charge.getMaterialQty()*ups);
				} else if (chargeDefinition.getUseDivideByUpCount()) {
					charge.setMaterialQty(charge.getMaterialQty()/ups);
				}
			}
			
			if ((chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press) &&
					job != null && job.getPricingMethod().getMethod().equals("Multi Part")) {
				chargeDefinition.setCutsArePrePress(true);
				charge.setMaterialQty(new Double(job.getBinderyWaste()+job.getEstWaste()));
			}
		}

		if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() || chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getCutsArePrePress()) {
			// Multiply before mote these quantities are already used to calculate rate & material quantity. This means that the runs and originals have already been used so they must be set to one to avoid squaring quantities.
			runs = 1;
			originals = 1;
		}
		
		
		if (chargeDefinition.getPriceMethod().equals("CostPlus")) { 
			ChargeService chargeService = new ChargeService(); //TODO: This needs to be outside of the service.
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
			
//			TODO: Handle Booklets here			
//			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) ||
//				chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
//				lookupQty *= job.getGroupQty();
//			}
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
				if (chargeDefinition.getUseMaterialSets()) {
					setCount = chargeDefinition.getMaterialSetCount();
				} else {
					setCount = 1.0;
				}
				
				if (charge.getOverrideMaterialQuantity()) {
					materialQty = charge.getMaterialQty(); 
				} else {
					materialQty =  calculateChargeSets(charge.getMaterialQty(), runs, originals, setCount);
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
