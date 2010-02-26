package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesCashDrawerPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesCashDrawerPanelDelegate;
	
	public class SystemPreferencesCashDrawerPanelCommand implements ICommand
	{
		public function SystemPreferencesCashDrawerPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesCashDrawerPanelEvent = event as SystemPreferencesCashDrawerPanelEvent;
			var delegate:SystemPreferencesCashDrawerPanelDelegate = new SystemPreferencesCashDrawerPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}