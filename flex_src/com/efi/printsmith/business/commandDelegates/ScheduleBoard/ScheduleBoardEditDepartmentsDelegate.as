package com.efi.printsmith.business.commandDelegates.ScheduleBoard
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardEditDepartmentsEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class ScheduleBoardEditDepartmentsDelegate extends InterfaceCommandDelegate 
	{
		public function ScheduleBoardEditDepartmentsDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:ScheduleBoardEditDepartmentsEvent):void {
			if (checkSecurity(ScheduleBoardEditDepartmentsEvent.COMMANDID)) {
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