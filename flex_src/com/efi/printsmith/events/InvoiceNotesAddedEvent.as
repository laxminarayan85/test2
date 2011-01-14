package com.efi.printsmith.events
{
	import com.efi.printsmith.data.NotePad;
	
	import flash.events.Event;
	
	public class InvoiceNotesAddedEvent extends Event
	{
		public static const INVOICENOTESADDED:String = "InvoiceNotesAdded";
		
		public var notes:NotePad;
		
		public function InvoiceNotesAddedEvent(type:String, notes:NotePad)
		{
			super(type, true);
			this.notes = notes;
		}

		override public function clone():Event {
			return new InvoiceNotesAddedEvent(type, notes);
		}

	}
}