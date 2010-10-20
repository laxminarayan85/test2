package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class PendingListUpdateEvent extends Event
	{
		public static const PENDINGLIST_UPDATE_EVENT:String = "pendingListUpdateEvent";
		
		public var invoiceSaved:Boolean;
		
		public function PendingListUpdateEvent(type:String, invoiceSaved:Boolean)
		{
			super(type, true);
			this.invoiceSaved = invoiceSaved;
		}
		
		override public function clone():Event {
			return new PendingListUpdateEvent(type, invoiceSaved);
		}

	}
}