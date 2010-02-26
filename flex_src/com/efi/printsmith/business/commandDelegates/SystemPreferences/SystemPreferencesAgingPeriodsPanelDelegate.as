package com.efi.printsmith.business.commandDelegates.SystemPreferences
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesAgingPeriodsPanelEvent;
	import com.efi.printsmith.view.SystemPreferences;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class SystemPreferencesAgingPeriodsPanelDelegate extends InterfaceCommandDelegate 
	{
		public function SystemPreferencesAgingPeriodsPanelDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:SystemPreferencesAgingPeriodsPanelEvent):void {
			if (checkSecurity(SystemPreferencesAgingPeriodsPanelEvent.COMMANDID)) {
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