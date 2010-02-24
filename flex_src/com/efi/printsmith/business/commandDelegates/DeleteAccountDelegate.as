package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.DeleteAccountEvent;
	import com.efi.printsmith.view.EditCustomer;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class DeleteAccountDelegate extends InterfaceCommandDelegate 
	{
		public function DeleteAccountDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:DeleteAccountEvent):void {
			if (checkSecurity(DeleteAccountEvent.COMMANDID)) {
				var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event.account,null,null);
				responder.result(resEvent);
			} else {
				/* report error */
				var fault:Fault = new Fault("InvalidSecurityAccess","","genericPrefCmd.Insufficientaccessle")
				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, fault, null, null);
				responder.fault(faultEvent);
			}
		}
	}
}