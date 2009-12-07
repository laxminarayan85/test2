package com.efi.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.vo.ModelBase;
	
	public class PriceJobEvent extends EventBase
	{
		public static const PRICEJOB:String = "priceJob";
		public var job:Job;
		
		public function PriceJobEvent(job:Job, callbacks:IResponder=null)
		{
			this.job = job;
			super(PRICEJOB, callbacks);
		}
		
		override public function clone():Event {
			return new PriceJobEvent(job, callbacks);
		}
	}
}