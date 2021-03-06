package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsCreditControlPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsCreditControlPanelDelegate;
	
	public class AccountsCreditControlPanelCommand implements ICommand
	{
		public function AccountsCreditControlPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsCreditControlPanelEvent = event as AccountsCreditControlPanelEvent;
			var delegate:AccountsCreditControlPanelDelegate = new AccountsCreditControlPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}