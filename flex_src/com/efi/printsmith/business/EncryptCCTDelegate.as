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
	import com.efi.printsmith.data.CreditCardTransactions;
	
	public class EncryptCCTDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		private var cs:ChannelSet;
		
		public function EncryptCCTDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("encryptionService");
		}

		public function encryptCCT(cct:CreditCardTransactions):void {
			var call:Object = service.encryptCCT(cct);
			call.addResponder(responder);
		}
		
		public function decryptCCT(cct:CreditCardTransactions):void {
			var call:Object = service.decryptCCT(cct);
			call.addResponder(responder);
		}
	}
}