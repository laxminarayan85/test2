package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Estimate;
	
	import flash.events.Event;
	
	public class EstimateHistorySaveEvent extends Event
	{
		public static const ESTIMATES_SAVE_EVENT:String = "estimatesSaveEvent";
		
		public var estimate:Estimate; 
		
		public function EstimateHistorySaveEvent(type:String, estimate:Estimate)
		{
			super(type, true);
			this.estimate = estimate;
		}
		
		override public function clone():Event {
			return new EstimateHistorySaveEvent(type, estimate);
		}

	}
}