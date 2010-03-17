package com.efi.printsmith.pricing.charge;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeQtyType;

public abstract class ChargePricingMethod {
	protected static Logger log = Logger.getLogger(ChargePricingMethod.class);

	public abstract Charge priceCharge(Charge charge);
	
	public Charge calculateCost(Charge charge) {
		return charge;
	}
	
	public Charge calculateQty(Charge charge) {
		if (charge.getOverrideQuantity()) return charge; // User changed the Quantity manually - leave it alone
		
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		if (chargeDefinition == null) {
			log.error("Null ChargeDefinition in Charge.");
			return charge;
		}

		JobBase job = charge.getParentJob();
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None.name())) {
			charge.setQuantity(1.0);
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets.name())) {
			job.getInSetsOf();
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets.name())) {
		
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Time.name())) {
		
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Quantity.name())) {
		
		} else {
			log.error("Invalid ChargeQtyType in Charge: " + chargeDefinition.getQuantityType());
		}
		return charge;
	}
	
	protected long calculateChargeSets(double quantity, long runs, long originals,  double setCount) {
		long retVal = 0;
		
		if (quantity != 0.0 && setCount != 0.0) {
			if (setCount < 0.0) {
				setCount = 1.0;
			}
						
			if (quantity < setCount) {
				retVal = 1;
			} else {
				double wholeValue = quantity/setCount;
				retVal = (long)wholeValue;
				if (retVal != wholeValue) {
					retVal++; // There was a fractional value - increment to account for it
				}
			}
			retVal = retVal * runs * originals;
		}

		return retVal;
	}
}
