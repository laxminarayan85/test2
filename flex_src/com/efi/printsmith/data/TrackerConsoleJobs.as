package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.efi.printsmith.data.TrackerConsoleJobs")]
	[Managed]
	public dynamic class TrackerConsoleJobs extends ModelBase
	{
		public function TrackerConsoleJobs()
		{
			remoteObjectName = "com.efi.printsmith.data.TrackerConsoleJobs";
		}
		
			
		public var productionFacilities:ProductionFacilities;
		
		public var productionStations:ProductionStations;
		
		public var productionLocations:ProductionLocations;
		
		public var nextProductionLocation:ProductionLocations;
		
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
		
		public var clockBreak:Boolean = false;
		
		public var currentPass:int;
		
		public var passesList:ArrayCollection;
		
		public var completed:Boolean = false;
		
		public var completedDate:Date;
		
		public var productionExceptions:ProductionExceptions;
	
		public var notes:String = "";
		
		public var markStepComplete:Boolean = false;
		
		public var moveToNonProdStep:Boolean = false;
		
		public var treatAsNonProdStep:Boolean = false;
		
		public var actualTotalTime:Number;
		
		public var appendNotesToJobTicketNotes:Boolean = false;
		
		public var qtyOrdered:Number;
	
		public var impressions:Number;
		
		public var spoilage:Number;
		
		public var totalCost:Number;
		
		public var totalSetUpTime:Number;
		
		public var totalRunTime:Number;
		
		public var totalWashUpTime:Number;
		
		public var startSpoilage:Number = 0;
		
		public var endSpoilage:Number = 0;
		
		public var difference:Number = 0;
		
		public var canceled:Boolean = false;

	}
}