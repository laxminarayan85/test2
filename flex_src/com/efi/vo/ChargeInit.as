package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ChargeInit")]

public class ChargeInit

{

public function ChargeInit()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var title:String = "";
public var note:String = "";
public var group:String = "";
public var salesCategory:String = "";
public var taxTable:TaxTable;
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
public var shipMode:ShippingMethod;
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
public var overrideRate:Boolean = true;

}
}