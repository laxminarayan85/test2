package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PriceListBase")]

	public class PriceListBase extends ModelBase
	{

		public function PriceListBase() {
		
		}
		public var name:String = "";
		public var ignorePriceAdjustments:Boolean = true;
		public var isDiscount:Boolean = true;
		public var isRate:Boolean = true;
		public var interpolate:Boolean = true;
		public var isDollar:Boolean = true;
		public var fillAllValues:Boolean = true;
		public var sequence:Boolean = true;
		public var isPercentage:Boolean = true;
		public var lastItemIsPriceAdditionalQty:Boolean = true;
		public var elements:ArrayCollection;
		public var priceMethod:int = 0;
	
	}
}