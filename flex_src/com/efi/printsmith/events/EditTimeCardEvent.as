package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class EditTimeCardEvent extends Event
	{
		public static const EDIT_DATA_SAVE:String = "editDataSave";
		
		public var isSave:Boolean;
		
		public function EditTimeCardEvent(type:String, isSave:Boolean)
		{
			super(type, true);
			this.isSave = isSave;
		}
		
		override public function clone():Event {
			return new EditTimeCardEvent(type, isSave);
		}

	}
}