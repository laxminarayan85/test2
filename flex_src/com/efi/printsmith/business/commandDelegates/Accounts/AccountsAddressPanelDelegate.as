package com.efi.printsmith.business.commandDelegates.Accounts
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Accounts.AccountsAddressPanelEvent;
	import com.efi.printsmith.view.EditCustomer;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class AccountsAddressPanelDelegate extends InterfaceCommandDelegate 
	{
		public function AccountsAddressPanelDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:AccountsAddressPanelEvent):void {
			if (checkSecurity(AccountsAddressPanelEvent.COMMANDID)) {
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