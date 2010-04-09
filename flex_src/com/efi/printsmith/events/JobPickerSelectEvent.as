package com.efi.printsmith.events
{
	import com.efi.printsmith.data.JobBase;
	
	import flash.events.Event;
	
	public class JobPickerSelectEvent extends Event
	{
		public static const SELECTJOB:String = "SelectJob";
		public static const CANCELSELECTJOB:String = "CancelSelectJob";
		
		public var job:JobBase;
		
		public function JobPickerSelectEvent(type:String, job:JobBase)
		{
			super(type, true);
			this.job = job;
		}

		override public function clone():Event {
			return new JobPickerSelectEvent(type, job);
		}
	}
}