package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.BasicSize")]
	[Managed]
	
	public dynamic class BasicSize extends ModelBase
	{

		public function BasicSize() {
			remoteObjectName = "com.efi.printsmith.data.BasicSize";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}