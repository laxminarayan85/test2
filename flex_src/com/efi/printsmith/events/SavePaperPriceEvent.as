package com.efi.printsmith.events
{
	
	import com.efi.printsmith.data.PaperPrice;
	
	import flash.events.Event;
	
	public class SavePaperPriceEvent extends Event
	{
		public var paperPrice:PaperPrice;
		public static const Save:String = "Save";
		public function SavePaperPriceEvent(type:String, paperPrice:PaperPrice)
		{
			super(type, true);
			this.paperPrice = paperPrice;
		}

		override public function clone():Event {
			return new SavePaperPriceEvent(type, paperPrice);
		}
	}
}