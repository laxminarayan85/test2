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
	
	public class UpdateAllRecordsToNewKeyDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		private var cs:ChannelSet;
		
		public function UpdateAllRecordsToNewKeyDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("encryptionService");
		}

		public function UpdateAllRecordsToNewKey():void {
			var call:Object = service.UpdateAllRecordsToNewKey();
			call.addResponder(responder);
		}
		
		public function PurgeEncryptedDataFields():void {
			var call:Object = service.PurgeEncryptedDataFields();
			call.addResponder(responder);
		}
		
	}
}