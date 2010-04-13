// ActionScript file
package com.efi.printsmith.business.commandDelegates.Users
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.events.commandEvents.Users.PasswordEvent
	
	import mx.controls.Alert;
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class PasswordDelegate extends InterfaceCommandDelegate 
	{
		public function PasswordDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:PasswordEvent):void {
			if (checkSecurity(PasswordEvent.COMMANDID)) {
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventEnable);
			} else {
				var resEventDisable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,event,null,null);
				responder.result(resEventDisable);
			}
		}
	}
}