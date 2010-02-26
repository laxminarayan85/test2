package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesEstimatorPrintingPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesEstimatorPrintingPanelDelegate;
	
	public class SystemPreferencesEstimatorPrintingPanelCommand implements ICommand
	{
		public function SystemPreferencesEstimatorPrintingPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesEstimatorPrintingPanelEvent = event as SystemPreferencesEstimatorPrintingPanelEvent;
			var delegate:SystemPreferencesEstimatorPrintingPanelDelegate = new SystemPreferencesEstimatorPrintingPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}