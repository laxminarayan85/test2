package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesSalesCategoriesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesSalesCategoriesPanelDelegate;
	
	public class SystemPreferencesSalesCategoriesPanelCommand implements ICommand
	{
		public function SystemPreferencesSalesCategoriesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesSalesCategoriesPanelEvent = event as SystemPreferencesSalesCategoriesPanelEvent;
			var delegate:SystemPreferencesSalesCategoriesPanelDelegate = new SystemPreferencesSalesCategoriesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}