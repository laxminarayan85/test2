package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesStocksandSizesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesStocksandSizesPanelDelegate;
	
	public class SystemPreferencesStocksandSizesPanelCommand implements ICommand
	{
		public function SystemPreferencesStocksandSizesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesStocksandSizesPanelEvent = event as SystemPreferencesStocksandSizesPanelEvent;
			var delegate:SystemPreferencesStocksandSizesPanelDelegate = new SystemPreferencesStocksandSizesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}