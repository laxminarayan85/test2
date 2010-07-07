package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPendingList")]
	[Managed]
	
	public dynamic class PreferencesPendingList extends ModelBase
	{

		public function PreferencesPendingList() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPendingList";
		}
				
		public var visible:Boolean = false;
		public var columns:ColumnNames;
		public var columnOrder:int = 0;
		public var pastDueColor:String = "";
		public var readyForPickupColor:String = "";
		public var invoiceColor:String = "";
		public var estimateColor:String = "";
		public var listFont:FontDefinition;
		public var headerFont:FontDefinition;
	
	}
}