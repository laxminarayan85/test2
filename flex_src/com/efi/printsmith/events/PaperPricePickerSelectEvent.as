package com.efi.printsmith.events
{
	import com.efi.printsmith.data.PaperPrice;
	import com.efi.printsmith.data.PriceListBase;
	
	import flash.events.Event;
	
	public class PaperPricePickerSelectEvent extends Event
	{
		public static const SELECTPRICELIST:String = "SelectPaperPrice";
		public static const SELECTNEWPRICELIST:String = "SelectNewPaperPrice";
		public static const CANCELSELECTPRICELIST:String = "CancelSelectPaperPrice";
		public static const CLEARPRICELIST:String = "ClearSelectPaperPrice";
		
		public var paperPrice:PaperPrice;
		
		public function PaperPricePickerSelectEvent(type:String, paperPrice:PaperPrice)
		{
			super(type, true);
			this.paperPrice = paperPrice;
		}

		override public function clone():Event {
			return new PaperPricePickerSelectEvent(type, paperPrice);
		}
	}
}