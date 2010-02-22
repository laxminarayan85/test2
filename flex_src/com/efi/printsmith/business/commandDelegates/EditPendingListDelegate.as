package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditPendingListEvent;
	import com.efi.printsmith.view.PendingList;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditPendingListDelegate extends InterfaceCommandDelegate 
	{
		public function EditPendingListDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditPendingListEvent):void {
			if (checkSecurity(EditPendingListEvent.COMMANDID)) {
				var child:PendingList = new PendingList();
				var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
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