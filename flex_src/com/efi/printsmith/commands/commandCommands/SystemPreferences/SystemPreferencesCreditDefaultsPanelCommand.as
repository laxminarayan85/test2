package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesCreditDefaultsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesCreditDefaultsPanelDelegate;
	
	public class SystemPreferencesCreditDefaultsPanelCommand implements ICommand
	{
		public function SystemPreferencesCreditDefaultsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesCreditDefaultsPanelEvent = event as SystemPreferencesCreditDefaultsPanelEvent;
			var delegate:SystemPreferencesCreditDefaultsPanelDelegate = new SystemPreferencesCreditDefaultsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}