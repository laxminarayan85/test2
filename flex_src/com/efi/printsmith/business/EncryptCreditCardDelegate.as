package com.efi.printsmith.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.SecureAMFChannel;
	import mx.rpc.IResponder;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.SecureAMFChannel;
	import mx.rpc.remoting.RemoteObject;
	import flash.system.Security;
	
	public class EncryptCreditCardDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		private var cs:ChannelSet;
		
		public function EncryptCreditCardDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("creditCardService");

//			cs = new ChannelSet();
//			
//			var chan:SecureAMFChannel = new SecureAMFChannel("my-secure-amf", Snowmass.getInstance().getApplicationRootURL() + "/messagebroker/amfsecure");
//			chan.pollingEnabled = true;
//			chan.pollingInterval = 3000;
//			cs.addChannel(chan);
//			service.channelSet = cs;
		}

		public function encryptCreditCard(value:String):void {
			var call:Object = service.encryptCreditCard(value);
			call.addResponder(responder);
		}
	}
}