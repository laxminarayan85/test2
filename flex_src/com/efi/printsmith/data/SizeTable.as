package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SizeTable")]
	[Managed]
	
	public dynamic class SizeTable extends ModelBase
	{

		public function SizeTable() {
			remoteObjectName = "com.efi.printsmith.data.SizeTable";
		}
				
		public var name:int = 0;
	
	}
}