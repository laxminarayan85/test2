package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class EmployeeClockOptionsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_ClockOptions";

		public var button:Button;
		public var enabled:Boolean;

		public function EmployeeClockOptionsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(EmployeeClockOptionsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeClockOptionsEvent(button, callbacks);
		}
	}
}