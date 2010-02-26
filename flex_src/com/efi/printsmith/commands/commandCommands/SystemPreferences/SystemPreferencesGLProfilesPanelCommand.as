package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesGLProfilesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesGLProfilesPanelDelegate;
	
	public class SystemPreferencesGLProfilesPanelCommand implements ICommand
	{
		public function SystemPreferencesGLProfilesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesGLProfilesPanelEvent = event as SystemPreferencesGLProfilesPanelEvent;
			var delegate:SystemPreferencesGLProfilesPanelDelegate = new SystemPreferencesGLProfilesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}