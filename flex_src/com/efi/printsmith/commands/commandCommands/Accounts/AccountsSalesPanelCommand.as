package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsSalesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsSalesPanelDelegate;
	
	public class AccountsSalesPanelCommand implements ICommand
	{
		public function AccountsSalesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsSalesPanelEvent = event as AccountsSalesPanelEvent;
			var delegate:AccountsSalesPanelDelegate = new AccountsSalesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}