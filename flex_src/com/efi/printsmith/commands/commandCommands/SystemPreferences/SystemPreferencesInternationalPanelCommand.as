package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesInternationalPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesInternationalPanelDelegate;
	
	public class SystemPreferencesInternationalPanelCommand implements ICommand
	{
		public function SystemPreferencesInternationalPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesInternationalPanelEvent = event as SystemPreferencesInternationalPanelEvent;
			var delegate:SystemPreferencesInternationalPanelDelegate = new SystemPreferencesInternationalPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}