package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockPricing")]

public class StockPricing

{

public function StockPricing()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var normalRunSize:Number;

public var cutsPer100:Number;

public var minCutCharge:Number;

public var defaultPress:Number;

public var listPricingSchedule:Number;

public var blankSheets:StockBlankSheets;

public var autoCalculateBlank:Boolean;


}
}