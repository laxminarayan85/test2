package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeJobQuantity;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.data.enums.RunMethod;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeLinearPricingMethod extends ChargePricingMethod {
	@Override
	public Charge priceCharge(Charge charge) {
		BigDecimal		price = new BigDecimal(0.0);	// 
		BigDecimal		materialPrice = new BigDecimal(0.0);	// material price
		BigDecimal		ratePrice = new BigDecimal(0.0);	// rate price
		double			mQty;			// quantity to look up in price list
		double			rQty;			// quantity to look up in price list
		double			lQty = 0.0;			// quantity to look up in price list
		double			inches;			// 
		long			runs;			// local runs count
		long			originals;		// local originals count
		long			ups;			// local ups count
		double			setCount;		// local use set count
		JobBase job = charge.getParentJob();
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		if (job == null)
		{	// setup
			runs = 1;
			originals = 1;
			ups = 1;
			inches = 0;
			if (!charge.getOverrideQuantity()) {	// clip to minimum of 1
				charge.setQuantity(1.0);
			}
			if (!charge.getOverrideMaterialQuantity()) {	// clip to minimum of 1
				charge.setMaterialQty(1.0);
			}
		}
		else
		{	// normal path
			if (chargeDefinition.getUseOriginals() && chargeDefinition.getUseSignatures())  {	// and clear old one - indicates a bug - this makes sure it's ok
				chargeDefinition.setUseOriginals(false);
			}
			
			//
			// copy runs to local storage
			//
			if (chargeDefinition.getUseColors())
			{
				if (job.getRunMethod().equals(RunMethod.Sheetwise)) {
					if (job.getBackColors() > job.getFrontColors()) {
						runs = job.getBackColors();
					} else {
						runs = job.getFrontColors();
					}
				} else {
					runs = job.getFrontColors() + job.getBackColors();
				}
			}
			else if (chargeDefinition.getUseSides()) {
				runs = 0;
				if (job.getFrontColors() > 0) runs ++;
				if (job.getBackColors() >0) runs++;
			}
			else {	// clip to minimum of 1
				runs = 1;
			}
			
			//
			// copy originals to local storage
			//
			if (chargeDefinition.getUseOriginals())
			{
				originals = job.getSheets();
			}
			else if (chargeDefinition.getUseSignatures()) {
				originals = job.getSignatures();
			}
			else {	// clip to minimum of 1
				originals = 1;
			}
			
			//
			// copy ups to local storage
			//
			if (chargeDefinition.getAdjustUpsCount() > 0) {
				ups = chargeDefinition.getAdjustUpsCount();
			} else {
				ups = job.getNumUp();
			}
			
			//
			// What area to use (Run or Finish)
			//
			inches = 0.0;
			if (chargeDefinition.getUseRunArea()) {
				if (job.getRunSize() != null) {
					if (charge.getLinearX1())
						inches += job.getRunSize().getWidth();
					if (charge.getLinearX1())
						inches += job.getRunSize().getWidth();
					if (charge.getLinearY1())
						inches += job.getRunSize().getHeight();
					if (charge.getLinearY2())
						inches += job.getRunSize().getHeight();
				}
			} else {
				if (job.getFinishSize() != null) {
					if (charge.getLinearX1())
						inches += job.getFinishSize().getWidth();
					if (charge.getLinearX1())
						inches += job.getFinishSize().getWidth();
					if (charge.getLinearY1())
						inches += job.getFinishSize().getHeight();
					if (charge.getLinearY2())
						inches += job.getFinishSize().getHeight();
				}
			}
			
			//***********************************************************************************
			//	NOTE: The number of sheets per set (NCR) is only used for press counts where 
			//	it is already included. The assumption here is that operations on the finish 
			//	count will be performed on the entire set. This needs to be clearly documented.
			//***********************************************************************************
			if (!charge.getOverrideQuantity())
			{	
				if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.None)) {
					charge.setQuantity(1.0);
				} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press)) {
					charge.setQuantity(job.getPressQty() * inches);
					
					if (!job.getRunMethod().equals(RunMethod.WorkAndTurn)) {
						if (job.getRunMethod().equals(RunMethod.Sheetwise)) { // TODO: Find out about hidden preference for adjWorkNTurn
							if (originals > 1) {
								originals /= 2;
							}
							else {
								charge.setQuantity(charge.getQuantity() / 2);
							}
						}
					}
				} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Parent)) { // special qty for prepress cuts
					charge.setQuantity(job.getSheets() * inches);
					originals = 1;
					runs = 1;
				} else {
					charge.setQuantity(job.getQtyOrdered() * inches);
				}
				
				if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() || chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getBinderyCharge()) {
					charge.setQuantity(charge.getQuantity() * runs * originals);
				}
				
				if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) { // apply mul or div Ups
					if (chargeDefinition.getUseMultiplyUpCount()) {	// apply mul Ups (useDivideUpCnt should not be set ... if it is, a defect exists (elsewhere))
						charge.setQuantity(charge.getQuantity() * ups);
					} else if (chargeDefinition.getUseDivideByUpCount() && ups != 0) {	// apply div Ups (useMultiplyUpCnt should not be set ... if it is, a defect exists (elsewhere))
						charge.setQuantity(charge.getQuantity() / ups);
					}
				}
				
