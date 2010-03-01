package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListScheduleEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListScheduleDelegate;
	
	public class PendingListScheduleCommand implements ICommand
	{
		public function PendingListScheduleCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListScheduleEvent = event as PendingListScheduleEvent;
			var delegate:PendingListScheduleDelegate = new PendingListScheduleDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}