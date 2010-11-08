package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWorkInProgressEvent;
	import com.efi.printsmith.view.WorkinProgress;
	
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditWorkInProgressDelegate extends InterfaceCommandDelegate 
	{
		public function EditWorkInProgressDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditWorkInProgressEvent):void {
//			if (checkSecurity(EditWorkInProgressEvent.COMMANDID)) {
				var child:WorkinProgress = new WorkinProgress();
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