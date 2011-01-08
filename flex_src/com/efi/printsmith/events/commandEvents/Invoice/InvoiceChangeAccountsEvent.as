package com.efi.printsmith.events.commandEvents.Invoice
{
	import com.efi.printsmith.events.commandEvents.*;
	
	import flash.events.Event;
	
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class InvoiceChangeAccountsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Invoice_ChangeAccounts";

		public var button:Button;
		public var enabled:Boolean;

		public function InvoiceChangeAccountsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(InvoiceChangeAccountsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new InvoiceChangeAccountsEvent(button, callbacks);
		}
	}
}