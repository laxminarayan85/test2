package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListNotifyEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Notify";

		public function PendingListNotifyEvent(callbacks:IResponder=null)
		{
			super(PendingListNotifyEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListNotifyEvent(callbacks);
		}
	}
}