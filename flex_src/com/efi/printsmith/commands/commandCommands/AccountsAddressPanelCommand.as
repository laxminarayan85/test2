package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.AccountsAddressPanelEvent;
	import com.efi.printsmith.business.commandDelegates.AccountsAddressPanelDelegate;
	
	public class AccountsAddressPanelCommand implements ICommand
	{
		public function AccountsAddressPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsAddressPanelEvent = event as AccountsAddressPanelEvent;
			var delegate:AccountsAddressPanelDelegate = new AccountsAddressPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}