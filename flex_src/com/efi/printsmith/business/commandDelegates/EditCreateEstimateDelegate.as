package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditCreateEstimateEvent;
	import com.efi.printsmith.view.EditInvoice;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditCreateEstimateDelegate extends InterfaceCommandDelegate 
	{
		public function EditCreateEstimateDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditCreateEstimateEvent):void {
			if (checkSecurity(EditCreateEstimateEvent.COMMANDID)) {
				var child:EditInvoice = new EditInvoice();
				child.setEditorType(EditInvoice.EDITESTIMATE);
				var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
				responder.result(resEvent);
			} else {
				/* report error */
				Alert.show("Security Exception", null, Alert.OK, null, null, null, Alert.OK);
				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, null, null, null);
				responder.fault(faultEvent);
			}
		}
	}
}