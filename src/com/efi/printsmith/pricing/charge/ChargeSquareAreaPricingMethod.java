package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeJobQuantity;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeSquareAreaPricingMethod extends ChargePricingMethod {
	@Override
	public Charge priceCharge(Charge charge) {
		
		BigDecimal	price;
		double	totalArea = 0;
		double	inches;
		double	colors;
		double	area = 0.0;
		double 	sides;
		double	originals;
		double	ups;
		double	qty;
			
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		JobBase job = charge.getParentJob();
		
		if (chargeDefinition.getArea() == 0.0) {
			price = new BigDecimal(0.0);
		} else {
			if (job == null) {
				colors = 1;
			} else {
				if (chargeDefinition.getUseColors()) {
					colors = job.getFrontColors() + job.getBackColors();
					if (colors < 1)
						colors = 1;
				} else {
					colors = 1;
				}
				
				if (job.getPaperCal() != null) {
					if (chargeDefinition.getUseRunArea() || chargeDefinition.getInkCoverage() == "0") {
						if (job.getRunSize() != null) {
							area = (job.getRunSize().getWidth() * job.getRunSize().getHeight());
						}
					} else {
						if (job.getFinishSize() != null) {
							area = (job.getFinishSize().getWidth() * job.getFinishSize().getHeight());
						}
					}
				} else {
					area = 1;
				}
				
				if (chargeDefinition.getUseSides()) {
					sides = 0;
					if (job.getFrontColors() > 0) sides++;
					if (job.getBackColors() > 0) sides++;
				} else {
					sides = 1;
				}
				
				if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets)) {
					// TODO: Handle sets based on this printsmith snippet:
//					//
//					// use the sets as defined by the user, the sets in this case means sides
//					//
//						if (q->oCqty) {
//							if (q->groupQty >= 1 && q->groupQty <= 2)		// in reason
//								sides = q->groupQty;
//							else
//								q->groupQty = sides;
//						} else {
//							q->groupQty = sides;
//						}
//			
				}
				
				if (chargeDefinition.getUseOriginals()) {
					originals = job.getSheets();
				} else if (chargeDefinition.getUseSignatures()) {
					originals = job.getSignatures();
				} else {
					originals = 1;
				}
				
				if (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount()) {
					ups = charge.getUp(); 
				} else {
					ups = 1;
				}
				
				if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.Press)) {
					qty = job.getPressQty();
				} else if (chargeDefinition.getJobQty().equals(ChargeJobQuantity.None)) {
					qty = 1;
				} else {
					qty = job.getQtyOrdered();
				}
				
				if (charge.getOverrideQuantity()) {
					qty = charge.getQuantity();
				} else {
					charge.setQuantity(qty);
				}
				
				if (chargeDefinition.getUseMultiplyUpCount()) {
					inches = area * ((qty * sides * colors * originals) * ups);
				} else if (chargeDefinition.getUseDivideByUpCount()) {
					inches = area * ((qty * sides * colors * originals) / ups);
				} else {
					inches = area * (qty * sides * colors * originals);
				}
				
				if (inches == 0) {
					inches = 1;
				}
				
				totalArea = inches/chargeDefinition.getArea();
			}
			
			if (charge.getOverrideMaterialQuantity()) {
				totalArea = charge.getMaterialSets();
			} else {
				charge.setMaterialSets(totalArea);
			}
			((SquareAreaCharge)charge).setArea(totalArea);
			price = charge.getRate().multiply(new BigDecimal(totalArea));
		}
		
		if (chargeDefinition.getUseSetup()) {
			price = price.add(chargeDefinition.getSetupPrice());
		}


		price = price.add(new BigDecimal(PriceListUtilities.lookupPrice(chargeDefinition.getPriceList(), charge.getQuantity().longValue())));

		if (!charge.getOverridePrice()) {
			charge.setPrice(price);
		}
				
		return charge;
	}

}
