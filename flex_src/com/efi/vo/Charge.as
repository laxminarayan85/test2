package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Charge")]

public class Charge

{

public function Charge()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var method:String = "";
public var quantityType:ChargeQtyType;
public var markupType:ChargeMarkupType;
public var jobQty:ChargeJobQuantity;
public var priceMethod:ChargePriceMethod;
public var inkCoverage:ChargeInkCoverage;
public var useSides:Boolean = true;
public var noDiscount:Boolean = true;
public var noMaterialQuantity:Boolean = true;
public var noOverrides:Boolean = true;
public var adjustSets:Boolean = true;
public var enterRate:Boolean = true;
public var enterMaterial:Boolean = true;
public var useMaterial:Boolean = true;
public var useRate:int = 0;
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
public var priceList:PriceListElement;
public var wasteChart:WasteChart;
public var fixedWaste:Number = 0;
public var wastePercentage:Number = 0;
public var baseLinearNumber:Number = 0;
public var location:Location;
public var costCenter:CostCenter;
public var substrate:Substrate;
public var minimumTime:Number = 0;
public var sizeX:Number = 0;
public var sizeY:Number = 0;
public var plateThickness:Number = 0;
public var foldTemplate:FoldTemplate;
public var excludeFromProductionList:Boolean = true;
public var preproduction:Boolean = true;
public var useMinimumTime:Boolean = true;
public var useDivideByUpCount:Boolean = true;
public var useMultiplyUpCount:int = 0;
public var adjustUps:Boolean = true;
public var cutsArePrePress:Boolean = true;
public var integratedCTP:int = 0;
public var sku:String = "";
public var category:String = "";
public var label:String = "";

}
}