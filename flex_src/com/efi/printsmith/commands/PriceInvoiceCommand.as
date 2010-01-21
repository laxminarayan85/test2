package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.PricingDelegate;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.PriceInvoiceEvent;

	public class PriceInvoiceCommand implements ICommand
	{
		public function PriceInvoiceCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var priceInvoiceEvent:PriceInvoiceEvent = event as PriceInvoiceEvent;
			var delegate:PricingDelegate = new PricingDelegate(priceInvoiceEvent.callbacks);
			
			delegate.priceInvoice(priceInvoiceEvent.invoice);
		}
		
	}
}