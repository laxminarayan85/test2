package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.RateTable")]

	public class RateTable extends ModelBase
	{

		public function RateTable() {
			remoteObjectName = "com.efi.printsmith.data.RateTable";
		}
				
		public var name:String = "";
	
	}
}