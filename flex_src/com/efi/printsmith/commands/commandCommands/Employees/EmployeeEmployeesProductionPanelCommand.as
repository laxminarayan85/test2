package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.EmployeeEmployeesProductionPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.EmployeeEmployeesProductionPanelDelegate;
	
	public class EmployeeEmployeesProductionPanelCommand implements ICommand
	{
		public function EmployeeEmployeesProductionPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeEmployeesProductionPanelEvent = event as EmployeeEmployeesProductionPanelEvent;
			var delegate:EmployeeEmployeesProductionPanelDelegate = new EmployeeEmployeesProductionPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}