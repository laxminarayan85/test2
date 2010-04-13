package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TaxElement")]

	public class TaxElement extends ModelBase
	{

		public function TaxElement() {
			remoteObjectName = "com.efi.printsmith.data.TaxElement";
		}
				
		public var rate:Number = 0;
		public var showTax:Boolean = false;
		public var userForSeparateShippingTax:Boolean = false;
	
	}
}