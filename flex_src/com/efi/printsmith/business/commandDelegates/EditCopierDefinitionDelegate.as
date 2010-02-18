package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditCopierDefinitionEvent;
	import com.efi.printsmith.view.CopierDefinitions;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditCopierDefinitionDelegate extends InterfaceCommandDelegate 
	{
		public function EditCopierDefinitionDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditCopierDefinitionEvent):void {
			if (checkSecurity(EditCopierDefinitionEvent.COMMANDID)) {
				var child:CopierDefinitions = new CopierDefinitions();
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