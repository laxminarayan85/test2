package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeInit")]
	[Managed]
	
	public dynamic class ChargeInit extends ModelBase
	{

		public function ChargeInit() {
			remoteObjectName = "com.efi.printsmith.data.ChargeInit";
		}
		public var isDeleted:Boolean=false;
				
	
	}
}