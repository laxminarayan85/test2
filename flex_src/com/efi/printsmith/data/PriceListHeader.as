package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PriceListHeader")]

	public class PriceListHeader extends ModelBase
	{

		public function PriceListHeader() {
			remoteObjectName = "com.efi.printsmith.data.PriceListHeader";
		}
				
		public var lastItemIsPriceAdditionalQty:Boolean = true;
		public var isPercentage:Boolean = true;
		public var sequence:Boolean = true;
		public var fillAllValues:Boolean = true;
		public var isDollar:Boolean = true;
		public var interpolate:Boolean = true;
		public var isRate:Boolean = true;
		public var isDiscount:Boolean = true;
		public var ignorePriceAdjustments:Boolean = true;
		public var priceMethod:int = 0;
		public var name:String = "";
	
	}
}