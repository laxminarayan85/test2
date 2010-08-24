package com.efi.printsmith.data
{
	[RemoteClass(alias="com.efi.printsmith.data.TrackerConsolePasses")]
	[Managed]
	public class TrackerConsolePasses extends ModelBase
	{
		public function TrackerConsolePasses()
		{
			remoteObjectName = "com.efi.printsmith.data.TrackerConsolePasses";
		}
		
		public var trackTime:Number;
	
		public var trackDate:Date;
		
		public var setUpTime:Number;
		
		public var setUpDate:Date;
		
		public var setUpCompleted:Boolean = false;
		
		public var runTime:Number;
		
		public var runDate:Date;
		
		public var runCompleted:Boolean = false;
		
		public var washUpTime:Number;
		
		public var washUpDate:Date;
		
		public var washUpCompleted:Boolean = false;
		
		public var passNo:int = 0;
		
		public var trackerConsoleJobs:TrackerConsoleJobs;

	}
}