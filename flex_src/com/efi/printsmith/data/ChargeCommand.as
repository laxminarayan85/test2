package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeCommand")]
	[Managed]
	
	public dynamic class ChargeCommand extends ModelBase
	{

		public function ChargeCommand() {
			remoteObjectName = "com.efi.printsmith.data.ChargeCommand";
		}
				
		public var children:ArrayCollection;
		public var name:String = "";
	
	}
}