package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.DeleteAccountEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.DeleteAccountDelegate;
	
	public class DeleteAccountCommand implements ICommand
	{
		public function DeleteAccountCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:DeleteAccountEvent = event as DeleteAccountEvent;
			var delegate:DeleteAccountDelegate = new DeleteAccountDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}