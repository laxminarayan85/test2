package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Invoice;
	
	public class PriceInvoiceEvent extends EventBase
	{
		public static const PRICEINVOICE:String = "priceInvoice";
		public var invoice:Invoice;
		
		public function PriceInvoiceEvent(invoice:Invoice, callbacks:IResponder=null)
		{
			this.invoice = invoice;
			super(PRICEINVOICE, callbacks);
		}
		
		override public function clone():Event {
			return new PriceInvoiceEvent(invoice, callbacks);
		}
	}
}