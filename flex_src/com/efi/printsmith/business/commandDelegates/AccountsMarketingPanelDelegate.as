package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.AccountsMarketingPanelEvent;
	import com.efi.printsmith.view.EditCustomer;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class AccountsMarketingPanelDelegate extends InterfaceCommandDelegate 
	{
		public function AccountsMarketingPanelDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:AccountsMarketingPanelEvent):void {
			if (checkSecurity(AccountsMarketingPanelEvent.COMMANDID)) {
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