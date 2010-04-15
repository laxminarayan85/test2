package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CostCenter")]
	[Managed]
	
	public class CostCenter extends ModelBase
	{

		public function CostCenter() {
			remoteObjectName = "com.efi.printsmith.data.CostCenter";
		}
				
		public var name:String = "";
	
	}
}