package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeMetricCM")]

	public class SizeMetricCM extends ModelBase
	{

		public function SizeMetricCM() {
			remoteObjectName = "com.efi.printsmith.data.SizeMetricCM";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}