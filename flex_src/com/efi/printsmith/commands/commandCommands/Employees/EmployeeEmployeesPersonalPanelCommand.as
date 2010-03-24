package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Employees.EmployeeEmployeesPersonalPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Employees.EmployeeEmployeesPersonalPanelDelegate;
	
	public class EmployeeEmployeesPersonalPanelCommand implements ICommand
	{
		public function EmployeeEmployeesPersonalPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeEmployeesPersonalPanelEvent = event as EmployeeEmployeesPersonalPanelEvent;
			var delegate:EmployeeEmployeesPersonalPanelDelegate = new EmployeeEmployeesPersonalPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}