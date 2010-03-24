package com.efi.printsmith.commands.commandCommands.Employees
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Employees.EmployeeTimeCardsEvent;
	import com.efi.printsmith.business.commandDelegates.Employees.EmployeeTimeCardsDelegate;
	
	public class EmployeeTimeCardsCommand implements ICommand
	{
		public function EmployeeTimeCardsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:EmployeeTimeCardsEvent = event as EmployeeTimeCardsEvent;
			var delegate:EmployeeTimeCardsDelegate = new EmployeeTimeCardsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}