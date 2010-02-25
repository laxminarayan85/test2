package com.efi.printsmith.commands.commandCommands.Accounts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsSettingsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Accounts.AccountsSettingsPanelDelegate;
	
	public class AccountsSettingsPanelCommand implements ICommand
	{
		public function AccountsSettingsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AccountsSettingsPanelEvent = event as AccountsSettingsPanelEvent;
			var delegate:AccountsSettingsPanelDelegate = new AccountsSettingsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}