package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Employees.EmployeeEmployeesSettingsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Employees.EmployeeEmployeesSettingsPanelDelegate;
	
	public class EmployeeEmployeesSettingsPanelCommand implements ICommand
	{
		public function EmployeeEmployeesSettingsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeEmployeesSettingsPanelEvent = event as EmployeeEmployeesSettingsPanelEvent;
			var delegate:EmployeeEmployeesSettingsPanelDelegate = new EmployeeEmployeesSettingsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}