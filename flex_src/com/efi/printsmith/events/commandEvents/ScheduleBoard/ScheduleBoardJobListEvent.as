package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardJobListEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_JobList";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardJobListEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardJobListEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardJobListEvent(button, callbacks);
		}
	}
}