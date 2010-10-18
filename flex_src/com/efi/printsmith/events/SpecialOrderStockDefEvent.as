package com.efi.printsmith.events
{
	import com.efi.printsmith.data.StockDefinition;
	
	import flash.events.Event;
	
	public class SpecialOrderStockDefEvent extends Event
	{
		public static const SPECIAL_ORDER_SAVE_EVENT:String = "specialOrderSaveEvent";
		
		public var stockDefinitionObj:StockDefinition;
		
		public function SpecialOrderStockDefEvent(type:String, stockDefinitionObj:StockDefinition)
		{
			super(type, true);
			this.stockDefinitionObj = stockDefinitionObj;
		}
		
		override public function clone():Event {
			return new SpecialOrderStockDefEvent(type, stockDefinitionObj);
		}

	}
}