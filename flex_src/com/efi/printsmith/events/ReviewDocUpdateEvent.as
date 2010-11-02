package com.efi.printsmith.events
{
	import com.efi.printsmith.data.InvoiceBase;
	
	import flash.events.Event;
	
	public class ReviewDocUpdateEvent extends Event
	{
		public static const REVIEW_DOC_UPDATE:String = "reviewDocUpdate";
		
		public var invoice:InvoiceBase;
		
		public function ReviewDocUpdateEvent(type:String, invoice:InvoiceBase)
		{
			super(type, true);
			this.invoice = invoice;
		}
		
		override public function clone():Event {
			return new ReviewDocUpdateEvent(type, invoice);
		}

	}
}