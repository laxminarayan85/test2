package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesQuantityBreaksPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesQuantityBreaksPanelDelegate;
	
	public class SystemPreferencesQuantityBreaksPanelCommand implements ICommand
	{
		public function SystemPreferencesQuantityBreaksPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesQuantityBreaksPanelEvent = event as SystemPreferencesQuantityBreaksPanelEvent;
			var delegate:SystemPreferencesQuantityBreaksPanelDelegate = new SystemPreferencesQuantityBreaksPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}