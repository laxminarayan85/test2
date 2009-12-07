package com.efi.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.vo.ModelBase;
	
	public class PriceInvoiceEvent extends EventBase
	{
		public static const PRICEINVOICE:String = "priceInvoice";
		public var invoice:Invoice;
		
		public function PriceInvoiceEvent(invoice:Invoice, callbacks:IResponder=null)
		{
			this.invoice:Invoice;
			super(PRICEINVOICE, callbacks);
		}
		
		override public function clone():Event {
			return new PriceInvoiceEvent(charge, callbacks);
		}
	}
}