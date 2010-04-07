package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeTable")]
	[Managed]
	public class SizeTable extends ModelBase
	{

		public function SizeTable() {
			remoteObjectName = "com.efi.printsmith.data.SizeTable";
		}
				
		public var name:int = 0;
	
	}
}