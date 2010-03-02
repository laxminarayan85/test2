package com.efi.printsmith.commands.commandCommands.Employee
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.EmployeeClockInOutEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.EmployeeClockInOutDelegate;
	
	public class EmployeeClockInOutCommand implements ICommand
	{
		public function EmployeeClockInOutCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeClockInOutEvent = event as EmployeeClockInOutEvent;
			var delegate:EmployeeClockInOutDelegate = new EmployeeClockInOutDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}