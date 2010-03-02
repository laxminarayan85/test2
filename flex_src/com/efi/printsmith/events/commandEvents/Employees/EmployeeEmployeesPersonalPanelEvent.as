package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class EmployeeEmployeesPersonalPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_Employees_Personal";

		public var panel:Canvas;
		public var enabled:Boolean;

		public function EmployeeEmployeesPersonalPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(EmployeeEmployeesPersonalPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeEmployeesPersonalPanelEvent(panel, callbacks);
		}
	}
}