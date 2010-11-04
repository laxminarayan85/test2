package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.EditForms.EditAccountHistoryEvent;
	import com.efi.printsmith.view.AccountHistory;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditAccountHistoryDelegate extends InterfaceCommandDelegate 
	{
		public function EditAccountHistoryDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditAccountHistoryEvent):void {
//			if (checkSecurity(EditAccountHistoryEvent.COMMANDID)) {
				var child:AccountHistory = new AccountHistory();
				if (child.checkSecurityAccess())	{
					var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
					responder.result(resEvent);
				}
//			} else {
//				/* report error */
////				Alert.show(securityExceptionMessage, null, Alert.OK, null, null, null, Alert.OK);
//				var fault:Fault = new Fault("InvalidSecurityAccess","","genericPrefCmd.Insufficientaccessle")
//				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, fault, null, null);
//				responder.fault(faultEvent);
//			}
		}
	}
}