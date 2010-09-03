package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.efi.printsmith.data.TrackerManager")]
	[Managed]
	public dynamic class TrackerManager extends ModelBase
	{
		public function TrackerManager()
		{
			remoteObjectName = "com.efi.printsmith.data.TrackerManager";
		}
		
		public var productionFacilities:ProductionFacilities;
		
		public var showAllFacilities:Boolean = false;
		
		public var showAllStations:Boolean = false;
		
		public var selectedStations:ArrayCollection;

	}
}