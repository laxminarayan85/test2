package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesAgingPeriodsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesAgingPeriodsPanelDelegate;
	
	public class SystemPreferencesAgingPeriodsPanelCommand implements ICommand
	{
		public function SystemPreferencesAgingPeriodsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesAgingPeriodsPanelEvent = event as SystemPreferencesAgingPeriodsPanelEvent;
			var delegate:SystemPreferencesAgingPeriodsPanelDelegate = new SystemPreferencesAgingPeriodsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}