package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

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
	
	protected BigDecimal calculatePriceListPrice(Charge charge) {
		double rate = 0.0;
		BigDecimal price = new BigDecimal(0.0);
		
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		if (chargeDefinition == null) return price;

		PriceList priceList = chargeDefinition.getPriceList();
		if (priceList == null) return price;
		
		if (charge.getOverridePrice()) return price;
		
		if (!chargeDefinition.getMethod().equals(ChargeMethod.PriceList.name()) && priceList.getLastItemIsPriceAdditionalQty()) {
			PriceListElement element = priceList.getElements().get(priceList.getElements().size()-1);
			long tmpQty = element.getQuantity();
			element.setQuantity(0L);
			priceList.setLastItemIsPriceAdditionalQty(false);
			rate = PriceListUtilities.lookupPrice(priceList, charge.getQuantity().longValue());
			priceList.setLastItemIsPriceAdditionalQty(true);
			element.setQuantity(tmpQty);
		} else {
			rate = PriceListUtilities.lookupPrice(priceList, charge.getQuantity().longValue());
		}
		
		if (chargeDefinition.getMethod().equals(ChargeMethod.PriceList.name())) {
			price = new BigDecimal(rate);
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.RateList.name())) {
			price = new BigDecimal(charge.getQuantity() * rate);
		} else if (priceList.getIsPercentage()) {
			price = charge.getPrice().multiply(new BigDecimal(rate));
		} else if (priceList.getIsDiscount()) {
			if (charge.getParentJob() != null) {
				price = charge.getParentJob().getPricingRecord().getTotalPrice().multiply(new BigDecimal(rate));
			}
		} else {
			price = new BigDecimal(rate);
		}
		return price;		
	}
}
