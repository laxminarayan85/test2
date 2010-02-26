package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesAddressFormattingPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesAddressFormattingPanelDelegate;
	
	public class SystemPreferencesAddressFormattingPanelCommand implements ICommand
	{
		public function SystemPreferencesAddressFormattingPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesAddressFormattingPanelEvent = event as SystemPreferencesAddressFormattingPanelEvent;
			var delegate:SystemPreferencesAddressFormattingPanelDelegate = new SystemPreferencesAddressFormattingPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}