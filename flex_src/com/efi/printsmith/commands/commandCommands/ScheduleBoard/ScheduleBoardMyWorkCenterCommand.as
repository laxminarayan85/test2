package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardMyWorkCenterEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardMyWorkCenterDelegate;
	
	public class ScheduleBoardMyWorkCenterCommand implements ICommand
	{
		public function ScheduleBoardMyWorkCenterCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardMyWorkCenterEvent = event as ScheduleBoardMyWorkCenterEvent;
			var delegate:ScheduleBoardMyWorkCenterDelegate = new ScheduleBoardMyWorkCenterDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}