// TODO: Handle multi-part pricing 
//				if ((chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press) && job != null &&
//						job.getPricingMethod().equals "booklet") {
//					def->multBefore = 1;					// force setting for this type of job
//					q->rateQty = job->job.waste * runs;			// special value for booklets
//				}
			}

			if (!chargeDefinition.getOverrideMaterialQty()) {
				if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.None)) {
					charge.setMaterialQty(1.0);
				} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press)) {
					chargeDefinition.setMaterialQty(job.getPressQty() * inches);
					if (!job.getRunMethod().equals(RunMethod.WorkAndTurn)) {
						if (job.getRunMethod().equals(RunMethod.Sheetwise)) { // TODO: Find out about hidden preference for adjWorkNTurn
							charge.setMaterialQty(charge.getMaterialQty()*0.5);
						}
					}
				} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Parent)) {
					charge.setMaterialQty(job.getSheets() * job.getInSetsOf() * inches);
					originals = 1;
					runs = 1;
				} else {
					charge.setMaterialQty(job.getQtyOrdered() * inches);
				}
				
				if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() || chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getBinderyCharge()) {
					charge.setMaterialQty(charge.getMaterialQty()*runs*originals);
				}
				
				if (ups > 0 && (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount())) {
					if (chargeDefinition.getUseMultiplyUpCount()) {	// apply mul Ups (useDivideUpCnt should not be set ... if it is, a defect exists (elsewhere))
						charge.setMaterialQty(charge.getQuantity() * ups);
					} else if (chargeDefinition.getUseDivideByUpCount() && ups != 0) {	// apply div Ups (useMultiplyUpCnt should not be set ... if it is, a defect exists (elsewhere))
						charge.setMaterialQty(charge.getQuantity() / ups);
					}
				}
				
				// TODO: Handle multi-part pricing 
//				if ((chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press) && job != null &&
//						job.getPricingMethod().equals "booklet") {
//					def->multBefore = 1;					// force setting for this type of job
//					q->matQty = job->job.waste * runs;			// special value for booklets
//				}
			}
	
			if ((chargeDefinition.getUseColors() || chargeDefinition.getUseSides() || chargeDefinition.getUseOriginals() || chargeDefinition.getUseSignatures()) && chargeDefinition.getBinderyCharge()) {
				runs = 1;
				originals = 1;
			}
		}

		//
		// calculate the price elements
		//
		if (chargeDefinition.getUseSetup()) {
			materialPrice = chargeDefinition.getMaterial();
			
			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets) && chargeDefinition.getGroupQty() != 0) {
				materialPrice = materialPrice.multiply(new BigDecimal(chargeDefinition.getGroupQty()));
			}
		} else if (chargeDefinition.getUseMaterial()) {
			if (chargeDefinition.getUseMaterialSets()) {
				setCount = chargeDefinition.getMaterialSetCount();
			} else {
				setCount = 1.0;
			}
			
			if (charge.getOverrideMaterialQuantity()) {
				mQty = charge.getMaterialQty();
			} else {
				mQty = chargeDefinition.getBaseLinearNumber() + calculateChargeSets(charge.getMaterialQty(), runs, originals, setCount);
			}
			lQty = mQty;
			charge.setMaterialQty(mQty);
			materialPrice = chargeDefinition.getMaterial().multiply(new BigDecimal(mQty));
		}
		
		if (chargeDefinition.getUseRate()) {
			if (chargeDefinition.getUseRateSets()) {
				setCount = chargeDefinition.getRateSetCount();
			} else {
				setCount = 1.0;
			}
			if (charge.getOverrideQuantity()) {
				rQty = charge.getQuantity();
				lQty = rQty;			// use this to lookup in price list
			} else {
				if (chargeDefinition.getUseRateSets())		// this would round a number when rateqty is less than 1 (0.833)
					rQty = chargeDefinition.getBaseLinearNumber() + calculateChargeSets(charge.getQuantity(), runs, originals, setCount);
				else
					rQty = charge.getQuantity();
				lQty = rQty;			// use this to lookup in price list
			}
			charge.setQuantity(lQty);
			
			ratePrice = chargeDefinition.getRate().multiply(new BigDecimal(charge.getQuantity()));
			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) || chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
				ratePrice = ratePrice.multiply(chargeDefinition.getRate());
				lQty *= chargeDefinition.getGroupQty();
			}
		} else if (!chargeDefinition.getUseMaterial() && chargeDefinition.getPriceList() != null) {
			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) || chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
				lQty = charge.getQuantity() * chargeDefinition.getGroupQty();
			} else {
				lQty = charge.getQuantity();
			}
		} else if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus)) {
			if (chargeDefinition.getUseRateSets()) {
				setCount = chargeDefinition.getRateSetCount();
			} else {
				setCount = 1.0;
			}
			if (charge.getOverrideQuantity()) {
				rQty = charge.getQuantity();
			} else {
				rQty = chargeDefinition.getBaseLinearNumber() + calculateChargeSets(charge.getQuantity(), runs, originals, setCount);
			}
			lQty = rQty;
			charge.setQuantity(rQty);
			if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) || chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
				lQty = lQty * chargeDefinition.getGroupQty();
			}
		}

		price = materialPrice.add(ratePrice);
		price = price.add(new BigDecimal(PriceListUtilities.lookupPrice(chargeDefinition.getPriceList(), new Double(lQty).longValue())));
		
		if (!charge.getOverridePrice()) {
			charge.setPrice(price);
		}
		return charge;
	}

}
