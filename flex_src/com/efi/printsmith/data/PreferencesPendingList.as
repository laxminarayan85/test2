package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPendingList")]
	[Managed]
	
	public class PreferencesPendingList extends ModelBase
	{

		public function PreferencesPendingList() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPendingList";
		}
				
		public var visible:Boolean = false;
		public var columns:ColumnNames;
		public var columnOrder:int = 0;
	
	}
}