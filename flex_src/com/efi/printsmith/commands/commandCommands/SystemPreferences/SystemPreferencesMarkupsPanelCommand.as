package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesMarkupsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesMarkupsPanelDelegate;
	
	public class SystemPreferencesMarkupsPanelCommand implements ICommand
	{
		public function SystemPreferencesMarkupsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesMarkupsPanelEvent = event as SystemPreferencesMarkupsPanelEvent;
			var delegate:SystemPreferencesMarkupsPanelDelegate = new SystemPreferencesMarkupsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}