// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;

	public class StockOrderCommentsEvent extends Event
	{
		public static const OK:String = "OK";
		
		public function StockOrderCommentsEvent(type:String)
		{
			super(type);
		}
		
		override public function clone():Event {
			return new StockOrderCommentsEvent(type);
		}
	}
}