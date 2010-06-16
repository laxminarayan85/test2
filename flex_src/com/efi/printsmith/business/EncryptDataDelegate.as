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
	
	public class EncryptDataDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		private var cs:ChannelSet;
		
		public function EncryptDataDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("encryptionService");

//			cs = new ChannelSet();
//			
//			var chan:SecureAMFChannel = new SecureAMFChannel("my-secure-amf", Snowmass.getInstance().getApplicationRootURL() + "/messagebroker/amfsecure");
//			chan.pollingEnabled = true;
//			chan.pollingInterval = 3000;
//			cs.addChannel(chan);
//			service.channelSet = cs;
		}

		public function encryptData(encryptionData:String, encryptionStyle:String):void {
			var call:Object = service.encryptData(encryptionData, encryptionStyle);
			call.addResponder(responder);
		}
		
		public function decryptData(encryptionData:String, encryptionStyle:String):void {
			var call:Object = service.decryptData(encryptionData, encryptionStyle);
			call.addResponder(responder);
		}
	}
}