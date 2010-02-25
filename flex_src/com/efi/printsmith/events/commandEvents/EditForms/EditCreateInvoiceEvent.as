package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Invoice;

	public class EditCreateInvoiceEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CreateInvoice";
		public var object:Invoice;
		
		public function EditCreateInvoiceEvent(object:Invoice, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditCreateInvoiceEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCreateInvoiceEvent(object, callbacks);
		}
	}
}