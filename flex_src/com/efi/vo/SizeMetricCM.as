package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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