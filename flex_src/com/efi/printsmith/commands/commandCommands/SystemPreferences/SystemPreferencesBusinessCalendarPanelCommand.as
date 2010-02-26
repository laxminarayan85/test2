package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesBusinessCalendarPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesBusinessCalendarPanelDelegate;
	
	public class SystemPreferencesBusinessCalendarPanelCommand implements ICommand
	{
		public function SystemPreferencesBusinessCalendarPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesBusinessCalendarPanelEvent = event as SystemPreferencesBusinessCalendarPanelEvent;
			var delegate:SystemPreferencesBusinessCalendarPanelDelegate = new SystemPreferencesBusinessCalendarPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}