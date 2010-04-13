package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CostCenter")]

	public class CostCenter extends ModelBase
	{

		public function CostCenter() {
			remoteObjectName = "com.efi.printsmith.data.CostCenter";
		}
				
		public var name:String = "";
	
	}
}