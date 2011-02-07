package com.efi.printsmith.util
{
	import com.efi.printsmith.data.Charge;
	import com.efi.printsmith.data.ChargeDefinition;
	import com.efi.printsmith.data.PriceList;
	import com.efi.printsmith.data.enums.ChargeCostMethod;
	import com.efi.printsmith.data.enums.ChargeMethod;
	import com.efi.printsmith.data.enums.ChargeQtyType;
	
	public class ChargeCostingUtil
	{
		public var runTime:Number = 0;
			
		public var setupTime:Number = 0;
		
		public function getChargeEstCost(chargeObj:Charge):Number {
			var chargeDefinition:ChargeDefinition = chargeObj.chargeDefinition;
			var totalCost:Number = 0;
			if(chargeDefinition!=null) {
				var costingMethodStr:String = chargeDefinition.chargeCost.costingMethod;
				var methodStr:String = chargeDefinition.method;
				if (costingMethodStr == ChargeCostMethod.NoCost) {
					totalCost = 0;
				} else if (costingMethodStr == ChargeCostMethod.HundredPercent) {
					totalCost = isNaN(chargeObj.price)?0:chargeObj.price;
				} else if (costingMethodStr == ChargeCostMethod.UnitCost) {
					if (methodStr == ChargeMethod.Ink) {
						totalCost = updateInkChargeCost(chargeObj, chargeDefinition);
					} else if (methodStr == ChargeMethod.SquareArea) {
						totalCost = updateSquareAreaChargeCost(chargeObj, chargeDefinition);
					} else if (methodStr == ChargeMethod.FlatRate) {
						totalCost = updateFlatAreaChargeCost(chargeObj, chargeDefinition);
					} else {
						totalCost = updateGenericUnitCostCharge(chargeObj, chargeDefinition);
					}
				} else if (costingMethodStr == ChargeCostMethod.TimeAndMaterial) {
					totalCost = updateTimeMaterialChargeCost(chargeObj, chargeDefinition);
				}	
			}
			return totalCost;
		}
		
		private function updateInkChargeCost(chargeObj:Charge, chargeDefinition:ChargeDefinition):Number {
			return 0;
		}
		
		private function updateSquareAreaChargeCost(chargeObj:Charge, chargeDefinition:ChargeDefinition):Number {
			var quantity:Number = getChargeUnitQuantity(chargeObj);
			var actualMaterials:Number = quantity * checkIsNaN(chargeObj.quantity);
			return actualMaterials;
		}
		
		private function updateFlatAreaChargeCost(chargeObj:Charge, chargeDefinition:ChargeDefinition):Number {
			if(chargeDefinition.chargeCost==null)
				return 0;
			var actualMaterials:Number = checkIsNaN(chargeDefinition.chargeCost.setupCost);
			var laborUnitCost:Number = checkIsNaN(chargeDefinition.chargeCost.laborRate);
			return actualMaterials+laborUnitCost;
		}
		
		private function updateGenericUnitCostCharge(chargeObj:Charge, chargeDefinition:ChargeDefinition):Number {
			if(chargeDefinition.chargeCost==null)
				return 0;
			var actualUnitCount:Number = getChargeUnitQuantity(chargeObj);
			var actualMaterials:Number = checkIsNaN(chargeDefinition.chargeCost.setupCost);
			
			var rateTable:PriceList = chargeDefinition.chargeCost.rateTable;
			
			if (rateTable != null) {
				
			} else {
				var laborUnitCost:Number = checkIsNaN(chargeDefinition.chargeCost.unitCost);
				var laborCost:Number = laborUnitCost * actualUnitCount;
				return actualMaterials + laborCost;
			}
			return 0;
		}
		
		private function updateTimeMaterialChargeCost(chargeObj:Charge, chargeDefinition:ChargeDefinition):Number {
			
			if (chargeDefinition.chargeCost == null) return 0;
	
			var actualUnitCount:Number = getChargeUnitQuantity(chargeObj);
			
			if (chargeDefinition.quantityType == ChargeQtyType.None &&
					chargeDefinition.method == ChargeMethod.FlatRate) {
				actualUnitCount = 1;
			}
			
			/* if (chargeDefinition.method == ChargeMethod.SquareArea) {
				actualUnitCount = (actualUnitCount/checkIsNaN(chargeDefinition.rateSetCount));
			} */
					
			var actualMaterials:Number = checkIsNaN(chargeDefinition.chargeCost.setupCost);
			actualMaterials = actualMaterials + (actualUnitCount * checkIsNaN(chargeDefinition.chargeCost.unitMaterials));
		
			var lookupValue:Number = 0;
			if (chargeDefinition.chargeCost.speedTable != null) {
				
			} else { 
				lookupValue = checkIsNaN(chargeDefinition.chargeCost.piecesPerHour);
			}
			
			if (lookupValue == 0) lookupValue = 1;
			
			runTime = 0;
			setupTime = 0;
			var laborCost:Number = 0;
			
			if (chargeDefinition.quantityType == ChargeQtyType.Time) {
				runTime = (actualUnitCount/lookupValue);
				setupTime = (checkIsNaN(chargeDefinition.chargeCost.setupMinutes)/60);
				laborCost = ((setupTime * checkIsNaN(chargeDefinition.chargeCost.laborRate)) +
												 (runTime * checkIsNaN(chargeDefinition.chargeCost.laborRate)));
			} else {
				if (chargeObj.actualCostingRunTime != 0) {
					runTime = chargeObj.actualCostingRunTime;
					setupTime = chargeObj.actualCostingSetupTime;
				} else {
					runTime = (actualUnitCount/lookupValue);
					setupTime = (checkIsNaN(chargeDefinition.chargeCost.setupMinutes)/60);
					if (chargeDefinition.useMinimumTime) {
						if (((runTime + setupTime)*60) < checkIsNaN(chargeDefinition.minimumTime)  && checkIsNaN(chargeDefinition.minimumTime) != 0) {
							runTime = ((checkIsNaN(chargeDefinition.minimumTime) - (setupTime*60)) / 60);
						}
					}
				}
				laborCost = ((setupTime + runTime) * checkIsNaN(chargeDefinition.chargeCost.laborRate));
			}
			return (actualMaterials + laborCost);
		}
		
		private function getChargeUnitQuantity(charge:Charge):Number
		{
			var	quantity:Number = 0;
			var chargeDefinition:ChargeDefinition = charge.chargeDefinition;
			
			if (chargeDefinition == null) return 0;
			
			if (chargeDefinition.quantityType == ChargeQtyType.None) {
				quantity = 0;
			} else if (chargeDefinition.quantityType == ChargeQtyType.Sets ||
					   chargeDefinition.quantityType == ChargeQtyType.SetupSets) {
				quantity = checkIsNaN(charge.quantity); // TODO: multiply out by groupQty as PS does
			} else if (charge.quantity == 0 && chargeDefinition.useMaterial) {
				quantity = checkIsNaN(charge.materialQty);
			} else  if (chargeDefinition.method == ChargeMethod.Ink) {
				quantity = checkIsNaN(chargeDefinition.materialSetCount);
			} else if (chargeDefinition.method == ChargeMethod.SquareArea) {
				quantity = checkIsNaN(chargeDefinition.materialSetCount);
			} else if (chargeDefinition.quantityType == ChargeQtyType.Time) {
				if (chargeDefinition.chargeCost != null && 
						chargeDefinition.chargeCost.costingMethod !=null &&
						chargeDefinition.chargeCost.costingMethod == ChargeCostMethod.TimeAndMaterial) {
					quantity = checkIsNaN(charge.quantity);
				} else {
					quantity = checkIsNaN(charge.quantity) * 60; // TODO: round to int here?
				}
			} else {
				quantity = checkIsNaN(charge.quantity);
			}
				
			return quantity;
		}
		
		private function checkIsNaN(property:Number):Number {
			return isNaN(property)?0:property;
		}

	}
}