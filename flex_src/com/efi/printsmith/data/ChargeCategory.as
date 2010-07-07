package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeCategory")]
	[Managed]
	
	public dynamic class ChargeCategory extends ModelBase
	{

		public function ChargeCategory() {
			remoteObjectName = "com.efi.printsmith.data.ChargeCategory";
		}
				
		public var children:ArrayCollection;
		public var name:String = "";
		public var parent:ChargeCommand;
	
	}
}