package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.WasteChartEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.WasteChartDelegate;
	
	public class WasteChartCommand implements ICommand
	{
		public function WasteChartCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var wasteChartEvent:WasteChartEvent = event as WasteChartEvent;
			var delegate:WasteChartDelegate = new WasteChartDelegate(wasteChartEvent.callbacks);
			
			delegate.handleUIEvent(wasteChartEvent);
		}
		
	}
}