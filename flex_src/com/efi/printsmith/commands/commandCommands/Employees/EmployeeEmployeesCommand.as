package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.EmployeeEmployeesEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.EmployeeEmployeesDelegate;
	
	public class EmployeeEmployeesCommand implements ICommand
	{
		public function EmployeeEmployeesCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeEmployeesEvent = event as EmployeeEmployeesEvent;
			var delegate:EmployeeEmployeesDelegate = new EmployeeEmployeesDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}