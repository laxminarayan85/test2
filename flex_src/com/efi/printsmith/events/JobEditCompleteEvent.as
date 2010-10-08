package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Job;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class JobEditCompleteEvent extends Event
	{
		public static const SAVE:String = "JobEditSave";
		public static const CANCEL:String = "JobEditCancel";
		
		public var job:Job;
		
		public var multiQtyJobList:ArrayCollection = new ArrayCollection(); 
		
		public function JobEditCompleteEvent(type:String, job:Job, multiQtyJobList:ArrayCollection=null)
		{
			super(type, true);
			this.job = job;
			this.multiQtyJobList = multiQtyJobList;
		}

		override public function clone():Event {
			return new JobEditCompleteEvent(type, job, multiQtyJobList);
		}
	}
}