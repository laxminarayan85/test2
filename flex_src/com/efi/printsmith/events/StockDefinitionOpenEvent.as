package com.efi.printsmith.events
{
	import com.efi.printsmith.data.StockGroup;
	
	import flash.events.Event;
	
	public class StockDefinitionOpenEvent extends Event
	{
		public static const OPEN_EVENT:String = "openEvent";
		
		public var isOpened:Boolean;
		
		public var specialStockGroupObject:StockGroup; 
		
		public function StockDefinitionOpenEvent(type:String, isOpened:Boolean, specialStockGroupObject:StockGroup)
		{
			super(type, true);
			this.isOpened = isOpened;
			this.specialStockGroupObject = specialStockGroupObject;
		}
		
		override public function clone():Event {
			return new StockDefinitionOpenEvent(type, isOpened, specialStockGroupObject);
		}

	}
}