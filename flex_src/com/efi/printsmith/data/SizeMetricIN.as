package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SizeMetricIN")]
	[Managed]
	
	public dynamic class SizeMetricIN extends ModelBase
	{

		public function SizeMetricIN() {
			remoteObjectName = "com.efi.printsmith.data.SizeMetricIN";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var size:String = "";
	
	}
}