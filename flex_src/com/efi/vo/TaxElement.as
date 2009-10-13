package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.TaxElement")]

public class TaxElement extends ModelBase

{

	public function TaxElement() {
	
	}
	public var rate:Number = 0;
	public var showTax:Boolean = true;
	public var userForSeparateShippingTax:Boolean = true;

	}
}