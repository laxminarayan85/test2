package com.efi.printsmith.business.commandDelegates.Jobs
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Invoice.JobsChangeCopierEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class JobsChangeCopierDelegate extends InterfaceCommandDelegate 
	{
		public function JobsChangeCopierDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:JobsChangeCopierEvent):void {
			if (checkSecurity(JobsChangeCopierEvent.COMMANDID)) {
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