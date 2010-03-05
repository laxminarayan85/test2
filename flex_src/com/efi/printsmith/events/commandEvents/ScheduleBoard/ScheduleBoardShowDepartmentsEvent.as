package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardShowDepartmentsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_ShowDepartments";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardShowDepartmentsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardShowDepartmentsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardShowDepartmentsEvent(button, callbacks);
		}
	}
}