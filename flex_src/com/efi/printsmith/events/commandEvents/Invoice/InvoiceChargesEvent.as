package com.efi.printsmith.events.commandEvents.Invoice
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.LinkButton;
	import mx.rpc.IResponder;

	public class InvoiceChargesEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Invoice_Charges";

		public var button:LinkButton;
		public var enabled:Boolean;

		public function InvoiceChargesEvent(item:LinkButton, callbacks:IResponder=null)
		{
			this.button = item;
			super(InvoiceChargesEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new InvoiceChargesEvent(button, callbacks);
		}
	}
}