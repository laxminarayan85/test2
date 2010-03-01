package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListLocationEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListLocationDelegate;
	
	public class PendingListLocationCommand implements ICommand
	{
		public function PendingListLocationCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListLocationEvent = event as PendingListLocationEvent;
			var delegate:PendingListLocationDelegate = new PendingListLocationDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}