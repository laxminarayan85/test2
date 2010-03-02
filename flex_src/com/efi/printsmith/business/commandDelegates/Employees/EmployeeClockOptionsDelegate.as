package com.efi.printsmith.business.commandDelegates.Employees
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Invoice.EmployeeClockOptionsEvent;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EmployeeClockOptionsDelegate extends InterfaceCommandDelegate 
	{
		public function EmployeeClockOptionsDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EmployeeClockOptionsEvent):void {
			if (checkSecurity(EmployeeClockOptionsEvent.COMMANDID)) {
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