package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesAlternateCurrencyPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesAlternateCurrencyPanelDelegate;
	
	public class SystemPreferencesAlternateCurrencyPanelCommand implements ICommand
	{
		public function SystemPreferencesAlternateCurrencyPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesAlternateCurrencyPanelEvent = event as SystemPreferencesAlternateCurrencyPanelEvent;
			var delegate:SystemPreferencesAlternateCurrencyPanelDelegate = new SystemPreferencesAlternateCurrencyPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}