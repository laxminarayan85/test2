package com.efi.printsmith.commands.commandCommands.PendingList
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListDueDateEvent;
	import com.efi.printsmith.business.commandDelegates.PendingList.PendingListDueDateDelegate;
	
	public class PendingListDueDateCommand implements ICommand
	{
		public function PendingListDueDateCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PendingListDueDateEvent = event as PendingListDueDateEvent;
			var delegate:PendingListDueDateDelegate = new PendingListDueDateDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}