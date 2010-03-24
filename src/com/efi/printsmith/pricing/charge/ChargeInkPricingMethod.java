package com.efi.printsmith.pricing.charge;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeInkCoverage;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.enums.ChargeQtyType;

public class ChargeInkPricingMethod extends ChargePricingMethod {
	protected static Logger log = Logger.getLogger(ChargeInkPricingMethod.class);
	
	public Charge priceCharge(Charge charge) {
		InkCharge localCharge = (InkCharge) charge;
		ChargeDefinition chargeDefinition = localCharge.getChargeDefinition();
		JobBase job = localCharge.getParentJob();
		int colors = 1;
		double area = 0.0;
		long sides = 1;
		long originals = 1;
		long ups = 1;
		long qty = 0;
		double inches = 0.0;
		double pounds = 0.0;
		double price = 0.0;
		
		if (chargeDefinition == null) return localCharge;
		// TODO: Include NewInkCharge call from PrintSmith
		if (job == null) return localCharge;
		
		if (chargeDefinition.getRateSetCount() == 0) {
			price = 0.0;
		} else {
			if (chargeDefinition.getUseColors()) {
				if (job.getFrontColors() > job.getBackColors()) {
					colors = job.getFrontColors();
				} else {
					colors = job.getBackColors();
				}
			}
			
			try {
				if (chargeDefinition.getInkCoverage().equals(ChargeInkCoverage.FinishedArea)) {
					area = PriceListUtilities.getAreaFromSizeString(job.getFinishSize());
				} else { /* Assume Finish Area */
					area = PriceListUtilities.getAreaFromSizeString(job.getRunSize());
				}
			} catch (NumberFormatException e) {
				log.error(e);
			} catch (ParseException e) {
				log.error(e);
			}
			
			if (chargeDefinition.getUseSides()) {
				sides = job.getFrontColors() + job.getBackColors();
			}
			
			if (chargeDefinition.getUseOriginals()) {
				originals = job.getSheets();
			} else if (chargeDefinition.getUseSignatures()) {
				originals = job.getSignatures();
			}
			
			if (chargeDefinition.getUseMultiplyUpCount() || chargeDefinition.getUseDivideByUpCount()) {
				if (chargeDefinition.getAdjustUpsCount() > 0) {
					ups = chargeDefinition.getAdjustUpsCount();
				} else {
					ups = job.getNumUp();
				}
			}
			
			if (chargeDefinition.getJobQty().equals(ChargeQtyType.Quantity)) {
				// TODO account for defCust->InkByImpressions
				qty = job.getPressQty();
			} else if (chargeDefinition.getJobQty().equals(ChargeQtyType.None)) {
				qty = 1;
			} else {
				qty = job.getQtyOrdered();
			}
			
			if (chargeDefinition.getUseMultiplyUpCount()) {
				inches = area * ((qty * sides * originals) * ups);
			} else if (chargeDefinition.getUseDivideByUpCount()) {
				inches = area * ((qty * sides * originals) / ups);
			} else {
				inches = area * (qty * sides * originals);
			}
				
			if (inches == 0) {
				inches = 1;
			}
			
	//		if (localCharge.getOverridePounds()) {
	//			pounds = localCharge.getPoundsOfInk();
	//			if (inches == 0) {
	//				localCharge.setQuantity(0.0);
	//			} else {
	//				localCharge.setQuantity((pounds * chargeDefinition.getRateSetCount())/inches);
	//			}
	//			localCharge.setOverrideMaterialQuantity(false);
	//		} else {
				pounds = (inches * localCharge.getQuantity())/chargeDefinition.getRateSetCount();
	//		}
			
			pounds *= colors;
			
			price = pounds * chargeDefinition.getRate();
			chargeDefinition.setMaterialSetCount(pounds);
		}
		
		if (chargeDefinition.getUseSetup()) {
			price += chargeDefinition.getSetupPrice();
		}
		
		price += PriceListUtilities.calculatePriceListPrice((long)pounds, chargeDefinition.getPriceList(), price, (Job)job);
		
		localCharge.setPrice(price);
		return localCharge;
	}

}
