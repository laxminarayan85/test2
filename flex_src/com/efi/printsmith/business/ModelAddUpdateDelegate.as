package com.efi.printsmith.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.IResponder;
	
	public class ModelAddUpdateDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function ModelAddUpdateDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("dataService");
		}
		
		public function addUpdate(item:Object):void {
			var call:Object = service.addUpdate(item);
			call.addResponder(responder);
		}
	}
}