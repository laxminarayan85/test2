package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.FoldTemplate")]
	[Managed]
	
	public dynamic class FoldTemplate extends ModelBase
	{

		public function FoldTemplate() {
			remoteObjectName = "com.efi.printsmith.data.FoldTemplate";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}