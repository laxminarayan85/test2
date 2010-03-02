package com.efi.printsmith.business.commandDelegates.Invoice
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Invoice.InvoiceChangeAccountsEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class InvoiceChangeAccountsDelegate extends InterfaceCommandDelegate 
	{
		public function InvoiceChangeAccountsDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:InvoiceChangeAccountsEvent):void {
			if (checkSecurity(InvoiceChangeAccountsEvent.COMMANDID)) {
				event.enabled = true;
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				event.enabled = false;
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}