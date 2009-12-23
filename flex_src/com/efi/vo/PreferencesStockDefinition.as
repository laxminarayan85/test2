package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesStockDefinition")]

	public class PreferencesStockDefinition extends ModelBase
	{

		public function PreferencesStockDefinition() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesStockDefinition";
		}
				
		public var visible:Boolean = true;
		public var columns:ColumnNames;
	
	}
}