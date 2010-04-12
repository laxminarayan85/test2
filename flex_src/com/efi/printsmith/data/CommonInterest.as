package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CommonInterest")]
	[Managed]
	public class CommonInterest extends ModelBase
	{

		public function CommonInterest() {
			remoteObjectName = "com.efi.printsmith.data.CommonInterest";
		}
				
		public var name:String = "";
	
	}
}