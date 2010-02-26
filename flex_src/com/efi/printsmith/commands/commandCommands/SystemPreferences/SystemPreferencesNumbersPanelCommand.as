package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesNumbersPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesNumbersPanelDelegate;
	
	public class SystemPreferencesNumbersPanelCommand implements ICommand
	{
		public function SystemPreferencesNumbersPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesNumbersPanelEvent = event as SystemPreferencesNumbersPanelEvent;
			var delegate:SystemPreferencesNumbersPanelDelegate = new SystemPreferencesNumbersPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}