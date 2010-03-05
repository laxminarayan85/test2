package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardShowCostCentersEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardShowCostCentersDelegate;
	
	public class ScheduleBoardShowCostCentersCommand implements ICommand
	{
		public function ScheduleBoardShowCostCentersCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardShowCostCentersEvent = event as ScheduleBoardShowCostCentersEvent;
			var delegate:ScheduleBoardShowCostCentersDelegate = new ScheduleBoardShowCostCentersDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}