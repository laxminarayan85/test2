package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CostCenter")]
	[Managed]
	
	public dynamic class CostCenter extends ModelBase
	{

		public function CostCenter() {
			remoteObjectName = "com.efi.printsmith.data.CostCenter";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}