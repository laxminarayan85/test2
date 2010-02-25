package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsWebPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsWebPanelDelegate;
	
	public class AccountsWebPanelCommand implements ICommand
	{
		public function AccountsWebPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsWebPanelEvent = event as AccountsWebPanelEvent;
			var delegate:AccountsWebPanelDelegate = new AccountsWebPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}