package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class PinRequestEvent extends Event
	{
		
		public static const PINREQUEST:String = "pinRequest";
		
		public var success:Boolean;
		
		public function PinRequestEvent(type:String, success:Boolean)
		{
			super(type, true);
			this.success = success;
		}
		
		override public function clone():Event {
			return new PinRequestEvent(type, success);
		}

	}
}