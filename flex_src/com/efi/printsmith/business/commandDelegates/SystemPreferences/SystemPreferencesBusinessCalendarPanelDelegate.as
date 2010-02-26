package com.efi.printsmith.business.commandDelegates.SystemPreferences
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.SystemPreferencesBusinessCalendarPanelEvent;
	import com.efi.printsmith.view.SystemPreferences;
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class SystemPreferencesBusinessCalendarPanelDelegate extends InterfaceCommandDelegate 
	{
		public function SystemPreferencesBusinessCalendarPanelDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:SystemPreferencesBusinessCalendarPanelEvent):void {
			if (checkSecurity(SystemPreferencesBusinessCalendarPanelEvent.COMMANDID)) {
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