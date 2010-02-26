package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesPendingListPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesPendingListPanelDelegate;
	
	public class SystemPreferencesPendingListPanelCommand implements ICommand
	{
		public function SystemPreferencesPendingListPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesPendingListPanelEvent = event as SystemPreferencesPendingListPanelEvent;
			var delegate:SystemPreferencesPendingListPanelDelegate = new SystemPreferencesPendingListPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}