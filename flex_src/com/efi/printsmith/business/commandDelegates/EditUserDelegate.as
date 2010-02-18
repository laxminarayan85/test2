package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditUserEvent;
	import com.efi.printsmith.view.EditUser;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditUserDelegate extends InterfaceCommandDelegate 
	{
		public function EditUserDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditUserEvent):void {
			if (checkSecurity(EditUserEvent.COMMANDID)) {
				var child:EditUser = new EditUser();
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