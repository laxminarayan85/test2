package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListPickupEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListPickupDelegate;
	
	public class PendingListPickupCommand implements ICommand
	{
		public function PendingListPickupCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListPickupEvent = event as PendingListPickupEvent;
			var delegate:PendingListPickupDelegate = new PendingListPickupDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}