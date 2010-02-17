package com.efi.printsmith.business.commandDelegates
{
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.CommandEventBase;
	
	import mx.rpc.IResponder;
	
	public class InterfaceCommandDelegate
	{
		public var responder:IResponder;
		
		public function InterfaceCommandDelegate(responder:IResponder) {
			this.responder = responder;
		}
		
		public function checkSecurity(cmdId:String):Boolean {
			if (Snowmass.getInstance().security.commandEnabled(cmdId)) {
				return true;
			}
			return false;
		}
		
		public function handleEvent(event:CommandEventBase):void {
		}
	}
}