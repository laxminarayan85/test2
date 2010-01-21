package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Charge;
	
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