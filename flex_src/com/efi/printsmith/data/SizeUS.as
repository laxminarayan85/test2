package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SizeUS")]
	[Managed]
	
	public dynamic class SizeUS extends ModelBase
	{

		public function SizeUS() {
			remoteObjectName = "com.efi.printsmith.data.SizeUS";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}