package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardEditDepartmentsEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardEditDepartmentsDelegate;
	
	public class ScheduleBoardEditDepartmentsCommand implements ICommand
	{
		public function ScheduleBoardEditDepartmentsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardEditDepartmentsEvent = event as ScheduleBoardEditDepartmentsEvent;
			var delegate:ScheduleBoardEditDepartmentsDelegate = new ScheduleBoardEditDepartmentsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}