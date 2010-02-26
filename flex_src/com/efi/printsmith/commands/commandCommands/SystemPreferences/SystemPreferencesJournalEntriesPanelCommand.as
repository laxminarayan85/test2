package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesJournalEntriesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesJournalEntriesPanelDelegate;
	
	public class SystemPreferencesJournalEntriesPanelCommand implements ICommand
	{
		public function SystemPreferencesJournalEntriesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesJournalEntriesPanelEvent = event as SystemPreferencesJournalEntriesPanelEvent;
			var delegate:SystemPreferencesJournalEntriesPanelDelegate = new SystemPreferencesJournalEntriesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}