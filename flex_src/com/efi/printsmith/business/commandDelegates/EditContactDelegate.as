package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditContactEvent;
	import com.efi.printsmith.view.EditContact;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditContactDelegate extends InterfaceCommandDelegate 
	{
		public function EditContactDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditContactEvent):void {
			if (checkSecurity(EditContactEvent.COMMANDID)) {
				var child:EditContact = new EditContact();
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