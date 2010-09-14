package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.RoutingStepSetUp")]
	[Managed]
	public dynamic class RoutingStepSetUp extends ModelBase
	{
		public function RoutingStepSetUp()
		{
			remoteObjectName = "com.efi.printsmith.data.RoutingStepSetUp";
		}
		
		public var title:String = "";
	
		public var routeDisabled:Boolean = false;
		
		public var defaultRouteForNewJobs:Boolean = false;
		
		public var productionFacilities:ProductionFacilities;
		
		public var productionLocations:ProductionLocations;
		
		public var stepDisabled:Boolean = false;
		
		public var markInvReady:Boolean = false;
		
		public var treatAsNonProdStep:Boolean = false;
		
		public var productionDates:ProductionDates;
		
		public var autoScheduleDaysFromOrdered:int = 0;
		
		public var autoScheduleDaysFromWantedBy:int = 0;
		
		public var hourOfDay:String = "";
		
		public var routeData:Boolean = false;
		
		public var parentRoute:RoutingStepSetUp;

	}
}