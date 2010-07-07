package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TypeofWork")]
	[Managed]
	
	public dynamic class TypeofWork extends ModelBase
	{

		public function TypeofWork() {
			remoteObjectName = "com.efi.printsmith.data.TypeofWork";
		}
				
		public var name:String = "";
	
	}
}