package com.efi.printsmith.events
{
	import com.efi.printsmith.data.PriceListBase;
	
	import flash.events.Event;
	
	public class PriceListPickerSelectEvent extends Event
	{
		public static const SELECTPRICELIST:String = "SelectPriceList";
		public static const SELECTNEWPRICELIST:String = "SelectNewPriceList";
		public static const CANCELSELECTPRICELIST:String = "CancelSelectPriceList";
		public static const CLEARPRICELIST:String = "ClearSelectPriceList";
		
		public var priceList:PriceListBase;
		
		public function PriceListPickerSelectEvent(type:String, priceList:PriceListBase)
		{
			super(type, true);
			this.priceList = priceList;
		}

		override public function clone():Event {
			return new PriceListPickerSelectEvent(type, priceList);
		}
	}
}