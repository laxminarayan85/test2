package com.efi.printsmith.security
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import com.efi.printsmith.data.SecuritySetup;
	import com.efi.printsmith.data.Users;
	
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
   
   	public class PSSecurity
	{
		private var setupComplete:Boolean = false;
		private var securityDictionary:Dictionary;
		
		public function PSSecurity(user:Users)
		{
			setupComplete = false;
			var service:Object = ServiceLocator.getInstance().getRemoteObject("dataService");
			if (user.accessGroup != null) {
				var call:Object = service.getFromParent("SecuritySetup", "accessgroup",user.accessGroup.id);
				call.addResponder(new Responder(handleResult,handleFault));
			}
		}
		
		public function handleResult(evt:ResultEvent):void {
			var securitySetupList:ArrayCollection = evt.result as ArrayCollection;
			var i:int;
			securityDictionary = new Dictionary();
			
			for (i = 0; i<securitySetupList.length; i++) {
				var securitySetup:SecuritySetup = securitySetupList.getItemAt(i) as SecuritySetup;
				
				securityDictionary[securitySetup.commandId] = securitySetup.enable;
			}
			
			setupComplete = true;
		}

		public function handleFault(evt:FaultEvent):void {
			/* TODO - report error back to user */
		}
		
		public function commandEnabled(commandId:String):Boolean {
			if (setupComplete && securityDictionary.hasOwnProperty(commandId)) {
				return securityDictionary[commandId] as Boolean;
			} else {
				return false;
			}
		}
		
	}
}