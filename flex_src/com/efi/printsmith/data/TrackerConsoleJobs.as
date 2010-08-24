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
		
		public var totalTime:Number;
		
		public var noOfPasses:int;
		
		public var paused:Boolean = false;
		
		public var currentPass:int;
		
		public var passesList:ArrayCollection;
		
		public var completed:Boolean = false;
		
		public var completedDate:Date;

	}
}