package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.HoldState")]
	[Managed]
	
	public class HoldState extends ModelBase
	{

		public function HoldState() {
			remoteObjectName = "com.efi.printsmith.data.HoldState";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}