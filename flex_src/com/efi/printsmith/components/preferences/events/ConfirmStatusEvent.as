package com.efi.printsmith.components.preferences.events
{
	import flash.events.Event;
	
	public class ConfirmStatusEvent extends Event
	{
		public function ConfirmStatusEvent(type:String,confirmStatus:int) {
            super(type);
            this.confirmStatus = confirmStatus;
        }
        
        public static const CONFIRM_STATUS:String = "confirmStatus";

        
        public var confirmStatus:int;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new ConfirmStatusEvent(type, confirmStatus);
        }


	}
}