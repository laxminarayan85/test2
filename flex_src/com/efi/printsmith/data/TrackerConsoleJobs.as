package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.efi.printsmith.data.TrackerConsoleJobs")]
	[Managed]
	public class TrackerConsoleJobs extends ModelBase
	{
		public function TrackerConsoleJobs()
		{
			remoteObjectName = "com.efi.printsmith.data.TrackerConsoleJobs";
		}
		
			
		public var productionFacilities:ProductionFacilities;
		
		public var productionStations:ProductionStations;
		
		public var productionLocations:ProductionLocations;
		
		public var employee:Employee;
		
		public var job:Job;
		
		public var charge:Charge;
		
		public var actualSetUpTime:Number;
		
		public var actualRunTime:Number;
		
		public var actualWashTime:Number;
		
		public var duration:Number;
		
		public var firstTrackerDate:Date;
		
		public var firstTrackerTime:Number;
	
		public var firstSetUpTime:Number; 
		
		public var firstRunTime:Number;
		
		public var firstWashTime:Number;
		
		public var firstSetUpDate:Date; 
		
		public var firstRunDate:Date;
		
		public var firstWashDate:Date;
		
		public var secondTrackerDate:Date;
		
		public var secondTrackerTime:Number;
	
		public var secondSetUpTime:Number; 
		
		public var secondRunTime:Number;
		
		public var secondWashTime:Number;
		
		public var secondSetUpDate:Date; 
		
		public var secondRunDate:Date;
		
		public var secondWashDate:Date;
		
		public var totalTime:Number;
		
		public var noOfPasses:int;
		
		public var paused:Boolean = false;
		
		public var currentPass:int;
		
		public var firstSetUpCompleted:Boolean = false;
		
		public var firstWashCompleted:Boolean = false;
		
		public var secondSetUpCompleted:Boolean = false;
		
		public var secondWashCompleted:Boolean = false;
		
		public var completed:Boolean = false;

	}
}