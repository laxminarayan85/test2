package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Charge;
	
	import flash.events.Event;
	
	public class UpdateChargeEvent extends Event
	{
		public static const UPDATECHARGE_EVENT:String = "updateChargeEvent";
		
		public var charge:Charge;
		
		public var jobIndex:int;
		
		public var isSave:Boolean;
		
		public function UpdateChargeEvent(type:String, charge:Charge, jobIndex:int, isSave:Boolean)
		{
			super(type, true);
			this.charge = charge;
			this.jobIndex = jobIndex;
			this.isSave = isSave;
		}
		
		override public function clone():Event {
			return new UpdateChargeEvent(type, charge, jobIndex, isSave);
		}

	}
}