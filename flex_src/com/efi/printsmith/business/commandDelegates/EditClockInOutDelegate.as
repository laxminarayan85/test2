package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditClockInOutEvent;
	import com.efi.printsmith.view.ClockInOut;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditClockInOutDelegate extends InterfaceCommandDelegate 
	{
		public function EditClockInOutDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditClockInOutEvent):void {
			if (checkSecurity(EditClockInOutEvent.COMMANDID)) {
				var child:ClockInOut = new ClockInOut();
				child.showCloseButton=false;
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