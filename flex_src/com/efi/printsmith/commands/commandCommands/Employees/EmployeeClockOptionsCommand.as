package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Employees.EmployeeClockOptionsEvent;
	import com.efi.printsmith.business.commandDelegates.Employees.EmployeeClockOptionsDelegate;
	
	public class EmployeeClockOptionsCommand implements ICommand
	{
		public function EmployeeClockOptionsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeClockOptionsEvent = event as EmployeeClockOptionsEvent;
			var delegate:EmployeeClockOptionsDelegate = new EmployeeClockOptionsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}