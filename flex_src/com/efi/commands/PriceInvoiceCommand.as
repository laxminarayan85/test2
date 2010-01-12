package com.efi.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.business.PricingDelegate;
	import com.efi.events.ModelGetAllEvent;
	import com.efi.events.PriceInvoiceEvent;

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