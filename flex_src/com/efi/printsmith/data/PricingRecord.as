package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PricingRecord")]
	[Managed]
	
	public dynamic class PricingRecord extends ModelBase
	{

		public function PricingRecord() {
			remoteObjectName = "com.efi.printsmith.data.PricingRecord";
		}
		public var isDeleted:Boolean=false;
				
		public var prepPrice:Number = 0;
		public var oversTotalPrice:Number = 0;
		public var otherChargePrice:Number = 0;
		public var priceLogEntry:PriceLogEntry;
		public var totalPrice:Number = 0;
		public var unitPrice:Number = 0;
		public var bindPrice:Number = 0;
		public var oversUnitPrice:Number = 0;
		public var unitPriceOverride:Boolean = false;
		public var totalPriceOverride:Boolean = false;
		public var laborTotalPrice:Number = 0;
		public var laborTotalPriceOverride:Boolean = false;
		public var stockTotalPrice:Number = 0;
		public var stockTotalPriceOverride:Boolean = false;
		public var stockMarkup:Number = 0;
		public var productionPrice:Number = 0;
		public var productionPriceOverride:Boolean = false;
		public var stockCost:Number = 0;
		public var laborCost:Number = 0;
		public var laborRate:Number = 0;
		public var laborRateOverride:Boolean = false;
		public var laborMarkup:Number = 0;
		public var laborMarkupOverride:Boolean = false;
	
	}
}