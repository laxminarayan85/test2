package com.efi.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.IResponder;
	
	public class ModelGetSingleDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function ModelGetSingleDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("dataService");
		}
		
		public function getSingle(modelType:String):void {
			var call:Object = service.getSingle(modelType);
			call.addResponder(responder);
		}
	}
}