package com.efi.printsmith.events
{
	import com.efi.printsmith.data.StockDefinition;
	
	import flash.events.Event;
	
	public class StockPickerSelectEvent extends Event
	{
		public static const SELECTSTOCK:String = "SelectStock";
		public static const SELECTNEWSTOCK:String = "SelectNewStock";
		public static const CANCELSELECTSTOCK:String = "CancelSelectStock";
		
		public var stockDefinition:StockDefinition;
		
		public function StockPickerSelectEvent(type:String, stockDefinition:StockDefinition)
		{
			super(type, true);
			this.stockDefinition = stockDefinition;
		}

		override public function clone():Event {
			return new StockPickerSelectEvent(type, stockDefinition);
		}
	}
}