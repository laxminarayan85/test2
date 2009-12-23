package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPendingList")]

	public class PreferencesPendingList extends ModelBase
	{

		public function PreferencesPendingList() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPendingList";
		}
				
		public var visible:Boolean = true;
		public var columns:ColumnNames;
	
	}
}