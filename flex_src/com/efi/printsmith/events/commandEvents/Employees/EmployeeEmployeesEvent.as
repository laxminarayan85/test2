package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class EmployeeEmployeesEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_Employees";

		public var button:Button;
		public var enabled:Boolean;

		public function EmployeeEmployeesEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(EmployeeEmployeesEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeEmployeesEvent(button, callbacks);
		}
	}
}