package com.efi.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.rpc.IResponder;
	
	public class LoginDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function LoginDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("loginService");		
		}

		public function validateLogin(username:String, password:String):void {
			var call:Object = service.validateLogin(username, password);
			call.addResponder(responder);
		}
	}
}