package com.efi.printsmith.business.commandDelegates.PendingList
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.PendingList.PendingListOpenEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class PendingListOpenDelegate extends InterfaceCommandDelegate 
	{
		public function PendingListOpenDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:PendingListOpenEvent):void {
			if (checkSecurity(PendingListOpenEvent.COMMANDID)) {
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}