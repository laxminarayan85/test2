package com.efi.printsmith.business.commandDelegates.PendingList
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListScheduleEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class PendingListScheduleDelegate extends InterfaceCommandDelegate 
	{
		public function PendingListScheduleDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:PendingListScheduleEvent):void {
			if (checkSecurity(PendingListScheduleEvent.COMMANDID)) {
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}