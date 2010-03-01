package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListStatusEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListStatusDelegate;
	
	public class PendingListStatusCommand implements ICommand
	{
		public function PendingListStatusCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListStatusEvent = event as PendingListStatusEvent;
			var delegate:PendingListStatusDelegate = new PendingListStatusDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}