package com.efi.printsmith.pricing.charge;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCostingRecord;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.RateTable;
import com.efi.printsmith.data.enums.ChargeCostMethod;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.ChargePriceMethod;
import com.efi.printsmith.data.enums.ChargeQtyType;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class ChargeCostUtilities {
	protected static Logger log = Logger.getLogger(ChargeInkPricingMethod.class);

	static void updateChargeCost(Charge charge) {
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		double totalCost = 0.0;
		
		if (chargeDefinition == null) {
			log.error("Null ChargeDefinition when costing charge");
			return;
		}
		
		String methodStr = chargeDefinition.getMethod();
		
		if (methodStr.equals(ChargeCostMethod.NoCost)) {
			totalCost = 0.0;
		} else if (methodStr.equals(ChargeCostMethod.HundredPercent)) {
			totalCost = charge.getPrice();
		} else if (methodStr.equals(ChargeCostMethod.UnitCost)) {
			if (chargeDefinition.getMethod().equals(ChargeMethod.Ink)) {
				updateInkChargeCost(charge, chargeDefinition);
			} else if (chargeDefinition.getMethod().equals(ChargeMethod.SquareArea)) {
				updateSquareAreaChargeCost(charge, chargeDefinition);
			} else if (chargeDefinition.getMethod().equals(ChargeMethod.FlatRate)) {
				updateFlatAreaChargeCost(charge, chargeDefinition);
			} else {
				updateGenericUnitCostCharge(charge, chargeDefinition);
			}
		} else if (methodStr.equals(ChargeCostMethod.TimeAndMaterial)) {
			updateTimeMaterialChargeCost(charge, chargeDefinition);
		}
	}
	
	static private void updateTimeMaterialChargeCost(Charge charge, ChargeDefinition chargeDefinition) {
		ChargeCostingRecord chargeCostingRecord = charge.getChargeCostingRecord();
		
		if (chargeCostingRecord == null) return;
		if (chargeDefinition.getChargeCost() == null) return;

		chargeCostingRecord.setActualUnitCount(getChargeUnitQuantity(charge));
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None) &&
				chargeDefinition.getMethod().equals(ChargeMethod.FlatRate)) {
			chargeCostingRecord.setActualUnitCount(1.0);
		}
		
		if (chargeDefinition.getMethod().equals(ChargeMethod.SquareArea)) {
			chargeCostingRecord.setActualUnitCount(chargeCostingRecord.getActualUnitCount()/chargeDefinition.getRateSetCount());
		}
				
		chargeCostingRecord.setActualMaterials(chargeDefinition.getChargeCost().getSetupCost());
		chargeCostingRecord.setActualMaterials(chargeCostingRecord.getActualMaterials() + (chargeCostingRecord.getActualUnitCount()*chargeDefinition.getChargeCost().getUnitMaterials()));
	
		double lookupValue = 0.0;
		if (chargeDefinition.getChargeCost().getSpeedTable() != null) {
			lookupValue = PriceListUtilities.lookupPrice(chargeDefinition.getChargeCost().getSpeedTable(), chargeCostingRecord.getActualUnitCount().longValue());
		} else { 
			lookupValue = chargeDefinition.getChargeCost().getPiecesPerHour();
		}
		
		if (lookupValue == 0.0) lookupValue = 1.0;
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Time)) {
			chargeCostingRecord.setRunTime(chargeCostingRecord.getActualUnitCount()/lookupValue);
			chargeCostingRecord.setSetupTime(chargeDefinition.getChargeCost().getSetupMinutes()/60);
			chargeCostingRecord.setLaborCost(chargeCostingRecord.getSetupTime() * chargeDefinition.getChargeCost().getLaborRate() +
											 chargeCostingRecord.getRunTime() * chargeDefinition.getChargeCost().getLaborRate());
		} else {
			chargeCostingRecord.setRunTime(chargeCostingRecord.getActualUnitCount()/lookupValue);
			if (chargeDefinition.getUseMinimumTime()) {
				if (chargeCostingRecord.getRunTime() + chargeCostingRecord.getSetupTime()*60 < chargeDefinition.getMinimumTime()  && chargeDefinition.getMinimumTime() != 0) {
					chargeCostingRecord.setRunTime((chargeDefinition.getMinimumTime() - (chargeCostingRecord.getSetupTime()*60))/60);
				}
			}
			chargeCostingRecord.setLaborCost((chargeCostingRecord.getSetupTime() +chargeCostingRecord.getRunTime()) * chargeDefinition.getChargeCost().getLaborRate());
		}
		chargeCostingRecord.setTotalCost(chargeCostingRecord.getActualMaterials() + chargeCostingRecord.getLaborCost());
	
	}
	
	static private void updateInkChargeCost(Charge charge, ChargeDefinition chargeDefintion) {
		
	}
	
	static private void updateSquareAreaChargeCost(Charge charge, ChargeDefinition chargeDefinition) {
		ChargeCostingRecord chargeCostingRecord= charge.getChargeCostingRecord();
		
		if (chargeCostingRecord == null) return;
		
		chargeCostingRecord.setActualUnitCount(getChargeUnitQuantity(charge));
		chargeCostingRecord.setActualMaterials(chargeCostingRecord.getActualUnitCount()*charge.getQuantity());
		chargeCostingRecord.setLaborUnitCost(0.0);
		chargeCostingRecord.setLaborCost(0.0);
		chargeCostingRecord.setTotalCost(chargeCostingRecord.getActualMaterials());
	}
	
	static private void updateFlatAreaChargeCost(Charge charge, ChargeDefinition chargeDefinition) {
		ChargeCostingRecord chargeCostingRecord = charge.getChargeCostingRecord();
		
		if (chargeCostingRecord == null) return;
		if (chargeDefinition.getChargeCost() == null) return;
		
		chargeCostingRecord.setActualUnitCount(1.0);
		chargeCostingRecord.setActualMaterials(chargeDefinition.getChargeCost().getSetupCost());
		chargeCostingRecord.setLaborUnitCost(chargeDefinition.getChargeCost().getLaborRate());
		chargeCostingRecord.setLaborCost(chargeCostingRecord.getLaborUnitCost());
		chargeCostingRecord.setTotalCost(chargeCostingRecord.getActualMaterials() + chargeCostingRecord.getLaborCost());
	}
	
	static private void updateGenericUnitCostCharge(Charge charge, ChargeDefinition chargeDefinition) {
		ChargeCostingRecord chargeCostingRecord = charge.getChargeCostingRecord();
		
		if (chargeCostingRecord == null) return;
		if (chargeDefinition.getChargeCost() == null) return;
		
		chargeCostingRecord.setActualUnitCount(getChargeUnitQuantity(charge));
		chargeCostingRecord.setActualMaterials(chargeDefinition.getChargeCost().getSetupCost());
		
		PriceList rateTable = chargeDefinition.getChargeCost().getRateTable();
		
		if (rateTable != null) {
			chargeCostingRecord.setLaborUnitCost(PriceListUtilities.lookupPrice(rateTable, chargeCostingRecord.getActualUnitCount().longValue()));			
			
			if (!rateTable.getIsDollar()) {
				chargeCostingRecord.setLaborCost(chargeCostingRecord.getLaborUnitCost() * chargeCostingRecord.getActualUnitCount());
			} else {
				chargeCostingRecord.setLaborCost(chargeCostingRecord.getLaborUnitCost());
			}
			chargeCostingRecord.setTotalCost(chargeCostingRecord.getActualMaterials() + chargeCostingRecord.getLaborCost());
		} else {
			chargeCostingRecord.setLaborUnitCost(chargeDefinition.getChargeCost().getUnitCost());
			chargeCostingRecord.setLaborCost(chargeCostingRecord.getLaborUnitCost() * chargeCostingRecord.getActualUnitCount());
			chargeCostingRecord.setTotalCost(chargeCostingRecord.getActualMaterials() + chargeCostingRecord.getLaborCost());
		}
	}

	static private double getChargeUnitQuantity(Charge charge)
	{
		double	quantity = 0.0;
		ChargeDefinition chargeDefinition = charge.getChargeDefinition();
		
		if (chargeDefinition == null) return 0.0;
		
		if (chargeDefinition.getQuantityType().equals(ChargeQtyType.None)) {
			quantity = 0.0;
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Sets) ||
				   chargeDefinition.getQuantityType().equals(ChargeQtyType.SetupSets)) {
			quantity = charge.getQuantity(); // TODO: multiply out by groupQty as PS does
		} else if (charge.getQuantity() == 0 && chargeDefinition.getUseMaterial()) {
			quantity = charge.getMaterialQty();
		} else  if (chargeDefinition.getMethod().equals(ChargeMethod.Ink)) {
			quantity = chargeDefinition.getMaterialSetCount();
		} else if (chargeDefinition.getMethod().equals(ChargeMethod.SquareArea)) {
			quantity = chargeDefinition.getMaterialSetCount();
		} else if (chargeDefinition.getQuantityType().equals(ChargeQtyType.Time)) {
			if (chargeDefinition.getChargeCost() != null && 
					chargeDefinition.getChargeCost().getCostingMethod().equals(ChargeCostMethod.TimeAndMaterial)) {
				quantity = charge.getQuantity();
			} else {
				quantity = charge.getQuantity() * 60; // TODO: round to int here?
			}
		} else {
			quantity = charge.getQuantity();
		}
			
		return(quantity);
	}
}
