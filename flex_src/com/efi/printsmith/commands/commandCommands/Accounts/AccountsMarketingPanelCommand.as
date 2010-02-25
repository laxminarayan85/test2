package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsMarketingPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsMarketingPanelDelegate;
	
	public class AccountsMarketingPanelCommand implements ICommand
	{
		public function AccountsMarketingPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsMarketingPanelEvent = event as AccountsMarketingPanelEvent;
			var delegate:AccountsMarketingPanelDelegate = new AccountsMarketingPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}