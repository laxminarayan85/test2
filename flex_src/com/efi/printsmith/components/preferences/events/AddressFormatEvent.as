package com.efi.printsmith.components.preferences.events
{
	import com.efi.printsmith.data.Country;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class AddressFormatEvent extends Event
	{
		public function AddressFormatEvent(type:String,isSave:Boolean) {
            super(type);
            this.isSave = isSave;
        }
        
        public static const ADDRESSFORMAT_CHANGED:String = "addressFormatChanged";

        
        public var isSave:Boolean;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new AddressFormatEvent(type, isSave);
        }

	}
}