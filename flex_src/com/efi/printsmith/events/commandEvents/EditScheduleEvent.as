package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;

	public class EditScheduleEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Schedule";
		
		public function EditScheduleEvent(callbacks:IResponder=null)
		{
			super(EditScheduleEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditScheduleEvent(callbacks);
		}
	}
}