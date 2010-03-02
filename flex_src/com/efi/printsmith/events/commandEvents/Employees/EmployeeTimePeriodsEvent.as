package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class EmployeeTimePeriodsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_TimePeriods";

		public var button:Button;
		public var enabled:Boolean;

		public function EmployeeTimePeriodsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(EmployeeTimePeriodsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeTimePeriodsEvent(button, callbacks);
		}
	}
}