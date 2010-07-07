package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CTPSubstrate")]
	[Managed]
	
	public dynamic class CTPSubstrate extends ModelBase
	{

		public function CTPSubstrate() {
			remoteObjectName = "com.efi.printsmith.data.CTPSubstrate";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}