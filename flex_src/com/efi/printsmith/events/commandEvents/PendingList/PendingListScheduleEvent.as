package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListScheduleEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Schedule";

		public function PendingListScheduleEvent(callbacks:IResponder=null)
		{
			super(PendingListScheduleEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListScheduleEvent(callbacks);
		}
	}
}