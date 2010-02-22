package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.DeleteStockDefinitionEvent;
	import com.efi.printsmith.view.StockDefinitions;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class DeleteStockDefinitionDelegate extends InterfaceCommandDelegate 
	{
		public function DeleteStockDefinitionDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:DeleteStockDefinitionEvent):void {
			if (checkSecurity(DeleteStockDefinitionEvent.COMMANDID)) {
				var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event.stockdef,null,null);
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