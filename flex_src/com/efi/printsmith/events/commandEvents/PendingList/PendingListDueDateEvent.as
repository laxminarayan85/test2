package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListDueDateEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_DueDate";

		public function PendingListDueDateEvent(callbacks:IResponder=null)
		{
			super(PendingListDueDateEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListDueDateEvent(callbacks);
		}
	}
}