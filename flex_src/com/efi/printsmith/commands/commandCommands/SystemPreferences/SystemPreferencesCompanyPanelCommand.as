package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesCompanyPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesCompanyPanelDelegate;
	
	public class SystemPreferencesCompanyPanelCommand implements ICommand
	{
		public function SystemPreferencesCompanyPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesCompanyPanelEvent = event as SystemPreferencesCompanyPanelEvent;
			var delegate:SystemPreferencesCompanyPanelDelegate = new SystemPreferencesCompanyPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}