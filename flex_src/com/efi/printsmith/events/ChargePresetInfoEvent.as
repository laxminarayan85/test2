package com.efi.printsmith.events
{
	import com.efi.printsmith.data.ChargeDefinition;
	
	import flash.events.Event;
	
	public class ChargePresetInfoEvent extends Event
	{
		public static const CHARGEPRESETOK:String = "ChargePresetOK";
		public static const CHARGEPRESETCANCEL:String = "ChargePresetCancel";
		
		public var chargeDefinition:ChargeDefinition;
		
		public function ChargePresetInfoEvent(type:String, chargeDefinition:ChargeDefinition)
		{
			super(type, true);
			this.chargeDefinition = chargeDefinition;
		}

		override public function clone():Event {
			return new ChargePresetInfoEvent(type, chargeDefinition);
		}
	}
}