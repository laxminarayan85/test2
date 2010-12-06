package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class LabelFormatUpdateEvent extends Event
	{
		public static const LABELFORMAT_UPDATE_EVENT:String = "labelFormatUpdateEvent";
		
		public var isSaved:Boolean;
		
		public function LabelFormatUpdateEvent(type:String, isSaved:Boolean)
		{
			super(type, true);
			this.isSaved = isSaved;
		}
		
		override public function clone():Event {
			return new LabelFormatUpdateEvent(type, isSaved);
		}

	}
}