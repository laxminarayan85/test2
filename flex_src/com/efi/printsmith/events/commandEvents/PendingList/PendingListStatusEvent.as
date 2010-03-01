package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListStatusEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Status";

		public function PendingListStatusEvent(callbacks:IResponder=null)
		{
			super(PendingListStatusEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListStatusEvent(callbacks);
		}
	}
}