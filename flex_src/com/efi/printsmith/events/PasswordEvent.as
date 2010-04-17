// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;

	public class PasswordEvent extends Event
	{
		public static const OK:String = "OK";
		public static const Cancel:String = "Cancel";
		
		public function PasswordEvent(type:String)
		{
			super(type);
		}
		
		override public function clone():Event {
			return new PasswordEvent(type);
		}
	}
}