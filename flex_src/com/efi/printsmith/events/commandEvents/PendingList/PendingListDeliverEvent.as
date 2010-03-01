package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListDeliverEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Deliver";

		public function PendingListDeliverEvent(callbacks:IResponder=null)
		{
			super(PendingListDeliverEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListDeliverEvent(callbacks);
		}
	}
}