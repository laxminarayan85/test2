package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditChargeDefinitionEvent;
	import com.efi.printsmith.view.ChargeDefinitions;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditChargeDefinitionDelegate extends InterfaceCommandDelegate 
	{
		public function EditChargeDefinitionDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditChargeDefinitionEvent):void {
			if (checkSecurity(EditChargeDefinitionEvent.COMMANDID)) {
				var child:ChargeDefinitions = new ChargeDefinitions();
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