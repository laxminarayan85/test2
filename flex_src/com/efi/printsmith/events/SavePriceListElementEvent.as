package com.efi.printsmith.events
{
	import com.efi.printsmith.data.PriceListElement;
	
	import flash.events.Event;
	
	public class SavePriceListElementEvent extends Event
	{
		public var element:PriceListElement;
		
		public function SavePriceListElementEvent(type:String, element:PriceListElement)
		{
			super(type, true);
			this.element = element;
		}

		override public function clone():Event {
			return new SavePriceListElementEvent(type, element);
		}
	}
}