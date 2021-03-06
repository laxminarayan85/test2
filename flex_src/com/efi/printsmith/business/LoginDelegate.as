package com.efi.printsmith.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.SecureAMFChannel;
	import mx.rpc.IResponder;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.SecureAMFChannel;
	import mx.rpc.remoting.RemoteObject;
	
	public class LoginDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		private var cs:ChannelSet;
		
		public function LoginDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("loginService");
			
//			cs = new ChannelSet();
//			var chan:SecureAMFChannel = new SecureAMFChannel("my-secure-amf", "");
//			chan.pollingEnabled = true;
//			chan.pollingInterval = 3000;
//			cs.addChannel(chan);
//			service.channelSet = cs;
		}

		public function validateLogin(username:String, password:String):void {
			var call:Object = service.validateLogin(username, password);
			call.addResponder(responder);
		}
	}
}