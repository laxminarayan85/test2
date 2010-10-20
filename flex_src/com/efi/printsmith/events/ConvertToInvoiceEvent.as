package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Invoice;
	
	import flash.events.Event;
	
	public class ConvertToInvoiceEvent extends Event
	{
		public static const CONVERT_TO_INVOICE_EVENT:String = "convertToInvoiceEvent";
		
		public var invoice:Invoice;
		
		public var convertedEstimatedId:int;
		
		public function ConvertToInvoiceEvent(type:String, invoice:Invoice, convertedEstimatedId:int)
		{
			super(type, true);
			this.invoice = invoice;
			this.convertedEstimatedId = convertedEstimatedId;
		}
		
		override public function clone():Event {
			return new ConvertToInvoiceEvent(type, invoice, convertedEstimatedId);
		}

	}
}