package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Job;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class JobEditCompleteEvent extends Event
	{
		public static const SAVE:String = "JobEditSave";
		public static const DELETE:String = "JobEditDelete";
		public static const CANCEL:String = "JobEditCancel";
		
		public var jobIndex:Number = 0;
		
		public var job:Job;
		
		public var multiQtyJobList:ArrayCollection = new ArrayCollection(); 
		
		public var updateLocationDate:Boolean= false;
		
		public function JobEditCompleteEvent(type:String, job:Job, multiQtyJobList:ArrayCollection=null, jobIndex:Number=-1, updateLocationDate:Boolean=false)
		{
			super(type, true);
			this.job = job;
			this.multiQtyJobList = multiQtyJobList;
			this.jobIndex = jobIndex;
			this.updateLocationDate = updateLocationDate;
		}

		override public function clone():Event {
			return new JobEditCompleteEvent(type, job, multiQtyJobList, jobIndex, updateLocationDate);
		}
	}
}