package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.EditForms.WasteChartEvent;
	//import com.efi.printsmith.page
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class WasteChartDelegate extends InterfaceCommandDelegate 
	{
		public function WasteChartDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:WasteChartEvent):void {
			if (checkSecurity(WasteChartEvent.COMMANDID)) {
			//	var child:ChangePassword = new ChangePassword();
			//	var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
			//	responder.result(resEvent);
			} else {
				/* report error */
				var fault:Fault = new Fault("InvalidSecurityAccess","","genericPrefCmd.Insufficientaccessle")
				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, fault, null, null);
				responder.fault(faultEvent);
			}
		}
	}
}