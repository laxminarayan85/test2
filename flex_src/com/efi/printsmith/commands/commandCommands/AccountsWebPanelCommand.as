package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.AccountsWebPanelEvent;
	import com.efi.printsmith.business.commandDelegates.AccountsWebPanelDelegate;
	
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