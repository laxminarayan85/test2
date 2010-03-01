package com.efi.printsmith.business.commandDelegates.PendingList
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListDeliverEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class PendingListDeliverDelegate extends InterfaceCommandDelegate 
	{
		public function PendingListDeliverDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:PendingListDeliverEvent):void {
			if (checkSecurity(PendingListDeliverEvent.COMMANDID)) {
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}