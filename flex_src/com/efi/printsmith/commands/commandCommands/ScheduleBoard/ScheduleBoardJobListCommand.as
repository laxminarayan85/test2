package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardJobListEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardJobListDelegate;
	
	public class ScheduleBoardJobListCommand implements ICommand
	{
		public function ScheduleBoardJobListCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardJobListEvent = event as ScheduleBoardJobListEvent;
			var delegate:ScheduleBoardJobListDelegate = new ScheduleBoardJobListDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}