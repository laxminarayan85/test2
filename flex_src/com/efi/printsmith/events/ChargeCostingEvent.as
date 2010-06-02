package com.efi.printsmith.events
{
	import com.efi.printsmith.data.ChargeCost;
	
	import flash.events.Event;
	
	public class ChargeCostingEvent extends Event
	{
		public static const CHARGECOSTINGOK:String = "ChargeCostingOK";
		public static const CHARGECOSTINGCANCEL:String = "ChargeCostingCancel";
		
		public var chargeCost:ChargeCost;
		
		public function ChargeCostingEvent(type:String, chargeCost:ChargeCost)
		{
			super(type, true);
			this.chargeCost = chargeCost;
		}

		override public function clone():Event {
			return new ChargeCostingEvent(type, chargeCost);
		}
	}
}