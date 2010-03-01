package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListNotifyEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListNotifyDelegate;
	
	public class PendingListNotifyCommand implements ICommand
	{
		public function PendingListNotifyCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListNotifyEvent = event as PendingListNotifyEvent;
			var delegate:PendingListNotifyDelegate = new PendingListNotifyDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}