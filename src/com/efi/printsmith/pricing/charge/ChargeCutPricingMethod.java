package com.efi.printsmith.pricing.charge;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeQtyType;

public class ChargeCutPricingMethod extends ChargePricingMethod {
	final int parentToRun = 0;
	final int runToFinish = 1;
	final int parentToFinish = 2;
	
	@Override
	public Charge priceCharge(Charge charge) {
		CuttingCharge localCharge = (CuttingCharge) charge;
		ChargeDefinition chargeDefinition = localCharge.getChargeDefinition();
		JobBase job = localCharge.getParentJob();
		int jobQty = 1;
		double price = 0.0;
		
		if (charge.getParentJob() == null) {
			if (!charge.getOverrideQuantity()) {
				charge.setQuantity(0.0);
			}
		} else {
			if (!charge.getOverrideQuantity()) {
				if (chargeDefinition.getCutsArePrePress()) {
					charge.setQuantity(new Double(GetCutCount(job, charge, parentToRun)));
				} else {
					charge.setQuantity(new Double(GetCutCount(job, charge, runToFinish)));
				}
				if (chargeDefinition.getIgnoreCuts() && charge.getQuantity() > 0) {
					charge.setQuantity(1.0);
				}
			}
		}
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets.name()) ||
				chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name()))	{
			chargeDefinition.setQuantityType(ChargeQtyType.Sets.name()); // From PS - seems odd, but shouldn't cause problems
		}
		
		ChargeJobAwarePricingMethod jobAwareMethod = new ChargeJobAwarePricingMethod();
		
		if (chargeDefinition == null) return localCharge;
		// TODO: Handle multi-part jobs per PS
				
		// TODO: Handle cuts are pre-press
		charge = jobAwareMethod.priceCharge(charge);
		
		return charge;
	}
	//********************************************************************************
	//	GetCutCount
	//********************************************************************************
	public long GetCutCount(JobBase job, Charge charge, int action)
	{
		long	cuts = 0;
		long	cutsrun;
		long	cutsfinish;
		
		if (job == null)
		{	// if there's no job - just return the quantity thats in the charge
			cuts = charge.getQuantity().longValue();
			return(cuts);
		}
		
		switch (action)
		{
			case parentToFinish:
				break;
				
			case parentToRun:
				cuts = job.getPaperCal().getCutstoRun();
				break;
				
			case runToFinish:
				cuts = job.getPaperCal().getCutstoFinish();
				break;
		}
		
		return(cuts);
	}
}
