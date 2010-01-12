package com.efi.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.vo.ModelBase;
	import com.efi.vo.Charge;
	
	public class PriceChargeEvent extends EventBase
	{
		public static const PRICECHARGE:String = "priceCharge";
		public var charge:Charge;
		
		public function PriceChargeEvent(charge:Charge, callbacks:IResponder=null)
		{
			this.charge = charge;
			super(PRICECHARGE, callbacks);
		}
		
		override public function clone():Event {
			return new PriceChargeEvent(charge, callbacks);
		}
	}
}