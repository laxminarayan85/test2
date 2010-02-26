package com.efi.printsmith.commands.commandCommands.SystemPreferences
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesPaperCalculatorPanelEvent;
	import com.efi.printsmith.business.commandDelegates.SystemPreferences.SystemPreferencesPaperCalculatorPanelDelegate;
	
	public class SystemPreferencesPaperCalculatorPanelCommand implements ICommand
	{
		public function SystemPreferencesPaperCalculatorPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:SystemPreferencesPaperCalculatorPanelEvent = event as SystemPreferencesPaperCalculatorPanelEvent;
			var delegate:SystemPreferencesPaperCalculatorPanelDelegate = new SystemPreferencesPaperCalculatorPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}