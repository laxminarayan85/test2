package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class EmployeeEmployeesProductionPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_Employees_Production";

		public var panel:Canvas;
		public var enabled:Boolean;

		public function EmployeeEmployeesProductionPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(EmployeeEmployeesProductionPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeEmployeesProductionPanelEvent(panel, callbacks);
		}
	}
}