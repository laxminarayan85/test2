package com.efi.printsmith.commands.commandCommands.Invoice
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.InvoiceChangeAccountsEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.InvoiceChangeAccountsDelegate;
	
	public class InvoiceChangeAccountsCommand implements ICommand
	{
		public function InvoiceChangeAccountsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:InvoiceChangeAccountsEvent = event as InvoiceChangeAccountsEvent;
			var delegate:InvoiceChangeAccountsDelegate = new InvoiceChangeAccountsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}