package com.efi.printsmith.commands.commandCommands.Invoice
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.InvoiceChargesEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.InvoiceChargesDelegate;
	
	public class InvoiceChargesCommand implements ICommand
	{
		public function InvoiceChargesCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:InvoiceChargesEvent = event as InvoiceChargesEvent;
			var delegate:InvoiceChargesDelegate = new InvoiceChargesDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}