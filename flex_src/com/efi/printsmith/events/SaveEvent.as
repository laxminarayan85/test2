// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;

	public class SaveEvent extends Event
	{
		public static const Save:String = "Save";
		public static const Cancel:String = "Cancel";
		public static const DontSave:String = "DontSave";
		
		public function SaveEvent(type:String)
		{
			super(type);
		}
		
		override public function clone():Event {
			return new SaveEvent(type);
		}
	}
}