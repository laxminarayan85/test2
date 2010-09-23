package com.efi.printsmith.events
{
	import com.efi.printsmith.data.CreditCardTransactions;
	
	import flash.events.Event;
	
	public class CreditCardTransEvent extends Event
	{
		public static const WRITE:String = "Write";
		public static const COMPLETE:String = "Complete";
				
		public var theData:CreditCardTransactions;

		public function CreditCardTransEvent(type:String, theData:CreditCardTransactions)
		{
			super(type, true);
			this.theData = theData;
		}

		override public function clone():Event {
			return new CreditCardTransEvent(type, theData);
		}
	}
}