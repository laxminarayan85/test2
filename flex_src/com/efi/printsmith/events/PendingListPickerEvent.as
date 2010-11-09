package com.efi.printsmith.events
{
	import com.efi.printsmith.data.InvoiceBase;
	
	import flash.events.Event;
	
	public class PendingListPickerEvent extends Event
	{
		public static const PENDINGLIST_PICKER_SELECT_EVENT:String = "pendingListPickerSelect";
		
		public var invoiceBase:InvoiceBase; 
		
		public function PendingListPickerEvent(type:String, invoiceBase:InvoiceBase)
		{
			super(type, true);
			this.invoiceBase = invoiceBase;
		}
		
		override public function clone():Event {
			return new PendingListPickerEvent(type, invoiceBase);
		}

	}
}