package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.InvoiceBase;

	public class EditEditInvoiceEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditInvoice";
		public var object:InvoiceBase;
		
		public function EditEditInvoiceEvent(object:InvoiceBase, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditEditInvoiceEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditEditInvoiceEvent(object, callbacks);
		}
	}
}