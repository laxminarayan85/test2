package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class BrokerUpdateEvent extends Event
	{
		public static const BROKER_UPDATE_EVENT:String = "brokerUpdateEvent";
		
		public var isSaved:Boolean;
		
		public function BrokerUpdateEvent(type:String, isSaved:Boolean)
		{
			super(type, true);
			this.isSaved = isSaved;
		}
		
		override public function clone():Event {
			return new BrokerUpdateEvent(type, isSaved);
		}

	}
}