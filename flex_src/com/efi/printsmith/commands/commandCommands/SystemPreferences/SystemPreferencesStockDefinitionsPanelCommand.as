package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesStockDefinitionsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesStockDefinitionsPanelDelegate;
	
	public class SystemPreferencesStockDefinitionsPanelCommand implements ICommand
	{
		public function SystemPreferencesStockDefinitionsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesStockDefinitionsPanelEvent = event as SystemPreferencesStockDefinitionsPanelEvent;
			var delegate:SystemPreferencesStockDefinitionsPanelDelegate = new SystemPreferencesStockDefinitionsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}