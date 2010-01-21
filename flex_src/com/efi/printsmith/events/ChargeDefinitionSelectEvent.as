package com.efi.printsmith.events
{
	import com.efi.printsmith.data.StockDefinition;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class ChargeDefinitionSelectEvent extends Event
	{
		public static const CHARGEDEFINITIONCOMPLETE:String = "ChargeDefinitionComplete";
		public static const CHARGEDEFINITIONCANCEL:String = "ChargeDefinitionCancel";
		
		public var chargeArray:ArrayCollection;
		
		public function ChargeDefinitionSelectEvent(type:String, chargeArray:ArrayCollection)
		{
			super(type, true);
			this.chargeArray = chargeArray;
		}

		override public function clone():Event {
			return new ChargeDefinitionSelectEvent(type, chargeArray);
		}
	}
}