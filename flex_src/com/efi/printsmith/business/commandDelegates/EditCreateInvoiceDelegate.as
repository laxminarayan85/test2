package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditCreateInvoiceEvent;
	import com.efi.printsmith.view.EditInvoice;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditCreateInvoiceDelegate extends InterfaceCommandDelegate 
	{
		public function EditCreateInvoiceDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditCreateInvoiceEvent):void {
			if (checkSecurity(EditCreateInvoiceEvent.COMMANDID)) {
				var child:EditInvoice = new EditInvoice();
				child.setEditorType(EditInvoice.EDITINVOICE);
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