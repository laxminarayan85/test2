package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DepositType")]
	[Managed]
	
	public dynamic class DepositType extends ModelBase
	{

		public function DepositType() {
			remoteObjectName = "com.efi.printsmith.data.DepositType";
		}
				
		public var name:String = "";
	
	}
}