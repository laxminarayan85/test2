package com.efi.mdi.event.window
{
	import flash.events.Event;
	
	public class WindowConfirmStatusEvent extends Event
	{
		public function WindowConfirmStatusEvent(type:String,windowConfirmStatus:int) {
            super(type);
            this.windowConfirmStatus = windowConfirmStatus;
        }
        
        public static const WINDOW_CONFIRM_STATUS:String = "windowConfirmStatus";

        
        public var windowConfirmStatus:int;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new WindowConfirmStatusEvent(type, windowConfirmStatus);
        }


	}
}