package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesStockDefinition")]
	[Managed]
	
	public dynamic class PreferencesStockDefinition extends ModelBase
	{

		public function PreferencesStockDefinition() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesStockDefinition";
		}
		public var isDeleted:Boolean=false;
				
		public var visible:Boolean = false;
		public var columns:ColumnNames;
		public var columnOrder:int = 0;
	
	}
}