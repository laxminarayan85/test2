package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Zip")]
	[Managed]
	public class Zip extends ModelBase
	{

		public function Zip() {
			remoteObjectName = "com.efi.printsmith.data.Zip";
		}
				
		public var name:String = "";
	
	}
}