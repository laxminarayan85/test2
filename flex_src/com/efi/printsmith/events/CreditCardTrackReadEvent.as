package com.efi.printsmith.events
{
	import com.efi.printsmith.data.CreditCardTrackRead;
	
	import flash.events.Event;
	
	public class CreditCardTrackReadEvent extends Event
	{
		public static const BRICKREAD:String = "BrickRead";
				
		public var brickData:CreditCardTrackRead;

		public function CreditCardTrackReadEvent(type:String, brickData:CreditCardTrackRead)
		{
			super(type, true);
			this.brickData = brickData;
		}

		override public function clone():Event {
			return new CreditCardTrackReadEvent(type, brickData);
		}
	}
}