package com.efi.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.IResponder;
	
	public class ModelGetAllDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function ModelGetAllDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("dataService");
		}
		
		public function getAll(modelType:String):void {
			var call:Object = service.getAll(modelType);
			call.addResponder(responder);
		}
	}
}