package com.efi.printsmith.commands.commandCommands.Jobs
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.JobsChangeStockEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.JobsChangeStockDelegate;
	
	public class JobsChangeStockCommand implements ICommand
	{
		public function JobsChangeStockCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:JobsChangeStockEvent = event as JobsChangeStockEvent;
			var delegate:JobsChangeStockDelegate = new JobsChangeStockDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}