package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.EditForms.EditPricingEvent;
	import com.efi.printsmith.view.PriceListEditor;
	import com.efi.printsmith.view.PriceListPicker;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditPricingDelegate extends InterfaceCommandDelegate 
	{
		public function EditPricingDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditPricingEvent):void {
//			if (checkSecurity(EditPricingEvent.COMMANDID)) {
				var child:PriceListPicker = new PriceListPicker();
				if (child.checkSecurityAccess())	{
					var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
					responder.result(resEvent);
				}
//			} else {
//				/* report error */
//				var fault:Fault = new Fault("InvalidSecurityAccess","","genericPrefCmd.Insufficientaccessle")
//				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, fault, null, null);
//				responder.fault(faultEvent);
//			}
		}
	}
}