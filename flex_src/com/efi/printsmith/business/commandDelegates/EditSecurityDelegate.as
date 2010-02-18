package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditSecurityEvent;
	import com.efi.printsmith.view.SecurityManager;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditSecurityDelegate extends InterfaceCommandDelegate 
	{
		public function EditSecurityDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditSecurityEvent):void {
			if (checkSecurity(EditSecurityEvent.COMMANDID)) {
				var child:SecurityManager = new SecurityManager();
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