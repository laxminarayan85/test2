package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;
import java.util.Iterator;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeShippingPricingMethod extends ChargePricingMethod {
	@Override
	public Charge priceCharge(Charge charge) {
		BigDecimal		price = new BigDecimal(0.0);
		double		weight;
		double		markup;
		double		factor;

		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		JobBase job = charge.getParentJob();
		
		if (chargeDefinition == null) return charge;
		
		if (charge.getOverrideQuantity()) {
			weight = charge.getQuantity();
		} else if (job == null) {
			if (charge.getParentInvoice() != null) {
				weight = CalculateInvWeight(charge.getParentInvoice());
			} else {
				weight = 0;
			}
		} else {
			weight = job.getWeight();
		}

		markup = chargeDefinition.getRateSetCount();
		if (markup == 0) {
			markup = 1;
		}
					
//			//
//			// test to see if factors have changed which indicate that a new price should
//			//	be looked up in Shipping Link
//			//
//			if (cp->charge.q.rateQty != weight)
//			{
//				cp->charge.q.needLinkPrice = 1;
//			}

		if (job != null && chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) && job.getQtyOrdered() != 0 && chargeDefinition.getGroupQty() != 0) {
			factor = chargeDefinition.getGroupQty()/job.getQtyOrdered();
			weight *= factor;
		}
		
		charge.setQuantity(weight);
		
		if (chargeDefinition.getUseRate()) {
			price = chargeDefinition.getRate().multiply(new BigDecimal(weight));
		}
		
		if (chargeDefinition.getUseSetup()) {
			price = price.add(chargeDefinition.getSetupPrice());
		}
		
		price = price.add(new BigDecimal(PriceListUtilities.lookupPrice(chargeDefinition.getPriceList(), new Double(weight).longValue())));

		if (chargeDefinition.getUseRateSets()) {
			price = price.multiply(new BigDecimal(markup));
		}
		
		if (!charge.getOverridePrice()) {
			charge.setPrice(price);
		}
		return charge;
	}
	//********************************************************************************
	//	CalculateInvWeight
	//********************************************************************************
	static double CalculateInvWeight(InvoiceBase invoice)
	{
		JobBase 	job;
		double 		wt = 0;
		Iterator<JobBase> jobIterator =  invoice.getJobs().iterator();
		
		while (jobIterator.hasNext()) {
			job = jobIterator.next();
			
			wt += job.getWeight();
		}
		return(wt);
	}

}
