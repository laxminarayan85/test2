package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ColumnNames")]

	public class ColumnNames extends ModelBase
	{

		public function ColumnNames() {
			remoteObjectName = "com.efi.printsmith.data.ColumnNames";
		}
				
		public var name:int = 0;
	
	}
}