package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class DeliveryTicketUpdateEvent extends Event
	{
		public static const DELIVERYTICKET_UPDATE_EVENT:String = "deliveryTicketUpdateEvent";
		
		public var ticketSaved:Boolean;
		
		public function DeliveryTicketUpdateEvent(type:String, ticketSaved:Boolean)
		{
			super(type, true);
			this.ticketSaved = ticketSaved;
		}
		
		override public function clone():Event {
			return new DeliveryTicketUpdateEvent(type, ticketSaved);
		}

	}
}