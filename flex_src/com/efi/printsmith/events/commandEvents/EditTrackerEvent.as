package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;

	public class EditTrackerEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Tracker";
		
		public function EditTrackerEvent(callbacks:IResponder=null)
		{
			super(EditTrackerEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditTrackerEvent(callbacks);
		}
	}
}