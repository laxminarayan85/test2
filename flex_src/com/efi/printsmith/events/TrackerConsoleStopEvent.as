package com.efi.printsmith.events
{
	import com.efi.printsmith.data.TrackerConsoleJobs;
	
	import flash.events.Event;
	
	public class TrackerConsoleStopEvent extends Event
	{
		public static const STOP_JOB_EVENT:String = "stopJobEvent";
		
		public var isStop:Boolean;
		
		public var trackerConsoleJobs:TrackerConsoleJobs;
		
		public function TrackerConsoleStopEvent(type:String, isStop:Boolean, trackerConsoleJobs:TrackerConsoleJobs)
		{
			super(type, true);
			this.isStop = isStop;
			this.trackerConsoleJobs = trackerConsoleJobs;
		}
		
		override public function clone():Event {
			return new TrackerConsoleStopEvent(type, isStop, trackerConsoleJobs);
		}

	}
}