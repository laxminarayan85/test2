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
		public var unitPrice:Number = 0;
		public var totalPrice:Number = 0;
		public var otherChargePrice:Number = 0;
		public var prepPrice:Number = 0;
		public var oversTotalPrice:Number = 0;
		public var bindPrice:Number = 0;
		public var oversUnitPrice:Number = 0;
		public var unitPriceOverride:Boolean = false;
		public var totalPriceOverride:Boolean = false;
		public var laborTotalPrice:Number = 0;
		public var laborTotalPriceOverride:Boolean = false;
		public var stockTotalPrice:Number = 0;
		public var stockTotalPriceOverride:Boolean = false;
		public var stockMarkup:Number = 0;
	
	}
}