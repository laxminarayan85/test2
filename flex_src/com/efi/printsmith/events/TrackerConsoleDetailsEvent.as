package com.efi.printsmith.events
{
	import com.efi.printsmith.data.TrackerConsoleJobs;
	
	import flash.events.Event;
	
	public class TrackerConsoleDetailsEvent extends Event
	{
		public static const SAVE_JOBDETAILS_EVENT:String = "saveJobDetailsEvent";
		
		public var isSave:Boolean;
		
		public var trackerConsoleJobs:TrackerConsoleJobs;
		
		public function TrackerConsoleDetailsEvent(type:String, isSave:Boolean, trackerConsoleJobs:TrackerConsoleJobs)
		{
			super(type, true);
			this.isSave = isSave;
			this.trackerConsoleJobs = trackerConsoleJobs;
		}
		
		override public function clone():Event {
			return new TrackerConsoleDetailsEvent(type, isSave, trackerConsoleJobs);
		}

	}
}