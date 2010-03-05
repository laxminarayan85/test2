package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardEditDepartmentsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_EditDepartments";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardEditDepartmentsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardEditDepartmentsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardEditDepartmentsEvent(button, callbacks);
		}
	}
}