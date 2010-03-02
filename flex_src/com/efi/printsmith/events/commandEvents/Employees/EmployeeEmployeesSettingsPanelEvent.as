package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class EmployeeEmployeesSettingsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_Employees_Settings";

		public var panel:Canvas;
		public var enabled:Boolean;

		public function EmployeeEmployeesSettingsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(EmployeeEmployeesSettingsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeEmployeesSettingsPanelEvent(panel, callbacks);
		}
	}
}