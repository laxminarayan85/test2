package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class TrackerStatusUpdateEvent extends Event
	{
		public static const CLOSE_EVENT:String = "closeEvent";
		
		public var releasedToProduction:Boolean;
		
		public function TrackerStatusUpdateEvent(type:String, releasedToProduction:Boolean)
		{
			super(type, true);
			this.releasedToProduction = releasedToProduction;
		}
		
		override public function clone():Event {
			return new TrackerStatusUpdateEvent(type, releasedToProduction);
		}

	}
}