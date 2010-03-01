package com.efi.printsmith.events.commandEvents.PendingList
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PendingListLocationEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList_Location";

		public function PendingListLocationEvent(callbacks:IResponder=null)
		{
			super(PendingListLocationEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PendingListLocationEvent(callbacks);
		}
	}
}