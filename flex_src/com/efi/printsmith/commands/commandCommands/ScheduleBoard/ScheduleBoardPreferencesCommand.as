package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardPreferencesEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardPreferencesDelegate;
	
	public class ScheduleBoardPreferencesCommand implements ICommand
	{
		public function ScheduleBoardPreferencesCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardPreferencesEvent = event as ScheduleBoardPreferencesEvent;
			var delegate:ScheduleBoardPreferencesDelegate = new ScheduleBoardPreferencesDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}