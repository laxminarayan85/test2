package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.AccountsLogPanelEvent;
	import com.efi.printsmith.business.commandDelegates.AccountsLogPanelDelegate;
	
	public class AccountsLogPanelCommand implements ICommand
	{
		public function AccountsLogPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsLogPanelEvent = event as AccountsLogPanelEvent;
			var delegate:AccountsLogPanelDelegate = new AccountsLogPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}