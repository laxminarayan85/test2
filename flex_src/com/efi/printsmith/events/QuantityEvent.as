// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;

	public class QuantityEvent extends Event
	{
		public static const OK:String = "OK";
		public static const Cancel:String = "Cancel";
		public var quantity:int
		
		public function QuantityEvent(type:String, quantity:int)
		{
			super(type);
			this.quantity = quantity
		}
		
		override public function clone():Event {
			return new QuantityEvent(type, quantity);
		}
	}
}