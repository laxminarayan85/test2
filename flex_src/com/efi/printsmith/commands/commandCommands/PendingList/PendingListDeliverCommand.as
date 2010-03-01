package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListDeliverEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListDeliverDelegate;
	
	public class PendingListDeliverCommand implements ICommand
	{
		public function PendingListDeliverCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListDeliverEvent = event as PendingListDeliverEvent;
			var delegate:PendingListDeliverDelegate = new PendingListDeliverDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}