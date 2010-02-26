package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesCashRegisterPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesCashRegisterPanelDelegate;
	
	public class SystemPreferencesCashRegisterPanelCommand implements ICommand
	{
		public function SystemPreferencesCashRegisterPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesCashRegisterPanelEvent = event as SystemPreferencesCashRegisterPanelEvent;
			var delegate:SystemPreferencesCashRegisterPanelDelegate = new SystemPreferencesCashRegisterPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}