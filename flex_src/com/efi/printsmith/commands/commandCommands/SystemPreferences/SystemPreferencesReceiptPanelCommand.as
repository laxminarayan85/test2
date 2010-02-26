package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesReceiptPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesReceiptPanelDelegate;
	
	public class SystemPreferencesReceiptPanelCommand implements ICommand
	{
		public function SystemPreferencesReceiptPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesReceiptPanelEvent = event as SystemPreferencesReceiptPanelEvent;
			var delegate:SystemPreferencesReceiptPanelDelegate = new SystemPreferencesReceiptPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}