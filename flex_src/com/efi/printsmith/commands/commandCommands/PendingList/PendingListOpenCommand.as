package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListOpenEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListOpenDelegate;
	
	public class PendingListOpenCommand implements ICommand
	{
		public function PendingListOpenCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListOpenEvent = event as PendingListOpenEvent;
			var delegate:PendingListOpenDelegate = new PendingListOpenDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}