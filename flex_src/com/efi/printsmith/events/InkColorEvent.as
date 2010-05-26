// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;

	public class InkColorEvent extends Event
	{
		public var tempArray: ArrayCollection;
		public static const Close:String = "Close";
		
		public function InkColorEvent(type:String, tempArray:ArrayCollection)
		{
			super(type);
			this.tempArray = tempArray;
		}
		
		override public function clone():Event {
			return new InkColorEvent(type, tempArray);
		}
	}
}