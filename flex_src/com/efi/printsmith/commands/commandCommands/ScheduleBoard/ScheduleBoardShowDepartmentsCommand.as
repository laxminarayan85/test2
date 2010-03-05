package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardShowDepartmentsEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardShowDepartmentsDelegate;
	
	public class ScheduleBoardShowDepartmentsCommand implements ICommand
	{
		public function ScheduleBoardShowDepartmentsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardShowDepartmentsEvent = event as ScheduleBoardShowDepartmentsEvent;
			var delegate:ScheduleBoardShowDepartmentsDelegate = new ScheduleBoardShowDepartmentsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}