package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SizeMetricMM")]
	[Managed]
	
	public class SizeMetricMM extends ModelBase
	{

		public function SizeMetricMM() {
			remoteObjectName = "com.efi.printsmith.data.SizeMetricMM";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}