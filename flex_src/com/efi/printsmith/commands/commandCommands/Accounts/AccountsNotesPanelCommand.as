package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsNotesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsNotesPanelDelegate;
	
	public class AccountsNotesPanelCommand implements ICommand
	{
		public function AccountsNotesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsNotesPanelEvent = event as AccountsNotesPanelEvent;
			var delegate:AccountsNotesPanelDelegate = new AccountsNotesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}