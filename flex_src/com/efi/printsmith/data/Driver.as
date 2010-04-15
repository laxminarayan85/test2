package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Driver")]
	[Managed]
	
	public class Driver extends ModelBase
	{

		public function Driver() {
			remoteObjectName = "com.efi.printsmith.data.Driver";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}