package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SizeMetricCM")]
	[Managed]
	
	public dynamic class SizeMetricCM extends ModelBase
	{

		public function SizeMetricCM() {
			remoteObjectName = "com.efi.printsmith.data.SizeMetricCM";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}