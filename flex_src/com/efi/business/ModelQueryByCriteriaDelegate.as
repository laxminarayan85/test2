package com.efi.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.IResponder;
	
	public class ModelQueryByCriteriaDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function ModelQueryByCriteriaDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("dataService");
		}
		
		public function queryByCriteria(modelType:String, criteria:ArrayCollection):void {
			var call:Object = service.criteriaQuery(modelType, criteria);
			call.addResponder(responder);
		}
	}
}