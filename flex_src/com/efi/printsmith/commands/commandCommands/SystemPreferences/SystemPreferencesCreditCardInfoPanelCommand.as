package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesCreditCardInfoPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesCreditCardInfoPanelDelegate;
	
	public class SystemPreferencesCreditCardInfoPanelCommand implements ICommand
	{
		public function SystemPreferencesCreditCardInfoPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesCreditCardInfoPanelEvent = event as SystemPreferencesCreditCardInfoPanelEvent;
			var delegate:SystemPreferencesCreditCardInfoPanelDelegate = new SystemPreferencesCreditCardInfoPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}