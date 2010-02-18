package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditPricingEvent;
	import com.efi.printsmith.view.PriceListEditor;
	import com.efi.printsmith.view.PriceListPicker;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditPricingDelegate extends InterfaceCommandDelegate 
	{
		public function EditPricingDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditPricingEvent):void {
			if (checkSecurity(EditPricingEvent.COMMANDID)) {
				var child:PriceListPicker = new PriceListPicker();
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