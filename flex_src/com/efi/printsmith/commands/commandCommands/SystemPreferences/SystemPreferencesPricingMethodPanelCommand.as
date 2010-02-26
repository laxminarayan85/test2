package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesPricingMethodPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesPricingMethodPanelDelegate;
	
	public class SystemPreferencesPricingMethodPanelCommand implements ICommand
	{
		public function SystemPreferencesPricingMethodPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesPricingMethodPanelEvent = event as SystemPreferencesPricingMethodPanelEvent;
			var delegate:SystemPreferencesPricingMethodPanelDelegate = new SystemPreferencesPricingMethodPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}