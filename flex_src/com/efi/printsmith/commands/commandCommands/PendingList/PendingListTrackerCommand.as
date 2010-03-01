package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListTrackerEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListTrackerDelegate;
	
	public class PendingListTrackerCommand implements ICommand
	{
		public function PendingListTrackerCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListTrackerEvent = event as PendingListTrackerEvent;
			var delegate:PendingListTrackerDelegate = new PendingListTrackerDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}