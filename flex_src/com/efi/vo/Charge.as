package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Charge")]

	public class Charge extends ModelBase
	{

		public function Charge() {
		
		}
		public var method:String = "";
		public var quantityType:String = "";
		public var markupType:String = "";
		public var jobQty:String = "";
		public var priceMethod:String = "";
		public var inkCoverage:String = "";
		public var useSides:Boolean = true;
		public var noDiscount:Boolean = true;
		public var noMaterialQuantity:Boolean = true;
		public var noOverrides:Boolean = true;
		public var adjustSets:Boolean = true;
		public var enterRate:Boolean = true;
		public var enterMaterial:Boolean = true;
		public var useMaterial:Boolean = true;
		public var useRate:Boolean = true;
		public var useRateSets:Boolean = true;
		public var useMerchandiseSets:Boolean = true;
		public var useMinimumCharge:Boolean = true;
		public var useColors:Boolean = true;
		public var useOriginals:Boolean = true;
		public var rateSetCount:Number = 0;
		public var materialSetCount:Number = 0;
		public var rate:Number = 0;
		public var material:Number = 0;
		public var minimum:Number = 0;
		public var markup:Number = 0;
		public var priceList:PriceListElement = new PriceListElement();
		public var wasteChart:WasteChart = new WasteChart();
		public var fixedWaste:Number = 0;
		public var wastePercentage:Number = 0;
		public var baseLinearNumber:Number = 0;
		public var location:Location = new Location();
		public var costCenter:CostCenter = new CostCenter();
		public var substrate:Substrate = new Substrate();
		public var minimumTime:Number = 0;
		public var sizeX:Number = 0;
		public var sizeY:Number = 0;
		public var plateThickness:Number = 0;
		public var foldTemplate:FoldTemplate = new FoldTemplate();
		public var excludeFromProductionList:Boolean = true;
		public var preproduction:Boolean = true;
		public var useMinimumTime:Boolean = true;
		public var useDivideByUpCount:Boolean = true;
		public var useMultiplyUpCount:Boolean = true;
		public var adjustUps:Boolean = true;
		public var cutsArePrePress:Boolean = true;
		public var integratedCTP:Boolean = true;
		public var sku:String = "";
		public var category:String = "";
		public var overrideRate:Boolean = true;
		public var title:String = "";
		public var note:String = "";
		public var chargeGroup:String = "";
		public var salesCategory:String = "";
		public var taxTable:TaxTable = new TaxTable();
		public var rateQty:Number = 0;
		public var materialQty:Number = 0;
		public var groupQty:Number = 0;
		public var price:Number = 0;
		public var timeStart:Date = new Date();
		public var timeEnd:Date = new Date();
		public var customerCharge:Boolean = true;
		public var pressCharge:Boolean = true;
		public var hidden:Boolean = true;
		public var deletedPreset:Boolean = true;
		public var ignoreCuts:Boolean = true;
		public var useSignatures:Boolean = true;
		public var stockCharge:Boolean = true;
		public var overrideNumberOfCuts:Boolean = true;
		public var showNotes:Boolean = true;
		public var finished:Boolean = true;
		public var brokered:Boolean = true;
		public var taxable:Boolean = true;
		public var displayQty:Boolean = true;
		public var overridePrice:Boolean = true;
		public var overrideRateQuantity:Boolean = true;
		public var overrideMaterialQty:Boolean = true;
		public var version:int = 0;
		public var shipMode:ShippingMethod = new ShippingMethod();
		public var adjustUpsCount:int = 0;
		public var hasLinkPrice:Boolean = true;
		public var needLinkPrice:Boolean = true;
		public var hasShipped:Boolean = true;
		public var shouldShip:Boolean = true;
		public var jobTaskList:Boolean = true;
		public var hidePrice:Boolean = true;
		public var ignorePriceAdjustment:Boolean = true;
		public var costingPressCharge:Boolean = true;
		public var linearX1:Boolean = true;
		public var linearX2:Boolean = true;
		public var linearY1:Boolean = true;
		public var linearY2:Boolean = true;
		public var label:String = "";
		public var binderyCharge:Boolean = true;
		public var name:String = "";
		public var parent:ChargeCategory = new ChargeCategory();
		public var useArea:Boolean = true;
		public var useSetup:Boolean = true;
		public var chargeCost:ChargeCost = new ChargeCost();
	
	}
}