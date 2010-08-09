package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeDefinition")]
	[Managed]
	
	public dynamic class ChargeDefinition extends ModelBase
	{

		public function ChargeDefinition() {
			remoteObjectName = "com.efi.printsmith.data.ChargeDefinition";
		}
				
		public var method:String = "";
		public var quantityType:String = "";
		public var markupType:String = "";
		public var jobQty:String = "";
		public var priceMethod:String = "";
		public var inkCoverage:String = "";
		public var useSides:Boolean = false;
		public var doNotDiscount:Boolean = false;
		public var noMaterialQuantity:Boolean = false;
		public var noOverrides:Boolean = false;
		public var adjustableSets:Boolean = false;
		public var adjustableRate:Boolean = false;
		public var adjustableMaterial:Boolean = false;
		public var useMaterial:Boolean = false;
		public var useRate:Boolean = false;
		public var useRateSets:Boolean = false;
		public var useMerchandiseSets:Boolean = false;
		public var useMinimumCharge:Boolean = false;
		public var useColors:Boolean = false;
		public var useOriginals:Boolean = false;
		public var rateSetCount:Number = 0;
		public var materialSetCount:Number = 0;
		public var rate:Number = 0;
		public var material:Number = 0;
		public var minimum:Number = 0;
		public var markup:Number = 0;
		public var priceList:PriceList;
		public var wasteChart:WasteChart;
		public var fixedWaste:Number = 0;
		public var wastePercentage:Number = 0;
		public var baseLinearNumber:Number = 0;
		public var location:ProductionLocations;
		public var costCenter:CostCenter;
		public var substrate:Substrate;
		public var minimumTime:Number = 0;
		public var sizeX:Number = 0;
		public var sizeY:Number = 0;
		public var plateThickness:Number = 0;
		public var foldTemplate:FoldTemplate;
		public var excludedFromWorkflow:Boolean = false;
		public var preproduction:Boolean = false;
		public var useMinimumTime:Boolean = false;
		public var useDivideByUpCount:Boolean = false;
		public var useMultiplyUpCount:Boolean = false;
		public var adjustUps:Boolean = false;
		public var cutsArePrePress:Boolean = false;
		public var integratedCTP:Boolean = false;
		public var sku:String = "";
		public var category:String = "";
		public var overrideRate:Boolean = false;
		public var title:String = "";
		public var note:String = "";
		public var chargeGroup:String = "";
		public var salesCategory:SalesCategory;
		public var taxTable:TaxTable;
		public var rateQty:Number = 0;
		public var materialQty:Number = 0;
		public var groupQty:Number = 0;
		public var price:Number = 0;
		public var timeStart:Date = new Date();
		public var timeEnd:Date = new Date();
		public var customerCharge:Boolean = false;
		public var pressCharge:Boolean = false;
		public var hideChargeInPrintouts:Boolean = false;
		public var deletedPreset:Boolean = false;
		public var ignoreCuts:Boolean = false;
		public var useSignatures:Boolean = false;
		public var stockCharge:Boolean = false;
		public var overrideNumberOfCuts:Boolean = false;
		public var overridePrice:Boolean = false;
		public var overrideRateQuantity:Boolean = false;
		public var overrideMaterialQty:Boolean = false;
		public var version:int = 0;
		public var shipMode:ShippingMethod;
		public var adjustUpsCount:int = 0;
		public var hasLinkPrice:Boolean = false;
		public var needLinkPrice:Boolean = false;
		public var hasShipped:Boolean = false;
		public var shouldShip:Boolean = false;
		public var jobTaskList:Boolean = false;
		public var hidePrice:Boolean = false;
		public var ignoreGlobalPriceChanges:Boolean = false;
		public var costingPressCharge:Boolean = false;
		public var linearX1:Boolean = false;
		public var linearX2:Boolean = false;
		public var linearY1:Boolean = false;
		public var linearY2:Boolean = false;
		public var label:String = "";
		public var binderyCharge:Boolean = false;
		public var name:String = "";
		public var parent:ChargeCategory;
		public var useArea:Boolean = false;
		public var useSetup:Boolean = false;
		public var chargeCost:ChargeCost;
		public var area:Number = 0;
		public var coverlb_check:Boolean = false;
		public var sheet_lift_check:Boolean = false;
		public var ship_markup_check:Boolean = false;
		public var coverlbInk:Number = 0;
		public var sheetliftCut:Number = 0;
		public var shipMarkup:Number = 0;
		public var useRunArea:Boolean = false;
		public var setupPrice:Number = 0;
		public var costingUnitPrice:Number = 0;
		public var costingSetupPrice:Number = 0;
		public var productCode:ProductCode;
		public var presetDescription:String = "";
		public var presetDescriptionLabel:String = "";
		public var presetNotes:String = "";
		public var presetNotesLabel:String = "";
		public var presetQuantity:int = 0;
		public var presetQuantityLabel:int = 0;
		public var presetShowNotes:Boolean = false;
		public var presetProductionLocation:ProductionLocations;
		public var presetPrice:Number = 0;
		public var presetPriceLabel:String = "";
		public var presetTaxTable:TaxTable;
		public var presetFinished:Boolean = false;
		public var presetTaxable:Boolean = false;
		public var presetRate:Number = 0;
		public var presetRateLabel:String = "";
		public var presetBrokered:Boolean = false;
		public var presetDisplayQuantity:Boolean = false;
		public var presetHidden:Boolean = false;
		public var presetUp:Number = 0;
		public var presetUpLabel:String = "";
		public var presetInSetsOf:Number = 0;
		public var presetInSetsOfLabel:String = "";
		public var presetMaterialQuantity:Number = 0;
		public var presetMaterialQuantityLabel:String = "";
		public var presetMaterialSetsOf:Number = 0;
		public var presetMaterialSetsOfLabel:String = "";
		public var presetMaterialRate:Number = 0;
		public var presetMaterialRateLabel:String = "";
		public var presetQuantityPerSet:Number = 0;
		public var presetQuantityPerSetLabel:String = "";
	
	}
}