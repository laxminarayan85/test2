package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditCustomerEvent;
	import com.efi.printsmith.view.EditCustomer;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.controls.Alert;
	
	public class EditCustomerDelegate extends InterfaceCommandDelegate 
	{
		public function EditCustomerDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditCustomerEvent):void {
			if (checkSecurity(EditCustomerEvent.COMMANDID)) {
				var child:EditCustomer = new EditCustomer();
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