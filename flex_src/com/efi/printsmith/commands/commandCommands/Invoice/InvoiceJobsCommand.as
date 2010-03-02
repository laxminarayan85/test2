package com.efi.printsmith.commands.commandCommands.Invoice
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.InvoiceJobsEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.InvoiceJobsDelegate;
	
	public class InvoiceJobsCommand implements ICommand
	{
		public function InvoiceJobsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:InvoiceJobsEvent = event as InvoiceJobsEvent;
			var delegate:InvoiceJobsDelegate = new InvoiceJobsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}