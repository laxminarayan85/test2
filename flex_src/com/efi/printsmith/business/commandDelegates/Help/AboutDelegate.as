package com.efi.printsmith.business.commandDelegates.Help
{
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.Help.AboutEvent;
	import com.efi.printsmith.pages.About;
	
	import mx.rpc.IResponder;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.Fault;
	import mx.rpc.events.FaultEvent;
		
	public class AboutDelegate extends InterfaceCommandDelegate 
	{
		public function AboutDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:AboutEvent):void {
			if (checkSecurity(AboutEvent.COMMANDID)) {
				var child:About = new About();
				var resEventEnable:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
				responder.result(resEventEnable);
			} else {
				/* report error */
				var fault:Fault = new Fault("InvalidSecurityAccess","","genericPrefCmd.Insufficientaccessle")
				var faultEvent:FaultEvent = new FaultEvent(FaultEvent.FAULT,false, true, fault, null, null);
				responder.fault(faultEvent);
			}
		}
	}
}