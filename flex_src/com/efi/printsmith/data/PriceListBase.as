package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PriceListBase")]
	[Managed]
	
	public dynamic class PriceListBase extends ModelBase
	{

		public function PriceListBase() {
			remoteObjectName = "com.efi.printsmith.data.PriceListBase";
		}
				
		public var name:String = "";
		public var ignorePriceAdjustments:Boolean = false;
		public var isDiscount:Boolean = false;
		public var isRate:Boolean = false;
		public var interpolate:Boolean = false;
		public var isDollar:Boolean = false;
		public var fillAllValues:Boolean = false;
		public var sequence:Boolean = false;
		public var isPercentage:Boolean = false;
		public var lastItemIsPriceAdditionalQty:Boolean = false;
		public var elements:ArrayCollection;
		public var priceMethod:int = 0;
	
	}
}