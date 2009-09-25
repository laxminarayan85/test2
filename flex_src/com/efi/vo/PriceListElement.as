package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.PriceListElement")]

public class PriceListElement

{

public function PriceListElement()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var quantity:Number = 0;
public var amount:Number = 0;
public var ignorePriceAdjustments:Boolean = true;
public var isDiscount:Boolean = true;
public var isRate:Boolean = true;
public var interpolate:Boolean = true;
public var isDollar:Boolean = true;
public var fillAll:Boolean = true;
public var sequence:Boolean = true;
public var isPercent:Boolean = true;
public var doAdditionalQty:Boolean = true;

}
}