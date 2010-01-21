package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ColumnNames")]

	public class ColumnNames extends ModelBase
	{

		public function ColumnNames() {
			remoteObjectName = "com.efi.printsmith.data.ColumnNames";
		}
				
		public var name:String = "";
	
	}
}