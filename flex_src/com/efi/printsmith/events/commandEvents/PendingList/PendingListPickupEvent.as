package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListPickupEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Pickup";

		public function PendingListPickupEvent(callbacks:IResponder=null)
		{
			super(PendingListPickupEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListPickupEvent(callbacks);
		}
	}
}