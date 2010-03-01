package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListOpenEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Open";

		public function PendingListOpenEvent(callbacks:IResponder=null)
		{
			super(PendingListOpenEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListOpenEvent(callbacks);
		}
	}
}