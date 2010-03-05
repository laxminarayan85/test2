package com.efi.printsmith.business.commandDelegates.ScheduleBoard
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardJobListEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class ScheduleBoardJobListDelegate extends InterfaceCommandDelegate 
	{
		public function ScheduleBoardJobListDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:ScheduleBoardJobListEvent):void {
			if (checkSecurity(ScheduleBoardJobListEvent.COMMANDID)) {
				event.enabled = true;
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				event.enabled = false;
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}