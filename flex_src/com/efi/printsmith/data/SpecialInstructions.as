package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SpecialInstructions")]
	[Managed]
	
	public dynamic class SpecialInstructions extends ModelBase
	{

		public function SpecialInstructions() {
			remoteObjectName = "com.efi.printsmith.data.SpecialInstructions";
		}
		public var isDeleted:Boolean=false;
				
		public var instructions:String = "";
	
	}
}