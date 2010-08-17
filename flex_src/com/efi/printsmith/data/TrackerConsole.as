package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.efi.printsmith.data.TrackerConsole")]
	[Managed]
	public dynamic class TrackerConsole extends ModelBase
	{
		public function TrackerConsole()
		{
			remoteObjectName = "com.efi.printsmith.data.TrackerConsole";
		}
		
		public var productionFacilities:ProductionFacilities;
		
		public var productionStations:ProductionStations;
		
		public var hideItemsNotReleasedToProd:Boolean = false;
		
		public var showEmployeeProdParents:Boolean = false;
		
		public var showSelectedEmployee:Boolean = false;
		
		public var showAllFacilities:Boolean = false;
		
		public var showAllStations:Boolean = false;
		
		public var selectedStations:ArrayCollection;
		
		public var pendingListSize:String = "";
		
		public var activeListSize:String = "";

	}
}