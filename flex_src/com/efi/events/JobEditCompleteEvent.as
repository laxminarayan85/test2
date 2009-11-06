package com.efi.events
{
	import com.efi.vo.Address;
	import com.efi.vo.Job;
	
	import flash.events.Event;
	
	public class JobEditCompleteEvent extends Event
	{
		public static const SAVE:String = "JobEditSave";
		public static const CANCEL:String = "JobEditCancel";
		
		public var job:Job;
		
		public function JobEditCompleteEvent(type:String, job:Job)
		{
			super(type, true);
			this.job = job;
		}

		override public function clone():Event {
			return new JobEditCompleteEvent(type, job);
		}
	}
}