package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardEditCostCentersEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardEditCostCentersDelegate;
	
	public class ScheduleBoardEditCostCentersCommand implements ICommand
	{
		public function ScheduleBoardEditCostCentersCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardEditCostCentersEvent = event as ScheduleBoardEditCostCentersEvent;
			var delegate:ScheduleBoardEditCostCentersDelegate = new ScheduleBoardEditCostCentersDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}