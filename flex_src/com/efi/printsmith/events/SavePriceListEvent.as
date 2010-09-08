package com.efi.printsmith.events
{
	
	import com.efi.printsmith.data.PriceListBase;
	
	import flash.events.Event;
	
	public class SavePriceListEvent extends Event
	{
		public var priceList:PriceListBase;
		public static const Save:String = "Save";
		public function SavePriceListEvent(type:String, pricelist:PriceListBase)
		{
			super(type, true);
			this.priceList = pricelist;
		}

		override public function clone():Event {
			return new SavePriceListEvent(type, priceList);
		}
	}
}