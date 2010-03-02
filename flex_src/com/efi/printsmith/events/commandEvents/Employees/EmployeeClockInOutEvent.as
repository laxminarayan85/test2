package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class EmployeeClockInOutEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_ClockInOut";

		public var button:Button;
		public var enabled:Boolean;

		public function EmployeeClockInOutEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(EmployeeClockInOutEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeClockInOutEvent(button, callbacks);
		}
	}
}