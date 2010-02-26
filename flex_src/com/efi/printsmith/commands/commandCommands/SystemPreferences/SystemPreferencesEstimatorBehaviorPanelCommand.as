package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesEstimatorBehaviorPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesEstimatorBehaviorPanelDelegate;
	
	public class SystemPreferencesEstimatorBehaviorPanelCommand implements ICommand
	{
		public function SystemPreferencesEstimatorBehaviorPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesEstimatorBehaviorPanelEvent = event as SystemPreferencesEstimatorBehaviorPanelEvent;
			var delegate:SystemPreferencesEstimatorBehaviorPanelDelegate = new SystemPreferencesEstimatorBehaviorPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}