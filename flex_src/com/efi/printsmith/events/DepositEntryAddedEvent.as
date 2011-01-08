package com.efi.printsmith.events
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class DepositEntryAddedEvent extends Event
	{
		public static const DEPOSITENTRYADDED:String = "DepositEntryAdded";
		
		public var depositsArray:ArrayCollection;
		
		public function DepositEntryAddedEvent(type:String, depositsArray:ArrayCollection)
		{
			super(type, true);
			this.depositsArray = depositsArray;
		}

		override public function clone():Event {
			return new DepositEntryAddedEvent(type, depositsArray);
		}

	}
}