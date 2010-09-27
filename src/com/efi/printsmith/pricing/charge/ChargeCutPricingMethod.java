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
		
		if (localCharge.getParentJob() == null) {
			if (!localCharge.getOverrideQuantity()) {
				localCharge.setQuantity(0.0);
			}
		} else {
			if (!localCharge.getOverrideQuantity()) {
				if (chargeDefinition.getCutsArePrePress()) {
					localCharge.setQuantity(new Double(GetCutCount(job, localCharge, parentToRun)));
				} else {
					localCharge.setQuantity(new Double(GetCutCount(job, localCharge, runToFinish)));
				}
				if (chargeDefinition.getIgnoreCuts() && localCharge.getQuantity() > 0) {
					localCharge.setQuantity(1.0);
				}
				localCharge.setCuts(localCharge.getQuantity().intValue());
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
		localCharge = (CuttingCharge)jobAwareMethod.priceCharge(localCharge);
		
		return localCharge;
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
