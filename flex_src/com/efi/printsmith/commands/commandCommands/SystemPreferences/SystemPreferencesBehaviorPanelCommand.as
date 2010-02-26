package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesBehaviorPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesBehaviorPanelDelegate;
	
	public class SystemPreferencesBehaviorPanelCommand implements ICommand
	{
		public function SystemPreferencesBehaviorPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesBehaviorPanelEvent = event as SystemPreferencesBehaviorPanelEvent;
			var delegate:SystemPreferencesBehaviorPanelDelegate = new SystemPreferencesBehaviorPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}