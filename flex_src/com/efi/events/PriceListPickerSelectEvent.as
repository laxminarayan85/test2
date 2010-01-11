package com.efi.events
{
	import com.efi.vo.PriceListBase;
	
	import flash.events.Event;
	
	public class PriceListPickerSelectEvent extends Event
	{
		public static const SELECTPRICELIST:String = "SelectPriceList";
		public static const SELECTNEWPRICELIST:String = "SelectNewPriceList";
		public static const CANCELSELECTPRICELIST:String = "CancelSelectPriceList";
		
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