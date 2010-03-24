package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Employees.EmployeeTimePeriodsEvent;
	import com.efi.printsmith.business.commandDelegates.Employees.EmployeeTimePeriodsDelegate;
	
	public class EmployeeTimePeriodsCommand implements ICommand
	{
		public function EmployeeTimePeriodsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeTimePeriodsEvent = event as EmployeeTimePeriodsEvent;
			var delegate:EmployeeTimePeriodsDelegate = new EmployeeTimePeriodsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}