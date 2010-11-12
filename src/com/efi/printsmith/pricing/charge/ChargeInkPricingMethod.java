package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.enums.ChargeInkCoverage;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.service.ChargeService;
import com.efi.printsmith.data.enums.ChargeQtyType;

public class ChargeInkPricingMethod extends ChargePricingMethod {
	protected static Logger log = Logger.getLogger(ChargeInkPricingMethod.class);
	
	@Override
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
		double rateSetCount = 1.0;
		BigDecimal price = new BigDecimal(0.0);
		BigDecimal costingSetup = new BigDecimal(0.0);
		BigDecimal costingMaterialPrice = new BigDecimal(0.0);
		
		if (chargeDefinition == null) return localCharge;
		// TODO: Include NewInkCharge call from PrintSmith
		if (job == null) return localCharge;
		
		if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus.name())) {
			ChargeService chargeService = new ChargeService(); //TODO: This needs to be outside of the service.
			
			try {
				ChargeCostingPrices prices = chargeService.calculateChargeCostingRate(chargeDefinition, charge);
				
				if (!localCharge.getOverrideRate()) {
					localCharge.setRate(prices.unitPrice);
				}
				costingSetup.add(prices.setupPrice).add(prices.materialSetupPrice);
				costingMaterialPrice = prices.materialUnitPrice;
			} catch (Exception e) {
				log.error(e);
			}			
		}
		if (chargeDefinition.getRateSetCount() != null && chargeDefinition.getRateSetCount() == 0) {
			price = new BigDecimal(0.0);
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
			
//			if (localCharge.getOverridePounds()) {
//				pounds = localCharge.getPoundsOfInk();
//				if (inches == 0) {
//					localCharge.setQuantity(0.0);
//				} else {
//					localCharge.setQuantity((pounds * chargeDefinition.getRateSetCount())/inches);
//				}
//				localCharge.setOverrideMaterialQuantity(false);
//			} else {
			if (chargeDefinition.getRateSetCount() != null) {
				rateSetCount = chargeDefinition.getRateSetCount();
			}
				pounds = (inches * localCharge.getCoverage())/rateSetCount;
//			}
			
			pounds *= colors;
			
			price = new BigDecimal(pounds * localCharge.getRate().doubleValue());
			localCharge.setPoundsOfInk(pounds);
			chargeDefinition.setMaterialSetCount(pounds);
		}
		if (chargeDefinition.getPriceMethod().equals(ChargePriceMethod.CostPlus.name())) {
			price = price.add(costingSetup);
			price = price.add(costingMaterialPrice.multiply(new BigDecimal(charge.getMaterialQty()))); 
		} else {
			if (chargeDefinition.getUseSetup()) {
				price = price.add(chargeDefinition.getSetupPrice());
			}
			price = price.add(new BigDecimal(PriceListUtilities.calculatePriceListPrice((long)pounds, chargeDefinition.getPriceList(), price.doubleValue(), (Job)job)));
		}
		
		localCharge.setPrice(price);
		return localCharge;
	}

}
