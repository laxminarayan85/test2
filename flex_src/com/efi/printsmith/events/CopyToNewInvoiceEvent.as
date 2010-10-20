package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Invoice;
	
	import flash.events.Event;
	
	public class CopyToNewInvoiceEvent extends Event
	{
		public static const COPY_TO_NEWINVOICE_EVENT:String = "copyToNewInvoiceEvent";
		
		public var invoice:Invoice;
		
		public function CopyToNewInvoiceEvent(type:String, invoice:Invoice)
		{
			super(type, true);
			this.invoice = invoice;
		}
		
		override public function clone():Event {
			return new CopyToNewInvoiceEvent(type, invoice);
		}

	}
}