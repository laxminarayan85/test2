package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeMetricIN")]

	public class SizeMetricIN extends ModelBase
	{

		public function SizeMetricIN() {
			remoteObjectName = "com.efi.printsmith.data.SizeMetricIN";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}