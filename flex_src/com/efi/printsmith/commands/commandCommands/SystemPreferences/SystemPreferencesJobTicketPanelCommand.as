package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesJobTicketPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesJobTicketPanelDelegate;
	
	public class SystemPreferencesJobTicketPanelCommand implements ICommand
	{
		public function SystemPreferencesJobTicketPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesJobTicketPanelEvent = event as SystemPreferencesJobTicketPanelEvent;
			var delegate:SystemPreferencesJobTicketPanelDelegate = new SystemPreferencesJobTicketPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}