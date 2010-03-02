package com.efi.printsmith.events.commandEvents.Invoice
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.LinkButton;
	import mx.rpc.IResponder;

	public class InvoiceJobsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Invoice_Jobs";

		public var button:LinkButton;
		public var enabled:Boolean;

		public function InvoiceJobsEvent(item:LinkButton, callbacks:IResponder=null)
		{
			this.button = item;
			super(InvoiceJobsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new InvoiceJobsEvent(button, callbacks);
		}
	}
}