package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Estimate;
	
	import flash.events.Event;
	
	public class CopyToNewEstimateEvent extends Event
	{
		public static const COPY_TO_NEWESTIMATE_EVENT:String = "copyToNewEstimateEvent";
		
		public var estimate:Estimate;
		
		public function CopyToNewEstimateEvent(type:String, estimate:Estimate)
		{
			super(type, true);
			this.estimate = estimate;
		}
		
		override public function clone():Event {
			return new CopyToNewEstimateEvent(type, estimate);
		}

	}
}