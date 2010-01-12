package com.efi.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import com.efi.vo.*;
	
	import mx.rpc.IResponder;
	
	public class PricingDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function PricingDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("pricingService");
		}
		
		public function priceInvoice(invoice:Invoice):void {
			var call:Object = service.priceInvoice(invoice);
			call.addResponder(responder);
		}
		
		public function priceJob(job:Job):void {
			var call:Object = service.priceJob(job);
			call.addResponder(responder);
		}
		
		public function priceCharge(charge:Charge):void {
			var call:Object = service.priceCharge(charge);
			call.addResponder(responder);
		}
	}
}