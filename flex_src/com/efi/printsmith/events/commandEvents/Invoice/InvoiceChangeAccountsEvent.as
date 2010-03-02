package com.efi.printsmith.events.commandEvents.Invoice
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.LinkButton;
	import mx.rpc.IResponder;

	public class InvoiceChangeAccountsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Invoice_ChangeAccounts";

		public var button:LinkButton;
		public var enabled:Boolean;

		public function InvoiceChangeAccountsEvent(item:LinkButton, callbacks:IResponder=null)
		{
			this.button = item;
			super(InvoiceChangeAccountsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new InvoiceChangeAccountsEvent(button, callbacks);
		}
	}
}