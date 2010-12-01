package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class FormPreferencesUpdateEvent extends Event
	{
		public static const FP_UPDATE_EVENT:String = "formPreferencesUpdateEvent";
		
		public var isSaved:Boolean;
		
		public function FormPreferencesUpdateEvent(type:String, isSaved:Boolean)
		{
			super(type, true);
			this.isSaved = isSaved;
		}
		
		override public function clone():Event {
			return new FormPreferencesUpdateEvent(type, isSaved);
		}

	}
}