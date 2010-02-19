package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PricingRecord")]

	public class PricingRecord extends ModelBase
	{

		public function PricingRecord() {
			remoteObjectName = "com.efi.printsmith.data.PricingRecord";
		}
				
		public var priceLogEntry:PriceLogEntry;
	
	}
}