package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.InkColor")]
	[Managed]
	
	public dynamic class InkColor extends ModelBase
	{

		public function InkColor() {
			remoteObjectName = "com.efi.printsmith.data.InkColor";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}