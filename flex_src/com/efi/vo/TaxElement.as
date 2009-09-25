package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.TaxElement")]

public class TaxElement

{

public function TaxElement()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var rate:Number = 0;
public var showTax:Boolean = true;
public var userForSeparateShippingTax:Boolean = true;

}
}