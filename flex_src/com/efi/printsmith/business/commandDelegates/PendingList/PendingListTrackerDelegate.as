package com.efi.printsmith.business.commandDelegates.PendingList
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListTrackerEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class PendingListTrackerDelegate extends InterfaceCommandDelegate 
	{
		public function PendingListTrackerDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:PendingListTrackerEvent):void {
			if (checkSecurity(PendingListTrackerEvent.COMMANDID)) {
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}