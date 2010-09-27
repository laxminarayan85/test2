package com.efi.mdi.event.window
{
	import flash.events.Event;
	
	public class WindowSaveSuccessEvent extends Event
	{
		public function WindowSaveSuccessEvent(type:String,isSaved:Boolean) {
            super(type);
            this.isSaved = isSaved;
        }
        
        public static const WINDOW_SAVESUCCESS_STATUS:String = "windowSaveSuccessStatus";

        
        public var isSaved:Boolean;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new WindowSaveSuccessEvent(type, isSaved);
        }


	}
}