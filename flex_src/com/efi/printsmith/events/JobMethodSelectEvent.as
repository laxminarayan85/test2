package com.efi.printsmith.events
{
	import com.efi.printsmith.data.PreferencesPricingMethod;
	
	import flash.events.Event;
	
	public class JobMethodSelectEvent extends Event
	{
		public static const SELECTJOBMETHOD:String = "SelectJobMethod";
		public static const CANCELSELECTJOBMETHOD:String = "CancelSelectJobMethod";
		
		public var pricingMethod:PreferencesPricingMethod;
		
		public function JobMethodSelectEvent(type:String, pricingMethod:PreferencesPricingMethod)
		{
			super(type, true);
			this.pricingMethod = pricingMethod;
		}

		override public function clone():Event {
			return new JobMethodSelectEvent(type, pricingMethod);
		}
	}
}