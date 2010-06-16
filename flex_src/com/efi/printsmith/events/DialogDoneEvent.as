package com.efi.printsmith.events
{	
	import flash.events.Event;
	
	public class DialogDoneEvent extends Event
	{
		public static const OK:String = "DialogDoneOK";
		public static const CANCEL:String = "DialogDoneCancel";
		
		public function DialogDoneEvent(type:String)
		{
			super(type, true);
		}

		override public function clone():Event {
			return new DialogDoneEvent(type);
		}
	}
}