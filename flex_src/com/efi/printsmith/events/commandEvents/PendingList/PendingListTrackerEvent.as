package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListTrackerEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Tracker";

		public function PendingListTrackerEvent(callbacks:IResponder=null)
		{
			super(PendingListTrackerEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListTrackerEvent(callbacks);
		}
	}
}