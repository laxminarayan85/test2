package com.efi.printsmith.events
{
	import flash.events.Event;
	
	public class JobNotesAddedEvent extends Event
	{
		public static const JOBNOTESADDED:String = "JobNotesAdded";
		
		public var notes:String;
		
		public function JobNotesAddedEvent(type:String, notes:String)
		{
			super(type, true);
			this.notes = notes;
		}

		override public function clone():Event {
			return new JobNotesAddedEvent(type, notes);
		}

	}
}