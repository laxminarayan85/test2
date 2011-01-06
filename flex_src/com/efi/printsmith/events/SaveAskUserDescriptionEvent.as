package com.efi.printsmith.events
{	
	import flash.events.Event;
	
	public class SaveAskUserDescriptionEvent extends Event
	{
		public var description:String;
		public var placeHolder:Object;
		public var opCode:int;
		
		public function SaveAskUserDescriptionEvent(type:String, desc:String, obj:Object, opCode:int)
		{
			super(type, true);
			this.description = desc;
			this.placeHolder = obj;		// pass through - user defined
			this.opCode = opCode;		// pass through
		}

		override public function clone():Event {
			return new SaveAskUserDescriptionEvent(type, description, placeHolder, opCode);
		}
	}
}